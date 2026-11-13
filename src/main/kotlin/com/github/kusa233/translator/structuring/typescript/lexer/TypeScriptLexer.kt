package com.github.kusa233.translator.structuring.typescript.lexer

import com.github.kusa233.translator.structuring.api.SourcePosition
import com.github.kusa233.translator.structuring.api.SourceSpan
import com.github.kusa233.translator.structuring.api.SyntaxException

/**
 * A hand written lexical analyser for ECMAScript 2015 plus the TypeScript extensions.
 *
 * The token stream keeps [TokenType.NEWLINE] and [TokenType.COMMENT] tokens; the parser filters them but
 * uses them for automatic semicolon insertion. Template literals are produced as a head / middle / tail
 * sequence, with the code inside `${ ... }` tokenised normally (a small stack is needed, since templates
 * nest inside substitutions).
 *
 * Regex literals and division share the `/` character; the lexer decides by looking at the previous
 * significant token, the same heuristic real world JavaScript engines apply.
 */
class TypeScriptLexer(
    private val source: String,
    private val fileName: String? = null,
) {
    private var index: Int = 0
    private var line: Int = 1
    private var column: Int = 1

    private val tokens = ArrayList<Token>()

    /** Brace depth of ordinary `{`, used to find the `}` that ends a template substitution. */
    private var braceDepth: Int = 0

    /** Brace depth recorded for each open template substitution. */
    private val templateStack = ArrayDeque<Int>()

    /** The last emitted token that is not trivia. */
    private var previousSignificant: Token? = null

    /** True when a line terminator was seen since the last significant token. */
    private var pendingLineBreak: Boolean = false

    /** Tokenises the whole source and appends an [TokenType.EOF] token. */
    fun tokenize(): List<Token> {
        while (index < source.length) {
            if (templateStack.isNotEmpty() && templateStack.last() == braceDepth && peek() == '}') {
                readTemplateContinuation()
                continue
            }

            val c = peek()

            if (isLineTerminator(c)) {
                readLineBreak()
                continue
            }
            if (c == ' ' || c == '\t' || c == '\u000B' || c == '\u000C' || c == '\u00A0' || c == '\uFEFF') {
                advance()
                continue
            }
            if (c == '/' && (peekAt(1) == '/' || peekAt(1) == '*')) {
                readComment()
                continue
            }
            if (c == '`') {
                readTemplateStart()
                continue
            }
            if (c == '"' || c == '\'') {
                readString(c)
                continue
            }
            if (c.isDigit() || (c == '.' && peekAt(1).isDigit())) {
                readNumber()
                continue
            }
            if (c == '/' && isRegexAllowed()) {
                readRegex()
                continue
            }
            if (isIdentifierStart(c)) {
                readWord()
                continue
            }
            if (readPunctuator()) {
                continue
            }

            val position = SourcePosition(index, line, column)
            throw SyntaxException(
                stage = "lexer",
                message = "Unexpected character '${printable(c)}'",
                span = SourceSpan(position, SourcePosition(index + 1, line, column + 1)),
            )
        }

        tokens.add(Token.eof(index, line, column))
        return tokens
    }

    // ------------------------------------------------------------------ trivia

    private fun readLineBreak() {
        val startIndex = index
        val startLine = line
        val startColumn = column
        val c = advance()
        if (c == '\r' && index < source.length && peek() == '\n') {
            advance()
        }
        pendingLineBreak = true
        emit(TokenType.NEWLINE, startIndex, startLine, startColumn, null)
    }

    private fun readComment() {
        val startIndex = index
        val startLine = line
        val startColumn = column

        if (peekAt(1) == '/') {
            while (index < source.length && !isLineTerminator(peek())) {
                advance()
            }
        } else {
            advance() // '/'
            advance() // '*'
            var closed = false
            while (index < source.length) {
                val c = peek()
                if (c == '*' && peekAt(1) == '/') {
                    advance()
                    advance()
                    closed = true
                    break
                }
                if (isLineTerminator(c)) {
                    pendingLineBreak = true
                }
                advance()
            }
            if (!closed) {
                throw SyntaxException(
                    stage = "lexer",
                    message = "Unterminated block comment",
                    span = SourceSpan(
                        SourcePosition(startIndex, startLine, startColumn),
                        SourcePosition(index, line, column),
                    ),
                )
            }
        }

        emit(TokenType.COMMENT, startIndex, startLine, startColumn, source.substring(startIndex, index))
    }

    // ------------------------------------------------------------------ words

    private fun readWord() {
        val startIndex = index
        val startLine = line
        val startColumn = column
        while (index < source.length && isIdentifierPart(peek())) {
            advance()
        }
        val text = source.substring(startIndex, index)
        val keyword = Keyword.of(text)
        if (keyword == null) {
            emit(TokenType.IDENTIFIER, startIndex, startLine, startColumn, text)
        } else {
            emit(TokenType.KEYWORD, startIndex, startLine, startColumn, text, keyword)
        }
    }

    // ------------------------------------------------------------------ numbers

    private fun readNumber() {
        val startIndex = index
        val startLine = line
        val startColumn = column
        var radix = 10
        var isFloat = false

        val isPrefixed = peek() == '0' && index + 1 < source.length &&
            peekAt(1).lowercaseChar() in listOf('x', 'b', 'o')

        if (isPrefixed) {
            when (peekAt(1).lowercaseChar()) {
                'x' -> {
                    radix = 16
                    advance()
                    advance()
                    consumeDigits { isHexDigit(it) || it == '_' }
                }

                'b' -> {
                    radix = 2
                    advance()
                    advance()
                    consumeDigits { it == '0' || it == '1' || it == '_' }
                }

                else -> {
                    radix = 8
                    advance()
                    advance()
                    consumeDigits { it in '0'..'7' || it == '_' }
                }
            }
        } else {
            consumeDigits { it.isDigit() || it == '_' }
            if (peek() == '.' && peekAt(1).isDigit()) {
                isFloat = true
                advance()
                consumeDigits { it.isDigit() || it == '_' }
            } else if (peek() == '.' && !isIdentifierStart(peekAt(1))) {
                // `1.` is a valid float literal.
                isFloat = true
                advance()
            }
            if (peek() == 'e' || peek() == 'E') {
                val saveIndex = index
                val saveLine = line
                val saveColumn = column
                advance()
                if (peek() == '+' || peek() == '-') {
                    advance()
                }
                if (peek().isDigit()) {
                    isFloat = true
                    consumeDigits { it.isDigit() || it == '_' }
                } else {
                    index = saveIndex
                    line = saveLine
                    column = saveColumn
                }
            }
        }

        var isBigInt = false
        if (index < source.length && peek() == 'n') {
            isBigInt = true
            advance()
        }

        val raw = source.substring(startIndex, index)
        val digits = raw.removeSuffix("n").replace("_", "")
        val value = parseNumeric(digits, radix, raw, startIndex, startLine, startColumn)
        emit(
            TokenType.NUMERIC_LITERAL,
            startIndex,
            startLine,
            startColumn,
            NumericValue(raw, value, isBigInt),
        )
    }

    private inline fun consumeDigits(predicate: (Char) -> Boolean) {
        while (index < source.length && predicate(peek())) {
            advance()
        }
    }

    private fun parseNumeric(
        digits: String,
        radix: Int,
        raw: String,
        startIndex: Int,
        startLine: Int,
        startColumn: Int,
    ): Double {
        // A prefixed literal keeps its radix marker in the raw text, so strip it before handing the digits to
        // the radix aware parser.
        val body = if (radix == 10) digits else digits.drop(2)
        return try {
            when (radix) {
                16 -> body.toLong(16).toDouble()
                8 -> body.toLong(8).toDouble()
                2 -> body.toLong(2).toDouble()
                else -> body.toDouble()
            }
        } catch (e: NumberFormatException) {
            throw SyntaxException(
                stage = "lexer",
                message = "Malformed numeric literal '$raw'",
                span = SourceSpan(
                    SourcePosition(startIndex, startLine, startColumn),
                    SourcePosition(index, line, column),
                ),
            )
        }
    }

    // ------------------------------------------------------------------ strings

    private fun readString(quote: Char) {
        val startIndex = index
        val startLine = line
        val startColumn = column
        advance() // opening quote

        val cooked = StringBuilder()
        while (true) {
            if (index >= source.length) {
                throw SyntaxException(
                    stage = "lexer",
                    message = "Unterminated string literal",
                    span = SourceSpan(
                        SourcePosition(startIndex, startLine, startColumn),
                        SourcePosition(index, line, column),
                    ),
                )
            }
            val c = peek()
            if (c == quote) {
                advance()
                break
            }
            if (isLineTerminator(c)) {
                throw SyntaxException(
                    stage = "lexer",
                    message = "Unterminated string literal",
                    span = SourceSpan(
                        SourcePosition(startIndex, startLine, startColumn),
                        SourcePosition(index, line, column),
                    ),
                )
            }
            if (c == '\\') {
                cooked.append(readEscape(startIndex, startLine, startColumn))
                continue
            }
            cooked.append(c)
            advance()
        }

        emit(
            TokenType.STRING_LITERAL,
            startIndex,
            startLine,
            startColumn,
            StringChunk(cooked.toString(), quote),
        )
    }

    /** Decodes one escape sequence starting at a backslash and advances past it. */
    private fun readEscape(startIndex: Int, startLine: Int, startColumn: Int): String {
        advance() // '\'
        if (index >= source.length) {
            throw SyntaxException(
                stage = "lexer",
                message = "Unterminated escape sequence",
                span = SourceSpan(
                    SourcePosition(startIndex, startLine, startColumn),
                    SourcePosition(index, line, column),
                ),
            )
        }
        return when (val e = peek()) {
            'n' -> {
                advance()
                "\n"
            }

            't' -> {
                advance()
                "\t"
            }

            'r' -> {
                advance()
                "\r"
            }

            'b' -> {
                advance()
                "\b"
            }

            'f' -> {
                advance()
                "\u000C"
            }

            'v' -> {
                advance()
                "\u000B"
            }

            '0' -> {
                if (peekAt(1).isDigit()) {
                    throw SyntaxException(
                        stage = "lexer",
                        message = "Legacy octal escape sequences are not supported",
                        span = SourceSpan(
                            SourcePosition(startIndex, startLine, startColumn),
                            SourcePosition(index + 2, line, column + 2),
                        ),
                    )
                }
                advance()
                "\u0000"
            }

            'x' -> {
                advance()
                readHex(2, startIndex, startLine, startColumn).toInt(16).toChar().toString()
            }

            'u' -> {
                advance()
                readUnicodeEscape(startIndex, startLine, startColumn)
            }

            '\r' -> {
                advance()
                if (peek() == '\n') {
                    advance()
                }
                ""
            }

            '\n' -> {
                advance()
                ""
            }

            else -> {
                advance()
                e.toString()
            }
        }
    }

    private fun readUnicodeEscape(startIndex: Int, startLine: Int, startColumn: Int): String {
        if (peek() != '{') {
            return readHex(4, startIndex, startLine, startColumn).toInt(16).toChar().toString()
        }

        advance() // '{'
        val builder = StringBuilder()
        while (index < source.length && peek() != '}') {
            builder.append(peek())
            advance()
        }
        if (peek() != '}') {
            throw SyntaxException(
                stage = "lexer",
                message = "Unterminated unicode escape",
                span = SourceSpan(
                    SourcePosition(startIndex, startLine, startColumn),
                    SourcePosition(index, line, column),
                ),
            )
        }
        advance()
        val codePoint = builder.toString().toIntOrNull(16)
            ?: throw SyntaxException(
                stage = "lexer",
                message = "Malformed unicode escape '\\u{$builder}'",
                span = SourceSpan(
                    SourcePosition(startIndex, startLine, startColumn),
                    SourcePosition(index, line, column),
                ),
            )
        return String(Character.toChars(codePoint))
    }

    private fun readHex(count: Int, startIndex: Int, startLine: Int, startColumn: Int): String {
        val builder = StringBuilder()
        repeat(count) {
            if (index >= source.length || !isHexDigit(peek())) {
                throw SyntaxException(
                    stage = "lexer",
                    message = "Malformed hexadecimal escape sequence",
                    span = SourceSpan(
                        SourcePosition(startIndex, startLine, startColumn),
                        SourcePosition(index, line, column),
                    ),
                )
            }
            builder.append(peek())
            advance()
        }
        return builder.toString()
    }

    // ------------------------------------------------------------------ templates

    private fun readTemplateStart() {
        val startIndex = index
        val startLine = line
        val startColumn = column
        advance() // '`'

        val chunk = scanTemplateChunk()

        if (peek() == '`') {
            advance()
            emit(TokenType.TEMPLATE_NO_SUBST, startIndex, startLine, startColumn, chunk)
            return
        }

        consumeSubstitutionOpen()
        emit(TokenType.TEMPLATE_HEAD, startIndex, startLine, startColumn, chunk)
    }

    private fun readTemplateContinuation() {
        val startIndex = index
        val startLine = line
        val startColumn = column
        advance() // '}'
        templateStack.removeLast()

        val chunk = scanTemplateChunk()

        if (peek() == '`') {
            advance()
            emit(TokenType.TEMPLATE_TAIL, startIndex, startLine, startColumn, chunk)
            return
        }

        consumeSubstitutionOpen()
        emit(TokenType.TEMPLATE_MIDDLE, startIndex, startLine, startColumn, chunk)
    }

    private fun consumeSubstitutionOpen() {
        advance() // '$'
        advance() // '{'
        templateStack.addLast(braceDepth)
    }

    /**
     * Scans raw template text and returns its decoded chunk, leaving the cursor on the closing '`' or on
     * the `$` that opens the next substitution.
     */
    private fun scanTemplateChunk(): TemplateChunk {
        val startIndex = index
        val startLine = line
        val startColumn = column

        while (true) {
            if (index >= source.length) {
                throw SyntaxException(
                    stage = "lexer",
                    message = "Unterminated template literal",
                    span = SourceSpan(
                        SourcePosition(startIndex, startLine, startColumn),
                        SourcePosition(index, line, column),
                    ),
                )
            }
            val c = peek()
            if (c == '\\') {
                advance()
                if (index < source.length) {
                    advance()
                }
                continue
            }
            if (c == '`' || (c == '$' && peekAt(1) == '{')) {
                break
            }
            advance()
        }

        val raw = source.substring(startIndex, index)
        return TemplateChunk(raw, decodeTemplateChunk(raw))
    }

    private fun decodeTemplateChunk(raw: String): String {
        if ('\\' !in raw) {
            return raw
        }
        val builder = StringBuilder(raw.length)
        var i = 0
        while (i < raw.length) {
            val c = raw[i]
            if (c != '\\') {
                builder.append(c)
                i++
                continue
            }
            i++
            if (i >= raw.length) {
                break
            }
            when (val e = raw[i]) {
                'n' -> {
                    builder.append('\n')
                    i++
                }

                't' -> {
                    builder.append('\t')
                    i++
                }

                'r' -> {
                    builder.append('\r')
                    i++
                }

                'b' -> {
                    builder.append('\b')
                    i++
                }

                'f' -> {
                    builder.append('\u000C')
                    i++
                }

                'v' -> {
                    builder.append('\u000B')
                    i++
                }

                '0' -> {
                    builder.append('\u0000')
                    i++
                }

                '\r' -> {
                    i++
                    if (i < raw.length && raw[i] == '\n') {
                        i++
                    }
                }

                '\n' -> i++

                'x' -> {
                    val hex = raw.substring(i + 1, minOf(i + 3, raw.length))
                    val code = hex.toIntOrNull(16)
                    if (code == null) {
                        builder.append('x')
                        i++
                    } else {
                        builder.append(code.toChar())
                        i += 3
                    }
                }

                'u' -> {
                    if (i + 1 < raw.length && raw[i + 1] == '{') {
                        val close = raw.indexOf('}', i + 1)
                        val hex = if (close < 0) "" else raw.substring(i + 2, close)
                        val code = hex.toIntOrNull(16)
                        if (code == null) {
                            builder.append('u')
                            i++
                        } else {
                            builder.append(String(Character.toChars(code)))
                            i = close + 1
                        }
                    } else {
                        val hex = raw.substring(i + 1, minOf(i + 5, raw.length))
                        val code = hex.toIntOrNull(16)
                        if (code == null) {
                            builder.append('u')
                            i++
                        } else {
                            builder.append(code.toChar())
                            i += 5
                        }
                    }
                }

                else -> {
                    builder.append(e)
                    i++
                }
            }
        }
        return builder.toString()
    }

    // ------------------------------------------------------------------ regex

    private fun readRegex() {
        val startIndex = index
        val startLine = line
        val startColumn = column
        advance() // '/'

        val pattern = StringBuilder()
        var inClass = false
        while (true) {
            if (index >= source.length || isLineTerminator(peek())) {
                throw SyntaxException(
                    stage = "lexer",
                    message = "Unterminated regular expression literal",
                    span = SourceSpan(
                        SourcePosition(startIndex, startLine, startColumn),
                        SourcePosition(index, line, column),
                    ),
                )
            }
            val c = peek()
            if (c == '\\') {
                pattern.append(c)
                advance()
                if (index < source.length) {
                    pattern.append(peek())
                    advance()
                }
                continue
            }
            if (c == '[') {
                inClass = true
            } else if (c == ']') {
                inClass = false
            } else if (c == '/' && !inClass) {
                advance()
                break
            }
            pattern.append(c)
            advance()
        }

        val flags = StringBuilder()
        while (index < source.length && isIdentifierPart(peek())) {
            flags.append(peek())
            advance()
        }

        emit(
            TokenType.REGEX_LITERAL,
            startIndex,
            startLine,
            startColumn,
            RegexChunk(pattern.toString(), flags.toString()),
        )
    }

    /** A `/` starts a regex unless the previous significant token can end an expression. */
    private fun isRegexAllowed(): Boolean {
        val previous = previousSignificant ?: return true
        return when (previous.type) {
            TokenType.IDENTIFIER,
            TokenType.NUMERIC_LITERAL,
            TokenType.STRING_LITERAL,
            TokenType.REGEX_LITERAL,
            TokenType.TEMPLATE_TAIL,
            TokenType.TEMPLATE_NO_SUBST,
            TokenType.CLOSE_PAREN,
            TokenType.CLOSE_BRACKET,
            TokenType.CLOSE_BRACE,
            TokenType.PLUS_PLUS,
            TokenType.MINUS_MINUS,
            -> false

            TokenType.KEYWORD -> when (previous.keyword) {
                Keyword.THIS, Keyword.SUPER, Keyword.TRUE, Keyword.FALSE, Keyword.NULL, Keyword.UNDEFINED -> false
                else -> true
            }

            else -> true
        }
    }

    // ------------------------------------------------------------------ punctuation

    private fun readPunctuator(): Boolean {
        for ((text, type) in PUNCTUATORS) {
            if (!source.startsWith(text, index)) {
                continue
            }
            if (type == TokenType.QUESTION_DOT && peekAt(text.length).isDigit()) {
                continue
            }
            val startIndex = index
            val startLine = line
            val startColumn = column
            repeat(text.length) { advance() }
            emit(type, startIndex, startLine, startColumn, null)
            when (type) {
                TokenType.OPEN_BRACE -> braceDepth++
                TokenType.CLOSE_BRACE -> braceDepth = maxOf(0, braceDepth - 1)
                else -> Unit
            }
            return true
        }
        return false
    }

    // ------------------------------------------------------------------ cursor

    private fun peek(): Char = if (index < source.length) source[index] else '\u0000'

    private fun peekAt(offset: Int): Char {
        val at = index + offset
        return if (at < source.length) source[at] else '\u0000'
    }

    private fun advance(): Char {
        val c = source[index]
        index++
        if (c == '\n' || c == '\r' || c == '\u2028' || c == '\u2029') {
            line++
            column = 1
        } else {
            column++
        }
        return c
    }

    /**
     * Appends one token. Trivia keeps the pending line break flag, so the next significant token knows
     * whether a line terminator separates it from its predecessor.
     */
    private fun emit(
        type: TokenType,
        startIndex: Int,
        startLine: Int,
        startColumn: Int,
        value: Any?,
        keyword: Keyword? = null,
    ) {
        val endIndex = minOf(index, source.length)
        val token = Token(
            type = type,
            text = source.substring(startIndex, endIndex),
            span = SourceSpan(
                SourcePosition(startIndex, startLine, startColumn),
                SourcePosition(endIndex, line, column),
            ),
            keyword = keyword,
            value = value,
            precededByLineBreak = pendingLineBreak,
        )
        tokens.add(token)
        if (type != TokenType.NEWLINE && type != TokenType.COMMENT) {
            previousSignificant = token
            pendingLineBreak = false
        }
    }

    companion object {
        private val PUNCTUATORS: List<Pair<String, TokenType>> = listOf(
            ">>>=" to TokenType.GREATER_GREATER_GREATER_EQUALS,
            "..." to TokenType.DOT_DOT_DOT,
            "===" to TokenType.EQUALS_EQUALS_EQUALS,
            "!==" to TokenType.EXCLAMATION_EQUALS_EQUALS,
            "**=" to TokenType.STAR_STAR_EQUALS,
            ">>>" to TokenType.GREATER_GREATER_GREATER,
            "<<=" to TokenType.LESS_LESS_EQUALS,
            ">>=" to TokenType.GREATER_GREATER_EQUALS,
            "&&=" to TokenType.AMPERSAND_AMPERSAND_EQUALS,
            "||=" to TokenType.PIPE_PIPE_EQUALS,
            "??=" to TokenType.QUESTION_QUESTION_EQUALS,
            "=>" to TokenType.ARROW,
            "?." to TokenType.QUESTION_DOT,
            "==" to TokenType.EQUALS_EQUALS,
            "!=" to TokenType.EXCLAMATION_EQUALS,
            "<=" to TokenType.LESS_EQUALS,
            ">=" to TokenType.GREATER_EQUALS,
            "&&" to TokenType.AMPERSAND_AMPERSAND,
            "||" to TokenType.PIPE_PIPE,
            "??" to TokenType.QUESTION_QUESTION,
            "+=" to TokenType.PLUS_EQUALS,
            "-=" to TokenType.MINUS_EQUALS,
            "*=" to TokenType.STAR_EQUALS,
            "/=" to TokenType.SLASH_EQUALS,
            "%=" to TokenType.PERCENT_EQUALS,
            "&=" to TokenType.AMPERSAND_EQUALS,
            "|=" to TokenType.PIPE_EQUALS,
            "^=" to TokenType.CARET_EQUALS,
            "++" to TokenType.PLUS_PLUS,
            "--" to TokenType.MINUS_MINUS,
            "**" to TokenType.STAR_STAR,
            "<<" to TokenType.LESS_LESS,
            ">>" to TokenType.GREATER_GREATER,
            "{" to TokenType.OPEN_BRACE,
            "}" to TokenType.CLOSE_BRACE,
            "(" to TokenType.OPEN_PAREN,
            ")" to TokenType.CLOSE_PAREN,
            "[" to TokenType.OPEN_BRACKET,
            "]" to TokenType.CLOSE_BRACKET,
            ";" to TokenType.SEMICOLON,
            "," to TokenType.COMMA,
            "." to TokenType.DOT,
            ":" to TokenType.COLON,
            "?" to TokenType.QUESTION,
            "~" to TokenType.TILDE,
            "!" to TokenType.BANG,
            "+" to TokenType.PLUS,
            "-" to TokenType.MINUS,
            "*" to TokenType.STAR,
            "/" to TokenType.SLASH,
            "%" to TokenType.PERCENT,
            "&" to TokenType.AMPERSAND,
            "|" to TokenType.PIPE,
            "^" to TokenType.CARET,
            "<" to TokenType.LESS,
            ">" to TokenType.GREATER,
            "=" to TokenType.EQUALS,
            "@" to TokenType.AT,
            "#" to TokenType.HASH,
        )

        private fun isLineTerminator(c: Char): Boolean =
            c == '\n' || c == '\r' || c == '\u2028' || c == '\u2029'

        private fun isIdentifierStart(c: Char): Boolean =
            c == '_' || c == '$' || c.isLetter() || (c.code > 127 && Character.isUnicodeIdentifierStart(c))

        private fun isIdentifierPart(c: Char): Boolean =
            c == '_' || c == '$' || c.isLetterOrDigit() ||
                (c.code > 127 && Character.isUnicodeIdentifierPart(c))

        private fun isHexDigit(c: Char): Boolean =
            c in '0'..'9' || c in 'a'..'f' || c in 'A'..'F'

        private fun printable(c: Char): String =
            if (c.code in 32..126) c.toString() else "\\u%04x".format(c.code)
    }
}
