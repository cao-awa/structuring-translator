package com.github.kusa233.translator.structuring.typescript.parser

import com.github.kusa233.translator.structuring.api.LanguageParser
import com.github.kusa233.translator.structuring.api.LanguageType
import com.github.kusa233.translator.structuring.api.SourcePosition
import com.github.kusa233.translator.structuring.api.SourceSpan
import com.github.kusa233.translator.structuring.api.SyntaxException
import com.github.kusa233.translator.structuring.api.ast.TranslationUnit
import com.github.kusa233.translator.structuring.typescript.ast.AmbientDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.ArrayLiteral
import com.github.kusa233.translator.structuring.typescript.ast.ArrayTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.ArrowBody
import com.github.kusa233.translator.structuring.typescript.ast.ArrowFunction
import com.github.kusa233.translator.structuring.typescript.ast.AsExpression
import com.github.kusa233.translator.structuring.typescript.ast.AssignmentExpression
import com.github.kusa233.translator.structuring.typescript.ast.BinaryExpression
import com.github.kusa233.translator.structuring.typescript.ast.BlockBody
import com.github.kusa233.translator.structuring.typescript.ast.BlockStatement
import com.github.kusa233.translator.structuring.typescript.ast.BooleanLiteral
import com.github.kusa233.translator.structuring.typescript.ast.CallExpression
import com.github.kusa233.translator.structuring.typescript.ast.CatchClause
import com.github.kusa233.translator.structuring.typescript.ast.ClassDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.ClassExpression
import com.github.kusa233.translator.structuring.typescript.ast.ClassMemberNode
import com.github.kusa233.translator.structuring.typescript.ast.Comment
import com.github.kusa233.translator.structuring.typescript.ast.CommentKind
import com.github.kusa233.translator.structuring.typescript.ast.CommentStatement
import com.github.kusa233.translator.structuring.typescript.ast.ConditionalExpression
import com.github.kusa233.translator.structuring.typescript.ast.ConditionalTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.DoWhileStatement
import com.github.kusa233.translator.structuring.typescript.ast.EmptyStatement
import com.github.kusa233.translator.structuring.typescript.ast.EnumDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.EnumMemberNode
import com.github.kusa233.translator.structuring.typescript.ast.Expression
import com.github.kusa233.translator.structuring.typescript.ast.ExpressionBody
import com.github.kusa233.translator.structuring.typescript.ast.ExpressionStatement
import com.github.kusa233.translator.structuring.typescript.ast.ExportDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.ExportSpecifier
import com.github.kusa233.translator.structuring.typescript.ast.FieldMemberNode
import com.github.kusa233.translator.structuring.typescript.ast.ForInStatement
import com.github.kusa233.translator.structuring.typescript.ast.ForOfStatement
import com.github.kusa233.translator.structuring.typescript.ast.ForStatement
import com.github.kusa233.translator.structuring.typescript.ast.FunctionBody
import com.github.kusa233.translator.structuring.typescript.ast.FunctionDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.FunctionExpression
import com.github.kusa233.translator.structuring.typescript.ast.FunctionTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.Identifier
import com.github.kusa233.translator.structuring.typescript.ast.IfStatement
import com.github.kusa233.translator.structuring.typescript.ast.ImportDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.ImportSpecifier
import com.github.kusa233.translator.structuring.typescript.ast.IndexedAccessTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.InstantiationExpression
import com.github.kusa233.translator.structuring.typescript.ast.InterfaceDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.IntersectionTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.JumpStatement
import com.github.kusa233.translator.structuring.typescript.ast.KeywordTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.LabeledStatement
import com.github.kusa233.translator.structuring.typescript.ast.LiteralTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.LogicalExpression
import com.github.kusa233.translator.structuring.typescript.ast.MemberExpression
import com.github.kusa233.translator.structuring.typescript.ast.MethodKind
import com.github.kusa233.translator.structuring.typescript.ast.MethodMember
import com.github.kusa233.translator.structuring.typescript.ast.MethodMemberNode
import com.github.kusa233.translator.structuring.typescript.ast.NamespaceDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.NewExpression
import com.github.kusa233.translator.structuring.typescript.ast.NonNullExpression
import com.github.kusa233.translator.structuring.typescript.ast.NullLiteral
import com.github.kusa233.translator.structuring.typescript.ast.NumericLiteral
import com.github.kusa233.translator.structuring.typescript.ast.ObjectLiteral
import com.github.kusa233.translator.structuring.typescript.ast.ObjectMember
import com.github.kusa233.translator.structuring.typescript.ast.ObjectTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.ParameterNode
import com.github.kusa233.translator.structuring.typescript.ast.ParenthesizedExpression
import com.github.kusa233.translator.structuring.typescript.ast.ParenthesizedTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.PropertyMember
import com.github.kusa233.translator.structuring.typescript.ast.RegexLiteral
import com.github.kusa233.translator.structuring.typescript.ast.ReturnStatement
import com.github.kusa233.translator.structuring.typescript.ast.SatisfiesExpression
import com.github.kusa233.translator.structuring.typescript.ast.SequenceExpression
import com.github.kusa233.translator.structuring.typescript.ast.ShorthandPropertyMember
import com.github.kusa233.translator.structuring.typescript.ast.SourceFile
import com.github.kusa233.translator.structuring.typescript.ast.SpecialExpression
import com.github.kusa233.translator.structuring.typescript.ast.SpreadElement
import com.github.kusa233.translator.structuring.typescript.ast.SpreadPropertyMember
import com.github.kusa233.translator.structuring.typescript.ast.Statement
import com.github.kusa233.translator.structuring.typescript.ast.StringLiteral
import com.github.kusa233.translator.structuring.typescript.ast.SwitchCase
import com.github.kusa233.translator.structuring.typescript.ast.SwitchStatement
import com.github.kusa233.translator.structuring.typescript.ast.TaggedTemplateExpression
import com.github.kusa233.translator.structuring.typescript.ast.TemplateElement
import com.github.kusa233.translator.structuring.typescript.ast.TemplateLiteral
import com.github.kusa233.translator.structuring.typescript.ast.ThrowStatement
import com.github.kusa233.translator.structuring.typescript.ast.TryStatement
import com.github.kusa233.translator.structuring.typescript.ast.TupleTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.TypeAliasDeclaration
import com.github.kusa233.translator.structuring.typescript.ast.TypeAssertionExpression
import com.github.kusa233.translator.structuring.typescript.ast.TypeMemberNode
import com.github.kusa233.translator.structuring.typescript.ast.TypeNode
import com.github.kusa233.translator.structuring.typescript.ast.TypeOperatorNode
import com.github.kusa233.translator.structuring.typescript.ast.TypeQueryNode
import com.github.kusa233.translator.structuring.typescript.ast.TypeReferenceNode
import com.github.kusa233.translator.structuring.typescript.ast.UndefinedLiteral
import com.github.kusa233.translator.structuring.typescript.ast.UnionTypeNode
import com.github.kusa233.translator.structuring.typescript.ast.UnaryExpression
import com.github.kusa233.translator.structuring.typescript.ast.UpdateExpression
import com.github.kusa233.translator.structuring.typescript.ast.VariableDeclarator
import com.github.kusa233.translator.structuring.typescript.ast.VariableKind
import com.github.kusa233.translator.structuring.typescript.ast.VariableStatement
import com.github.kusa233.translator.structuring.typescript.ast.WhileStatement
import com.github.kusa233.translator.structuring.typescript.ast.YieldExpression
import com.github.kusa233.translator.structuring.typescript.lexer.Keyword
import com.github.kusa233.translator.structuring.typescript.lexer.NumericValue
import com.github.kusa233.translator.structuring.typescript.lexer.RegexChunk
import com.github.kusa233.translator.structuring.typescript.lexer.StringChunk
import com.github.kusa233.translator.structuring.typescript.lexer.TemplateChunk
import com.github.kusa233.translator.structuring.typescript.lexer.Token
import com.github.kusa233.translator.structuring.typescript.lexer.TokenType
import com.github.kusa233.translator.structuring.typescript.lexer.TypeScriptLexer

/**
 * Recursive descent parser for ECMAScript 2015 plus the TypeScript type syntax.
 *
 * The parser consumes the significant token stream of [TypeScriptLexer] and rebuilds the trivia that
 * matters: line breaks drive automatic semicolon insertion through [Token.precededByLineBreak], and
 * comments are re attached as [CommentStatement] nodes so an emitter can keep them.
 *
 * Failures are reported as [SyntaxException] carrying the offending span.
 */
class TypeScriptParser : LanguageParser {
    override val languageType: LanguageType = LanguageType.TYPESCRIPT

    private var source: String = ""
    private var tokens: MutableList<Token> = mutableListOf()
    private var position: Int = 0
    private var comments: List<Comment> = emptyList()
    private var commentIndex: Int = 0

    override fun parse(source: String, fileName: String?): TranslationUnit {
        this.source = source
        val lexed = TypeScriptLexer(source, fileName).tokenize()

        comments = lexed
            .filter { it.type == TokenType.COMMENT }
            .map { toComment(it) }
        commentIndex = 0

        tokens = lexed
            .filter { it.type != TokenType.COMMENT && it.type != TokenType.NEWLINE && it.type != TokenType.WHITESPACE }
            .toMutableList()
        position = 0

        if (tokens.isEmpty()) {
            throw SyntaxException("parser", "The lexer produced no tokens", SourceSpan.NONE)
        }

        val statements = parseStatementListUntil(TokenType.EOF).toMutableList()
        flushComments(statements)
        expect(TokenType.EOF, "end of file")

        val span = SourceSpan(tokens.first().span.start, tokens.last().span.end)
        return SourceFile(statements, fileName, languageType, span)
    }

    // ------------------------------------------------------------------ cursor

    private val current: Token get() = tokens[position.coerceAtMost(tokens.size - 1)]

    private fun peekToken(offset: Int): Token = tokens[(position + offset).coerceIn(0, tokens.size - 1)]

    private fun previousToken(): Token = tokens[(position - 1).coerceAtLeast(0)]

    private fun advance(): Token {
        val token = current
        if (position < tokens.size - 1) {
            position++
        }
        return token
    }

    private fun check(type: TokenType): Boolean = current.type == type

    private fun checkKeyword(keyword: Keyword): Boolean = current.type == TokenType.KEYWORD && current.keyword == keyword

    private fun checkKeywordIfLike(keyword: Keyword): Boolean = checkKeyword(keyword)

    private fun match(type: TokenType): Boolean {
        if (!check(type)) {
            return false
        }
        advance()
        return true
    }

    /** True when the current token is the identifier [text]; contextual words such as `get` live here. */
    private fun checkWord(text: String): Boolean =
        (current.type == TokenType.IDENTIFIER || current.type == TokenType.KEYWORD) && current.text == text

    private fun matchKeyword(keyword: Keyword): Boolean {
        if (!checkKeyword(keyword)) {
            return false
        }
        advance()
        return true
    }

    private fun matchIdentifier(text: String): Boolean {
        if (current.type != TokenType.IDENTIFIER || current.text != text) {
            return false
        }
        advance()
        return true
    }

    private fun expect(type: TokenType, what: String): Token {
        if (!check(type)) {
            throw unexpected("expected $what")
        }
        return advance()
    }

    private fun expectKeyword(keyword: Keyword): Token {
        if (!checkKeyword(keyword)) {
            throw unexpected("expected '${keyword.text}'")
        }
        return advance()
    }

    private fun unexpected(message: String): SyntaxException {
        val token = current
        val found = if (token.type == TokenType.EOF) "end of file" else "'${token.text}'"
        return SyntaxException(
            stage = "parser",
            message = "Unexpected $found: $message",
            span = token.span,
        )
    }

    private fun spanOf(start: Token): SourceSpan {
        if (position == 0) {
            return start.span
        }
        return SourceSpan(start.span.start, previousToken().span.end)
    }

    private fun spanBetween(start: Token, end: Token): SourceSpan =
        SourceSpan(start.span.start, end.span.end)

    /** Runs [block] and rewinds the cursor when it throws, so callers can fall back to another rule. */
    private fun <T> speculate(block: () -> T?): T? {
        val saved = position
        return try {
            block()
        } catch (e: SyntaxException) {
            position = saved
            null
        }
    }

    // ------------------------------------------------------------------ trivia

    private fun toComment(token: Token): Comment {
        val text = token.text
        val kind = when {
            text.startsWith("///") -> CommentKind.TRIPLE_SLASH
            text.startsWith("/**") && text != "/**/" -> CommentKind.JSDOC
            text.startsWith("/*") -> CommentKind.BLOCK
            else -> CommentKind.LINE
        }
        return Comment(text, kind, token.span)
    }

    private fun appendCommentsBefore(limitIndex: Int, out: MutableList<Statement>) {
        while (commentIndex < comments.size) {
            val comment = comments[commentIndex]
            if (comment.span.start.index >= limitIndex) {
                return
            }
            out.add(CommentStatement(comment, comment.span))
            commentIndex++
        }
    }

    private fun flushComments(out: MutableList<Statement>) {
        while (commentIndex < comments.size) {
            val comment = comments[commentIndex]
            out.add(CommentStatement(comment, comment.span))
            commentIndex++
        }
    }

    // ------------------------------------------------------------------ statements

    private fun parseStatementListUntil(terminator: TokenType): List<Statement> {
        val statements = mutableListOf<Statement>()
        while (!check(terminator) && !check(TokenType.EOF)) {
            appendCommentsBefore(current.span.start.index, statements)
            statements.add(parseStatement())
        }
        if (check(terminator)) {
            appendCommentsBefore(current.span.start.index, statements)
        }
        return statements
    }

    private fun parseStatement(): Statement {
        val start = current

        if (check(TokenType.OPEN_BRACE)) {
            return parseBlock()
        }
        if (check(TokenType.SEMICOLON)) {
            advance()
            return EmptyStatement(start.span)
        }
        if (check(TokenType.AT)) {
            val decorators = parseDecorators()
            return parseClassDeclaration(false, decorators)
        }
        if (current.type == TokenType.IDENTIFIER && peekToken(1).type == TokenType.COLON) {
            val label = advance().text
            advance() // ':'
            val body = parseStatement()
            return LabeledStatement(label, body, spanOf(start))
        }

        if (current.type == TokenType.KEYWORD) {
            when (current.keyword) {
                Keyword.VAR -> return parseVariableStatement(VariableKind.VAR, false)
                Keyword.LET -> {
                    val next = peekToken(1)
                    if (next.type == TokenType.IDENTIFIER || next.type == TokenType.OPEN_BRACE ||
                        next.type == TokenType.OPEN_BRACKET
                    ) {
                        return parseVariableStatement(VariableKind.LET, false)
                    }
                }

                Keyword.CONST -> {
                    if (peekToken(1).isKeyword(Keyword.ENUM)) {
                        return parseEnum(true)
                    }
                    return parseVariableStatement(VariableKind.CONST, false)
                }

                Keyword.FUNCTION -> return parseFunctionDeclaration(false)
                Keyword.ASYNC -> {
                    if (peekToken(1).isKeyword(Keyword.FUNCTION)) {
                        return parseFunctionDeclaration(true)
                    }
                }

                Keyword.CLASS -> return parseClassDeclaration(false, emptyList())
                Keyword.ABSTRACT -> {
                    if (peekToken(1).isKeyword(Keyword.CLASS)) {
                        advance()
                        return parseClassDeclaration(true, emptyList())
                    }
                }

                Keyword.IF -> return parseIf()
                Keyword.FOR -> return parseFor()
                Keyword.WHILE -> return parseWhile()
                Keyword.DO -> return parseDoWhile()
                Keyword.SWITCH -> return parseSwitch()
                Keyword.TRY -> return parseTry()
                Keyword.THROW -> return parseThrow()
                Keyword.RETURN -> return parseReturn()
                Keyword.BREAK -> return parseJump()
                Keyword.CONTINUE -> return parseJump()
                Keyword.DEBUGGER -> {
                    advance()
                    consumeSemicolon()
                    return ExpressionStatement(Identifier("debugger", start.span), spanOf(start))
                }

                Keyword.IMPORT -> {
                    val next = peekToken(1)
                    if (next.type != TokenType.OPEN_PAREN && next.type != TokenType.DOT) {
                        return parseImport()
                    }
                }

                Keyword.EXPORT -> return parseExport()
                Keyword.ENUM -> return parseEnum(false)
                Keyword.INTERFACE -> {
                    if (peekToken(1).type == TokenType.IDENTIFIER) {
                        return parseInterface()
                    }
                }

                Keyword.TYPE -> {
                    val next = peekToken(1)
                    val after = peekToken(2)
                    if (next.type == TokenType.IDENTIFIER &&
                        (after.type == TokenType.EQUALS || after.type == TokenType.LESS)
                    ) {
                        return parseTypeAlias()
                    }
                }

                Keyword.NAMESPACE, Keyword.MODULE -> {
                    val next = peekToken(1)
                    if (next.type == TokenType.IDENTIFIER || next.type == TokenType.STRING_LITERAL) {
                        return parseNamespace()
                    }
                }

                Keyword.DECLARE -> return parseAmbient()
                else -> Unit
            }
        }

        val expression = parseExpression()
        consumeSemicolon()
        return ExpressionStatement(expression, spanOf(start))
    }

    private fun consumeSemicolon() {
        if (match(TokenType.SEMICOLON)) {
            return
        }
        if (check(TokenType.CLOSE_BRACE) || check(TokenType.EOF)) {
            return
        }
        if (current.precededByLineBreak) {
            return
        }
        throw unexpected("expected ';' or a line break")
    }

    private fun parseBlock(): BlockStatement {
        val start = expect(TokenType.OPEN_BRACE, "'{'")
        val statements = parseStatementListUntil(TokenType.CLOSE_BRACE)
        expect(TokenType.CLOSE_BRACE, "'}'")
        val body = FunctionBody(statements, spanOf(start))
        return BlockStatement(body, spanOf(start))
    }

    private fun parseFunctionBody(): FunctionBody {
        val start = expect(TokenType.OPEN_BRACE, "'{'")
        val statements = parseStatementListUntil(TokenType.CLOSE_BRACE)
        expect(TokenType.CLOSE_BRACE, "'}'")
        return FunctionBody(statements, spanOf(start))
    }

    private fun parseLoopBody(): BlockStatement {
        if (check(TokenType.OPEN_BRACE)) {
            return parseBlock()
        }
        val statement = parseStatement()
        return BlockStatement(FunctionBody(listOf(statement), statement.span), statement.span)
    }

    private fun parseVariableStatement(kind: VariableKind, inForHead: Boolean): VariableStatement {
        val start = current
        advance() // var / let / const
        val declarations = mutableListOf<VariableDeclarator>()

        while (true) {
            declarations.add(parseDeclarator(inForHead))
            if (!match(TokenType.COMMA)) {
                break
            }
        }

        if (!inForHead) {
            consumeSemicolon()
        }
        return VariableStatement(kind, declarations, spanOf(start))
    }

    private fun parseDeclarator(inForHead: Boolean): VariableDeclarator {
        val start = current
        val name = parseBindingTarget()

        if (inForHead && (isOfToken(current) || checkKeyword(Keyword.IN))) {
            return VariableDeclarator(name, null, null, false, spanOf(start))
        }

        var definite = false
        if (match(TokenType.BANG)) {
            definite = true
        }

        val type = if (match(TokenType.COLON)) parseType() else null
        val initializer = if (match(TokenType.EQUALS)) parseAssignmentExpression() else null
        return VariableDeclarator(name, type, initializer, definite, spanOf(start))
    }

    private fun isOfToken(token: Token): Boolean =
        token.type == TokenType.IDENTIFIER && token.text == "of"

    private fun parseFunctionDeclaration(isAsync: Boolean): FunctionDeclaration {
        val start = current
        if (isAsync) {
            advance() // async
        }
        advance() // function
        val isGenerator = match(TokenType.STAR)
        val name = expectBindingName()
        val typeParameters = parseTypeParameters()
        val parameters = parseParameters()
        val returnType = if (match(TokenType.COLON)) parseType() else null
        val body = if (check(TokenType.OPEN_BRACE)) {
            parseFunctionBody()
        } else {
            consumeSemicolon()
            null
        }
        return FunctionDeclaration(
            name, parameters, body, isAsync, isGenerator, returnType, typeParameters, spanOf(start),
        )
    }

    private fun parseIf(): IfStatement {
        val start = current
        advance() // if
        expect(TokenType.OPEN_PAREN, "'('")
        val condition = parseExpression()
        expect(TokenType.CLOSE_PAREN, "')'")
        val thenBranch = parseStatement()
        val elseBranch = if (matchKeyword(Keyword.ELSE)) parseStatement() else null
        return IfStatement(condition, thenBranch, elseBranch, spanOf(start))
    }

    private fun parseWhile(): WhileStatement {
        val start = current
        advance() // while
        expect(TokenType.OPEN_PAREN, "'('")
        val condition = parseExpression()
        expect(TokenType.CLOSE_PAREN, "')'")
        val body = parseLoopBody()
        return WhileStatement(condition, body, spanOf(start))
    }

    private fun parseDoWhile(): DoWhileStatement {
        val start = current
        advance() // do
        val body = parseLoopBody()
        expectKeyword(Keyword.WHILE)
        expect(TokenType.OPEN_PAREN, "'('")
        val condition = parseExpression()
        expect(TokenType.CLOSE_PAREN, "')'")
        consumeSemicolon()
        return DoWhileStatement(body, condition, spanOf(start))
    }

    private fun parseFor(): Statement {
        val start = current
        advance() // for

        var isAwait = false
        if (checkKeyword(Keyword.AWAIT)) {
            advance()
            isAwait = true
        }

        expect(TokenType.OPEN_PAREN, "'('")

        if (check(TokenType.SEMICOLON)) {
            advance()
            return finishClassicFor(start, null)
        }

        if (checkKeyword(Keyword.VAR) || checkKeyword(Keyword.LET) || checkKeyword(Keyword.CONST)) {
            val kind = when {
                checkKeyword(Keyword.VAR) -> VariableKind.VAR
                checkKeyword(Keyword.LET) -> VariableKind.LET
                else -> VariableKind.CONST
            }
            val declarationStart = current
            val restartAt = position
            advance() // the declaration keyword
            val name = parseBindingTarget()
            val isOf = isOfToken(current)
            val isIn = checkKeyword(Keyword.IN)

            if (isOf || isIn) {
                advance() // of / in
                val declarator = VariableDeclarator(name, null, null, false, spanOf(declarationStart))
                val declaration = VariableStatement(kind, listOf(declarator), spanOf(declarationStart))
                val right = if (isIn) parseExpression() else parseAssignmentExpression()
                expect(TokenType.CLOSE_PAREN, "')'")
                val body = parseLoopBody()
                return if (isIn) {
                    ForInStatement(true, kind, declaration, right, body, spanOf(start))
                } else {
                    ForOfStatement(true, kind, declaration, right, body, isAwait, spanOf(start))
                }
            }

            // Rewind to the keyword so the declarator is parsed in full, type annotation included.
            position = restartAt
            val declaration = parseVariableStatement(kind, true)
            return finishClassicFor(start, declaration)
        }

        val init = parseExpression()
        if (isOfToken(current)) {
            advance()
            val right = parseAssignmentExpression()
            expect(TokenType.CLOSE_PAREN, "')'")
            val body = parseLoopBody()
            return ForOfStatement(
                false, VariableKind.LET, ExpressionStatement(init, init.span), right, body, isAwait, spanOf(start),
            )
        }
        if (checkKeyword(Keyword.IN)) {
            advance()
            val right = parseExpression()
            expect(TokenType.CLOSE_PAREN, "')'")
            val body = parseLoopBody()
            return ForInStatement(
                false, VariableKind.LET, ExpressionStatement(init, init.span), right, body, spanOf(start),
            )
        }

        return finishClassicFor(start, ExpressionStatement(init, init.span))
    }

    private fun finishClassicFor(start: Token, init: Statement?): ForStatement {
        expect(TokenType.SEMICOLON, "';'")
        val test = if (check(TokenType.SEMICOLON)) null else parseExpression()
        expect(TokenType.SEMICOLON, "';'")
        val update = if (check(TokenType.CLOSE_PAREN)) null else parseExpression()
        expect(TokenType.CLOSE_PAREN, "')'")
        val body = parseLoopBody()
        return ForStatement(init, test, update, body, spanOf(start))
    }

    private fun parseSwitch(): SwitchStatement {
        val start = current
        advance() // switch
        expect(TokenType.OPEN_PAREN, "'('")
        val discriminant = parseExpression()
        expect(TokenType.CLOSE_PAREN, "')'")
        expect(TokenType.OPEN_BRACE, "'{'")

        val cases = mutableListOf<SwitchCase>()
        while (!check(TokenType.CLOSE_BRACE) && !check(TokenType.EOF)) {
            val caseStart = current
            var test: Expression? = null
            if (checkKeyword(Keyword.CASE)) {
                advance()
                test = parseExpression()
                expect(TokenType.COLON, "':'")
            } else if (checkKeyword(Keyword.DEFAULT)) {
                advance()
                expect(TokenType.COLON, "':'")
            } else {
                throw unexpected("expected 'case' or 'default'")
            }

            val statements = mutableListOf<Statement>()
            while (!check(TokenType.CLOSE_BRACE) && !check(TokenType.EOF) &&
                !checkKeyword(Keyword.CASE) && !checkKeyword(Keyword.DEFAULT)
            ) {
                appendCommentsBefore(current.span.start.index, statements)
                statements.add(parseStatement())
            }
            cases.add(SwitchCase(test, statements, spanOf(caseStart)))
        }

        expect(TokenType.CLOSE_BRACE, "'}'")
        return SwitchStatement(discriminant, cases, spanOf(start))
    }

    private fun parseTry(): TryStatement {
        val start = current
        advance() // try
        val block = parseBlock()

        var handler: CatchClause? = null
        var finalizer: BlockStatement? = null

        if (checkKeyword(Keyword.CATCH)) {
            val catchStart = current
            advance()
            var parameterName: String? = null
            var parameterType: TypeNode? = null
            if (match(TokenType.OPEN_PAREN)) {
                parameterName = parseBindingTarget()
                if (match(TokenType.COLON)) {
                    parameterType = parseType()
                }
                expect(TokenType.CLOSE_PAREN, "')'")
            }
            val body = parseBlock()
            handler = CatchClause(parameterName, parameterType, body, spanOf(catchStart))
        }

        if (matchKeyword(Keyword.FINALLY)) {
            finalizer = parseBlock()
        }

        if (handler == null && finalizer == null) {
            throw unexpected("expected 'catch' or 'finally'")
        }
        return TryStatement(block, handler, finalizer, spanOf(start))
    }

    private fun parseThrow(): ThrowStatement {
        val start = current
        advance() // throw
        if (current.precededByLineBreak) {
            throw unexpected("a line break is not allowed after 'throw'")
        }
        val argument = parseExpression()
        consumeSemicolon()
        return ThrowStatement(argument, spanOf(start))
    }

    private fun parseReturn(): ReturnStatement {
        val start = current
        advance() // return
        val argument = if (check(TokenType.SEMICOLON) || check(TokenType.CLOSE_BRACE) || check(TokenType.EOF) ||
            current.precededByLineBreak
        ) {
            null
        } else {
            parseExpression()
        }
        consumeSemicolon()
        return ReturnStatement(argument, spanOf(start))
    }

    private fun parseJump(): JumpStatement {
        val start = current
        val keyword = advance().text
        val label = if (current.type == TokenType.IDENTIFIER && !current.precededByLineBreak) {
            advance().text
        } else {
            null
        }
        consumeSemicolon()
        return JumpStatement(keyword, label, spanOf(start))
    }

    private fun parseImport(): Statement {
        val start = current
        advance() // import

        var typeOnly = false
        if (checkKeyword(Keyword.TYPE)) {
            val next = peekToken(1)
            if (next.type != TokenType.COMMA) {
                advance()
                typeOnly = true
            }
        }

        if (check(TokenType.STRING_LITERAL)) {
            val module = stringValue(advance())
            consumeSemicolon()
            return ImportDeclaration(module, sideEffectOnly = true, typeOnly = typeOnly, span = spanOf(start))
        }

        var defaultBinding: String? = null
        if (current.type == TokenType.IDENTIFIER && current.text != "from") {
            defaultBinding = advance().text
            match(TokenType.COMMA)
        }

        var namespaceBinding: String? = null
        val namedImports = mutableListOf<ImportSpecifier>()

        if (check(TokenType.STAR)) {
            advance()
            if (checkWord("as")) {
                advance()
            }
            namespaceBinding = expectBindingName()
        } else if (check(TokenType.OPEN_BRACE)) {
            advance()
            while (!check(TokenType.CLOSE_BRACE) && !check(TokenType.EOF)) {
                val specStart = current
                var specTypeOnly = false
                if (checkKeyword(Keyword.TYPE)) {
                    val next = peekToken(1)
                    if (next.type != TokenType.COMMA && next.type != TokenType.CLOSE_BRACE) {
                        advance()
                        specTypeOnly = true
                    }
                }
                val imported = expectPropertyName()
                var local = imported
                if (checkWord("as")) {
                    advance()
                    local = expectBindingName()
                }
                namedImports.add(ImportSpecifier(imported, local, specTypeOnly, spanOf(specStart)))
                if (!match(TokenType.COMMA)) {
                    break
                }
            }
            expect(TokenType.CLOSE_BRACE, "'}'")
        }

        if (current.type == TokenType.IDENTIFIER && current.text == "from") {
            advance()
        }
        val module = stringValue(expect(TokenType.STRING_LITERAL, "a module specifier"))
        consumeSemicolon()
        return ImportDeclaration(
            module, defaultBinding, namespaceBinding, namedImports, false, typeOnly, spanOf(start),
        )
    }

    private fun parseExport(): Statement {
        val start = current
        advance() // export

        var typeOnly = false
        if (checkKeyword(Keyword.TYPE)) {
            val next = peekToken(1)
            if (next.type == TokenType.OPEN_BRACE || next.type == TokenType.STAR) {
                advance()
                typeOnly = true
            }
        }

        if (matchKeyword(Keyword.DEFAULT)) {
            val declaration: Statement = when {
                checkKeyword(Keyword.CLASS) -> parseClassDeclaration(false, emptyList())
                checkKeyword(Keyword.ABSTRACT) -> {
                    advance()
                    parseClassDeclaration(true, emptyList())
                }

                checkKeyword(Keyword.FUNCTION) -> parseFunctionDeclaration(false)
                checkKeyword(Keyword.ASYNC) && peekToken(1).isKeyword(Keyword.FUNCTION) -> parseFunctionDeclaration(true)
                else -> {
                    val expression = parseAssignmentExpression()
                    consumeSemicolon()
                    ExpressionStatement(expression, expression.span)
                }
            }
            return ExportDeclaration(
                declaration = declaration,
                isDefault = true,
                typeOnly = typeOnly,
                span = spanOf(start),
            )
        }

        if (check(TokenType.STAR)) {
            advance()
            var namespace: String? = null
            if (checkWord("as")) {
                advance()
                namespace = expectPropertyName()
            }
            if (current.type == TokenType.IDENTIFIER && current.text == "from") {
                advance()
            }
            val module = stringValue(expect(TokenType.STRING_LITERAL, "a module specifier"))
            consumeSemicolon()
            return ExportDeclaration(
                source = module,
                isStar = true,
                namespaceExport = namespace,
                typeOnly = typeOnly,
                span = spanOf(start),
            )
        }

        if (check(TokenType.OPEN_BRACE)) {
            advance()
            val specifiers = mutableListOf<ExportSpecifier>()
            while (!check(TokenType.CLOSE_BRACE) && !check(TokenType.EOF)) {
                val specStart = current
                if (checkKeyword(Keyword.TYPE)) {
                    val next = peekToken(1)
                    if (next.type != TokenType.COMMA && next.type != TokenType.CLOSE_BRACE) {
                        advance()
                    }
                }
                val local = expectPropertyName()
                var exported = local
                if (checkWord("as")) {
                    advance()
                    exported = expectPropertyName()
                }
                specifiers.add(ExportSpecifier(local, exported, spanOf(specStart)))
                if (!match(TokenType.COMMA)) {
                    break
                }
            }
            expect(TokenType.CLOSE_BRACE, "'}'")

            var module: String? = null
            if (current.type == TokenType.IDENTIFIER && current.text == "from") {
                advance()
                module = stringValue(expect(TokenType.STRING_LITERAL, "a module specifier"))
            }
            consumeSemicolon()
            return ExportDeclaration(
                specifiers = specifiers,
                source = module,
                typeOnly = typeOnly,
                span = spanOf(start),
            )
        }

        val declaration = parseStatement()
        return ExportDeclaration(declaration = declaration, typeOnly = typeOnly, span = spanOf(start))
    }

    private fun parseEnum(isConst: Boolean): EnumDeclaration {
        val start = current
        if (isConst) {
            advance() // const
        }
        advance() // enum
        val name = expectBindingName()
        expect(TokenType.OPEN_BRACE, "'{'")

        val members = mutableListOf<EnumMemberNode>()
        while (!check(TokenType.CLOSE_BRACE) && !check(TokenType.EOF)) {
            val memberStart = current
            val memberName = expectPropertyName()
            val initializer = if (match(TokenType.EQUALS)) parseAssignmentExpression() else null
            members.add(EnumMemberNode(memberName, initializer, spanOf(memberStart)))
            if (!match(TokenType.COMMA)) {
                break
            }
        }

        expect(TokenType.CLOSE_BRACE, "'}'")
        return EnumDeclaration(name, members, isConst, spanOf(start))
    }

    private fun parseNamespace(): NamespaceDeclaration {
        val start = current
        advance() // namespace / module
        val name = if (check(TokenType.STRING_LITERAL)) {
            stringValue(advance())
        } else {
            qualifiedName()
        }

        val statements = if (check(TokenType.OPEN_BRACE)) {
            advance()
            val body = parseStatementListUntil(TokenType.CLOSE_BRACE)
            expect(TokenType.CLOSE_BRACE, "'}'")
            body
        } else {
            consumeSemicolon()
            emptyList()
        }
        return NamespaceDeclaration(name, statements, spanOf(start))
    }

    private fun parseAmbient(): Statement {
        val start = current
        advance() // declare
        val statement = parseStatement()
        return AmbientDeclaration(
            statement, spanOf(start),
        )
    }

    private fun parseTypeAlias(): TypeAliasDeclaration {
        val start = current
        advance() // type
        val name = expectBindingName()
        val typeParameters = parseTypeParameters()
        expect(TokenType.EQUALS, "'='")
        val type = parseType()
        consumeSemicolon()
        return TypeAliasDeclaration(name, type, typeParameters, spanOf(start))
    }

    private fun parseInterface(): InterfaceDeclaration {
        val start = current
        advance() // interface
        val name = expectBindingName()
        val typeParameters = parseTypeParameters()

        val extendsNames = mutableListOf<String>()
        if (matchKeyword(Keyword.EXTENDS)) {
            while (true) {
                extendsNames.add(qualifiedName())
                if (check(TokenType.LESS)) {
                    parseTypeArguments()
                }
                if (!match(TokenType.COMMA)) {
                    break
                }
            }
        }

        expect(TokenType.OPEN_BRACE, "'{'")
        val members = parseTypeMembers()
        expect(TokenType.CLOSE_BRACE, "'}'")
        return InterfaceDeclaration(name, members, extendsNames, typeParameters, spanOf(start))
    }

    private fun parseDecorators(): List<Expression> {
        val decorators = mutableListOf<Expression>()
        while (check(TokenType.AT)) {
            advance()
            decorators.add(parsePostfix())
        }
        return decorators
    }

    private fun parseClassDeclaration(isAbstract: Boolean, decorators: List<Expression>): ClassDeclaration {
        val start = current
        expectKeyword(Keyword.CLASS)
        val name = expectBindingName()
        val typeParameters = parseTypeParameters()
        val superClass = parseHeritage()
        val implementsTypes = parseImplements()
        val members = parseClassBody()
        return ClassDeclaration(
            name, superClass, members, isAbstract, typeParameters, implementsTypes, decorators, spanOf(start),
        )
    }

    private fun parseHeritage(): Expression? {
        if (!matchKeyword(Keyword.EXTENDS)) {
            return null
        }
        val start = previousToken()
        var expression = parsePrimary()
        while (true) {
            when {
                check(TokenType.DOT) -> {
                    advance()
                    val name = expectPropertyName()
                    expression = MemberExpression(expression, Identifier(name, previousToken().span), false, false, spanOf(previousToken()))
                }

                check(TokenType.OPEN_BRACKET) -> {
                    advance()
                    val index = parseExpression()
                    expect(TokenType.CLOSE_BRACKET, "']'")
                    expression = MemberExpression(expression, index, true, false, spanOf(previousToken()))
                }

                // `class C extends Base<T>` instantiates the superclass, so the arguments are kept on a wrapper
                // node: dropping them would lose the type the base class is specialised with.
                check(TokenType.LESS) -> {
                    val saved = position
                    val parsed = speculate { parseTypeArguments() }
                    if (parsed == null) {
                        position = saved
                        return expression
                    }
                    expression = InstantiationExpression(expression, parsed, spanOf(start))
                }

                else -> return expression
            }
        }
    }

    private fun parseImplements(): List<TypeNode> {
        if (current.type != TokenType.IDENTIFIER || current.text != "implements") {
            return emptyList()
        }
        advance()
        val types = mutableListOf<TypeNode>()
        while (true) {
            if (check(TokenType.OPEN_BRACE)) {
                return types
            }
            types.add(parseType())
            if (!match(TokenType.COMMA)) {
                return types
            }
        }
    }

    private fun parseClassBody(): List<ClassMemberNode> {
        expect(TokenType.OPEN_BRACE, "'{'")
        val members = mutableListOf<ClassMemberNode>()

        while (!check(TokenType.CLOSE_BRACE) && !check(TokenType.EOF)) {
            if (match(TokenType.SEMICOLON)) {
                continue
            }
            while (check(TokenType.AT)) {
                advance()
                parsePostfix()
            }
            members.add(parseClassMember())
        }

        expect(TokenType.CLOSE_BRACE, "'}'")
        return members
    }

    private fun parseClassMember(): ClassMemberNode {
        val start = current
        var isStatic = false
        var readonly = false
        var accessibility: String? = null
        var isAsync = false
        var isAbstract = false
        var kind = MethodKind.METHOD

        loop@ while (true) {
            when {
                checkKeyword(Keyword.STATIC) -> {
                    val next = peekToken(1)
                    if (next.type == TokenType.OPEN_BRACE) {
                        advance()
                        val block = parseBlock()
                        return MethodMemberNode(
                            "static", emptyList(), block.body, MethodKind.METHOD, true, false, false, false,
                            null, null, emptyList(), spanOf(start),
                        )
                    }
                    advance()
                    isStatic = true
                }

                checkKeyword(Keyword.PUBLIC) || checkKeyword(Keyword.PRIVATE) || checkKeyword(Keyword.PROTECTED) -> {
                    accessibility = advance().text
                }

                checkKeyword(Keyword.READONLY) -> {
                    advance()
                    readonly = true
                }

                checkKeyword(Keyword.ABSTRACT) -> {
                    advance()
                    isAbstract = true
                }

                checkKeyword(Keyword.OVERRIDE) || checkKeyword(Keyword.DECLARE) -> {
                    advance()
                }

                checkKeyword(Keyword.ASYNC) -> {
                    val next = peekToken(1)
                    if (next.type == TokenType.IDENTIFIER || next.type == TokenType.KEYWORD ||
                        next.type == TokenType.STRING_LITERAL || next.type == TokenType.NUMERIC_LITERAL ||
                        next.type == TokenType.OPEN_BRACKET
                    ) {
                        advance()
                        isAsync = true
                    } else {
                        break@loop
                    }
                }

                checkWord("get") || checkWord("set") -> {
                    val next = peekToken(1)
                    if (next.type == TokenType.IDENTIFIER || next.type == TokenType.KEYWORD ||
                        next.type == TokenType.STRING_LITERAL || next.type == TokenType.OPEN_BRACKET
                    ) {
                        kind = if (checkWord("get")) MethodKind.GET else MethodKind.SET
                        advance()
                        break@loop
                    } else {
                        break@loop
                    }
                }

                else -> break@loop
            }
        }

        if (match(TokenType.STAR)) {
            // generator marker
        }

        val computed = check(TokenType.OPEN_BRACKET)
        var keyExpression: Expression? = null
        val name = if (computed) {
            advance()
            val inner = parseExpression()
            expect(TokenType.CLOSE_BRACKET, "']'")
            keyExpression = inner
            if (inner is Identifier) inner.name else inner.span.text(source)
        } else {
            expectPropertyName()
        }

        if (name == "constructor") {
            kind = MethodKind.CONSTRUCTOR
        }

        if (check(TokenType.OPEN_PAREN) || check(TokenType.LESS)) {
            val typeParameters = parseTypeParameters()
            val parameters = parseParameters()
            val returnType = if (match(TokenType.COLON)) parseType() else null
            val body = if (check(TokenType.OPEN_BRACE)) {
                parseFunctionBody()
            } else {
                consumeSemicolon()
                null
            }
            return MethodMemberNode(
                name, parameters, body, kind, isStatic, isAsync, false, isAbstract, accessibility, returnType,
                typeParameters, spanOf(start),
            )
        }

        val optional = match(TokenType.QUESTION)
        var definite = false
        if (match(TokenType.BANG)) {
            definite = true
        }
        val type = if (match(TokenType.COLON)) parseType() else null
        val initializer = if (match(TokenType.EQUALS)) parseAssignmentExpression() else null
        consumeSemicolon()
        return FieldMemberNode(
            name, type, initializer, isStatic, readonly, accessibility, optional, definite, spanOf(start),
        )
    }

    // ------------------------------------------------------------------ parameters

    private fun parseParameters(): List<ParameterNode> {
        expect(TokenType.OPEN_PAREN, "'('")
        val parameters = mutableListOf<ParameterNode>()
        while (!check(TokenType.CLOSE_PAREN) && !check(TokenType.EOF)) {
            // A `this` parameter only declares the receiver type. It occupies no slot in the call, so it is
            // consumed here and never reaches the parameter list.
            if (checkKeyword(Keyword.THIS)) {
                advance()
                if (match(TokenType.COLON)) {
                    parseType()
                }
                if (!match(TokenType.COMMA)) {
                    break
                }
                continue
            }
            parameters.add(parseParameter())
            if (!match(TokenType.COMMA)) {
                break
            }
        }
        expect(TokenType.CLOSE_PAREN, "')'")
        return parameters
    }

    private fun parseParameter(): ParameterNode {
        val start = current
        var rest = false
        var readonly = false
        var accessibility: String? = null

        if (match(TokenType.DOT_DOT_DOT)) {
            rest = true
        }
        while (true) {
            when {
                checkKeyword(Keyword.PUBLIC) || checkKeyword(Keyword.PRIVATE) || checkKeyword(Keyword.PROTECTED) -> {
                    accessibility = advance().text
                }

                checkKeyword(Keyword.READONLY) -> {
                    advance()
                    readonly = true
                }

                checkKeyword(Keyword.OVERRIDE) -> advance()
                else -> break
            }
        }

        val name = parseBindingTarget()
        val optional = match(TokenType.QUESTION)
        val type = if (match(TokenType.COLON)) parseType() else null
        val defaultValue = if (match(TokenType.EQUALS)) parseAssignmentExpression() else null
        return ParameterNode(name, type, defaultValue, optional, rest, readonly, accessibility, spanOf(start))
    }

    private fun parseBindingTarget(): String {
        if (check(TokenType.OPEN_BRACE) || check(TokenType.OPEN_BRACKET)) {
            val start = position
            skipBalanced()
            val first = tokens[start]
            val last = tokens[(position - 1).coerceAtLeast(start)]
            return source.substring(first.span.start.index, last.span.end.index)
        }
        return expectBindingName()
    }

    private fun skipBalanced() {
        var depth = 0
        while (!check(TokenType.EOF)) {
            when (current.type) {
                TokenType.OPEN_BRACE, TokenType.OPEN_BRACKET, TokenType.OPEN_PAREN -> depth++
                TokenType.CLOSE_BRACE, TokenType.CLOSE_BRACKET, TokenType.CLOSE_PAREN -> {
                    depth--
                    if (depth == 0) {
                        advance()
                        return
                    }
                }

                else -> Unit
            }
            advance()
        }
    }

    private fun expectBindingName(): String {
        val token = current
        if (token.type == TokenType.IDENTIFIER) {
            advance()
            return token.text
        }
        if (token.type == TokenType.KEYWORD && token.keyword?.isReservedWord != true) {
            advance()
            return token.text
        }
        throw unexpected("expected a binding name")
    }

    private fun expectPropertyName(): String {
        // A private name keeps its hash marker in the AST: the emitters decide what privacy means in the
        // target language, and dropping it here would erase information the source carries.
        if (match(TokenType.HASH)) {
            return "#" + expectPropertyName()
        }
        val token = current
        when (token.type) {
            TokenType.IDENTIFIER, TokenType.KEYWORD -> {
                advance()
                return token.text
            }

            TokenType.STRING_LITERAL -> {
                advance()
                return stringValue(token)
            }

            TokenType.NUMERIC_LITERAL -> {
                advance()
                return token.text
            }

            else -> throw unexpected("expected a property name")
        }
    }

    private fun qualifiedName(): String {
        val builder = StringBuilder(expectBindingName())
        while (check(TokenType.DOT)) {
            advance()
            builder.append('.').append(expectPropertyName())
        }
        return builder.toString()
    }

    // ------------------------------------------------------------------ types

    private fun parseType(): TypeNode = parseConditionalType()

    private fun parseConditionalType(): TypeNode {
        val start = current
        val check = parseUnionType()
        if (checkKeyword(Keyword.EXTENDS)) {
            advance()
            val extendsType = parseUnionType()
            if (match(TokenType.QUESTION)) {
                val trueType = parseType()
                expect(TokenType.COLON, "':'")
                val falseType = parseType()
                return ConditionalTypeNode(check, extendsType, trueType, falseType, spanOf(start))
            }
            return check
        }
        return check
    }

    private fun parseUnionType(): TypeNode {
        val start = current
        val leading = match(TokenType.PIPE)
        val first = parseIntersectionType()
        if (!check(TokenType.PIPE)) {
            return first
        }
        val types = mutableListOf(first)
        while (match(TokenType.PIPE)) {
            types.add(parseIntersectionType())
        }
        if (leading && types.isEmpty()) {
            return first
        }
        return UnionTypeNode(types, spanOf(start))
    }

    private fun parseIntersectionType(): TypeNode {
        val start = current
        val first = parseTypeOperator()
        if (!check(TokenType.AMPERSAND)) {
            return first
        }
        val types = mutableListOf(first)
        while (match(TokenType.AMPERSAND)) {
            types.add(parseTypeOperator())
        }
        return IntersectionTypeNode(types, spanOf(start))
    }

    private fun parseTypeOperator(): TypeNode {
        val start = current
        if (checkKeyword(Keyword.KEYOF) || checkKeyword(Keyword.READONLY) || checkKeyword(Keyword.UNIQUE) ||
            checkKeyword(Keyword.INFER)
        ) {
            val operator = advance().text
            val type = parseTypeOperator()
            return TypeOperatorNode(operator, type, spanOf(start))
        }
        return parsePostfixType()
    }

    private fun parsePostfixType(): TypeNode {
        val start = current
        var type = parsePrimaryType()
        while (true) {
            if (!check(TokenType.OPEN_BRACKET)) {
                break
            }
            advance()
            if (match(TokenType.CLOSE_BRACKET)) {
                type = ArrayTypeNode(type, spanOf(start))
                continue
            }
            val index = parseType()
            expect(TokenType.CLOSE_BRACKET, "']'")
            type = IndexedAccessTypeNode(type, index, spanOf(start))
        }
        return type
    }

    private fun parsePrimaryType(): TypeNode {
        val start = current

        if (check(TokenType.OPEN_PAREN)) {
            val function = speculate { parseFunctionType() }
            if (function != null) {
                return function
            }
            advance() // '('
            val inner = parseType()
            expect(TokenType.CLOSE_PAREN, "')'")
            return ParenthesizedTypeNode(inner, spanOf(start))
        }

        if (check(TokenType.OPEN_BRACE)) {
            advance()
            val members = parseTypeMembers()
            expect(TokenType.CLOSE_BRACE, "'}'")
            return ObjectTypeNode(members, spanOf(start))
        }

        if (check(TokenType.OPEN_BRACKET)) {
            advance()
            val elements = mutableListOf<TypeNode>()
            while (!check(TokenType.CLOSE_BRACKET) && !check(TokenType.EOF)) {
                if (match(TokenType.DOT_DOT_DOT)) {
                    elements.add(parseType())
                    break
                }
                elements.add(parseType())
                if (match(TokenType.QUESTION)) {
                    // optional tuple element marker
                }
                if (!match(TokenType.COMMA)) {
                    break
                }
            }
            expect(TokenType.CLOSE_BRACKET, "']'")
            return TupleTypeNode(elements, spanOf(start))
        }

        if (check(TokenType.STRING_LITERAL) || check(TokenType.NUMERIC_LITERAL)) {
            return LiteralTypeNode(parsePrimary(), spanOf(start))
        }

        if (check(TokenType.MINUS) && peekToken(1).type == TokenType.NUMERIC_LITERAL) {
            advance()
            return LiteralTypeNode(parsePrimary(), spanOf(start))
        }

        if (checkKeyword(Keyword.TRUE) || checkKeyword(Keyword.FALSE)) {
            return LiteralTypeNode(parsePrimary(), spanOf(start))
        }

        if (checkKeyword(Keyword.TYPEOF)) {
            advance()
            val name = qualifiedName()
            if (check(TokenType.LESS)) {
                parseTypeArguments()
            }
            return TypeQueryNode(name, spanOf(start))
        }

        if (checkKeyword(Keyword.NEW)) {
            advance()
            val function = parseFunctionType()
            return function
        }

        if (current.type == TokenType.KEYWORD) {
            val keyword = current.keyword
            if (keyword != null && (keyword.isPrimitiveType || keyword == Keyword.THIS)) {
                advance()
                return KeywordTypeNode(keyword.text, spanOf(start))
            }
        }

        if (current.type == TokenType.IDENTIFIER) {
            val name = qualifiedName()
            val typeArguments = if (check(TokenType.LESS)) parseTypeArguments() else emptyList()
            return TypeReferenceNode(name, typeArguments, spanOf(start))
        }

        throw unexpected("expected a type")
    }

    private fun parseFunctionType(): TypeNode {
        val start = current
        if (check(TokenType.LESS)) {
            parseTypeParameters()
        }
        val parameters = parseParameters()
        expect(TokenType.ARROW, "'=>'")
        val returnType = parseType()
        return FunctionTypeNode(parameters, returnType, spanOf(start))
    }

    private fun parseTypeMembers(): List<TypeMemberNode> {
        val members = mutableListOf<TypeMemberNode>()
        while (!check(TokenType.CLOSE_BRACE) && !check(TokenType.EOF)) {
            if (match(TokenType.SEMICOLON) || match(TokenType.COMMA)) {
                continue
            }
            val start = current

            if (check(TokenType.OPEN_BRACKET)) {
                advance()
                val key = expectBindingName()
                if (match(TokenType.COLON)) {
                    parseType()
                }
                expect(TokenType.CLOSE_BRACKET, "']'")
                val value = if (match(TokenType.COLON)) parseType() else null
                consumeTypeMemberSeparator()
                members.add(TypeMemberNode(key, value, false, emptyList(), null, spanOf(start)))
                continue
            }

            if (matchKeyword(Keyword.READONLY)) {
                // modifier only, the member itself follows
            }

            if (check(TokenType.OPEN_PAREN) || check(TokenType.LESS)) {
                if (check(TokenType.LESS)) {
                    parseTypeParameters()
                }
                val parameters = parseParameters()
                val returnType = if (match(TokenType.COLON)) parseType() else null
                consumeTypeMemberSeparator()
                members.add(TypeMemberNode("call", null, false, parameters, returnType, spanOf(start)))
                continue
            }

            val name = expectPropertyName()
            val optional = match(TokenType.QUESTION)

            if (check(TokenType.OPEN_PAREN) || check(TokenType.LESS)) {
                if (check(TokenType.LESS)) {
                    parseTypeParameters()
                }
                val parameters = parseParameters()
                val returnType = if (match(TokenType.COLON)) parseType() else null
                consumeTypeMemberSeparator()
                members.add(TypeMemberNode(name, null, optional, parameters, returnType, spanOf(start)))
            } else {
                val type = if (match(TokenType.COLON)) parseType() else null
                consumeTypeMemberSeparator()
                members.add(TypeMemberNode(name, type, optional, emptyList(), null, spanOf(start)))
            }
        }
        return members
    }

    private fun consumeTypeMemberSeparator() {
        if (match(TokenType.SEMICOLON) || match(TokenType.COMMA)) {
            return
        }
    }

    private fun parseTypeParameters(): List<String> {
        if (!check(TokenType.LESS)) {
            return emptyList()
        }
        advance() // '<'
        val names = mutableListOf<String>()
        while (!checkTypeArgumentClose() && !check(TokenType.EOF)) {
            if (checkKeyword(Keyword.CONST) || checkKeyword(Keyword.READONLY)) {
                advance()
            }
            if (current.type == TokenType.IDENTIFIER && (current.text == "in" || current.text == "out")) {
                advance()
            }
            names.add(expectBindingName())
            if (matchKeyword(Keyword.EXTENDS)) {
                parseUnionType()
            }
            if (match(TokenType.EQUALS)) {
                parseType()
            }
            if (!match(TokenType.COMMA)) {
                break
            }
        }
        expectTypeArgumentClose()
        return names
    }

    private fun parseTypeArguments(): List<TypeNode> {
        if (!check(TokenType.LESS)) {
            return emptyList()
        }
        advance() // '<'
        val arguments = mutableListOf<TypeNode>()
        while (!checkTypeArgumentClose() && !check(TokenType.EOF)) {
            arguments.add(parseType())
            if (!match(TokenType.COMMA)) {
                break
            }
        }
        expectTypeArgumentClose()
        return arguments
    }

    private fun checkTypeArgumentClose(): Boolean = when (current.type) {
        TokenType.GREATER, TokenType.GREATER_GREATER, TokenType.GREATER_GREATER_GREATER -> true
        else -> false
    }

    /**
     * Consumes one closing angle bracket, splitting a run of them so nested generics such as
     * `Foo<Bar<Baz>>` close one level at a time.
     */
    private fun expectTypeArgumentClose() {
        splitGreaterRun()
        expect(TokenType.GREATER, "'>'")
    }

    private fun splitGreaterRun() {
        val token = current
        val count = when (token.type) {
            TokenType.GREATER_GREATER -> 2
            TokenType.GREATER_GREATER_GREATER -> 3
            else -> return
        }
        val rest = count - 1
        val start = token.span.start
        val replacement = Token(
            TokenType.GREATER,
            ">".repeat(rest),
            SourceSpan(
                SourcePosition(start.index + 1, start.line, start.column + 1),
                token.span.end,
            ),
            precededByLineBreak = false,
        )
        tokens[position] = replacement
    }

    // ------------------------------------------------------------------ expressions

    private fun parseExpression(): Expression {
        val start = current
        val first = parseAssignmentExpression()
        if (!check(TokenType.COMMA)) {
            return first
        }
        val expressions = mutableListOf(first)
        while (match(TokenType.COMMA)) {
            expressions.add(parseAssignmentExpression())
        }
        return SequenceExpression(expressions, spanOf(start))
    }

    private fun parseAssignmentExpression(): Expression {
        val start = current

        if (checkKeyword(Keyword.YIELD)) {
            return parseYieldExpression()
        }

        val arrow = tryParseArrowFunction()
        if (arrow != null) {
            return arrow
        }

        val left = parseConditionalExpression()
        if (isAssignmentOperator(current)) {
            val operator = advance().text
            val right = parseAssignmentExpression()
            return AssignmentExpression(left, operator, right, spanOf(start))
        }
        return left
    }

    /** Parses `yield`, `yield x` and `yield* x`. */
    private fun parseYieldExpression(): YieldExpression {
        val start = current
        advance() // yield
        val delegate = match(TokenType.STAR)
        // A bare `yield` ends the expression: the argument may only follow on the same line.
        val hasArgument = !current.precededByLineBreak && !isExpressionTerminator(current) && !check(TokenType.EOF)
        val argument = if (hasArgument) parseAssignmentExpression() else null
        return YieldExpression(argument, delegate, spanOf(start))
    }

    /** True for tokens that cannot start an operand, so an operator in front of them has no argument. */
    private fun isExpressionTerminator(token: Token): Boolean = when (token.type) {
        TokenType.SEMICOLON, TokenType.COMMA, TokenType.CLOSE_PAREN, TokenType.CLOSE_BRACKET,
        TokenType.CLOSE_BRACE, TokenType.COLON, TokenType.EOF,
        -> true

        else -> false
    }

    private fun tryParseArrowFunction(): Expression? {
        val isAsync = checkKeyword(Keyword.ASYNC) &&
            (peekToken(1).type == TokenType.IDENTIFIER || peekToken(1).type == TokenType.OPEN_PAREN)

        if (current.type == TokenType.IDENTIFIER && peekToken(1).type == TokenType.ARROW) {
            val start = current
            val name = advance().text
            advance() // '=>'
            val parameter = ParameterNode(name, null, null, false, false, false, null, start.span)
            val body = parseArrowBody()
            return ArrowFunction(listOf(parameter), body, false, null, spanOf(start))
        }

        // `async x => ...` takes the same parameterless-parenthesis shape as the plain form.
        if (isAsync && peekToken(1).type == TokenType.IDENTIFIER && peekToken(2).type == TokenType.ARROW) {
            val start = current
            advance() // async
            val parameterStart = current
            val name = advance().text
            advance() // '=>'
            val parameter = ParameterNode(name, null, null, false, false, false, null, parameterStart.span)
            val body = parseArrowBody()
            return ArrowFunction(listOf(parameter), body, true, null, spanOf(start))
        }

        if (!check(TokenType.OPEN_PAREN) && !isAsync) {
            return null
        }

        return speculate {
            val start = current
            if (isAsync) {
                advance() // async
            }
            if (!check(TokenType.OPEN_PAREN)) {
                throw unexpected("expected '('")
            }
            val parameters = parseParameters()
            val returnType = if (match(TokenType.COLON)) parseType() else null
            expect(TokenType.ARROW, "'=>'")
            val body = parseArrowBody()
            ArrowFunction(parameters, body, isAsync, returnType, spanOf(start))
        }
    }

    private fun parseArrowBody(): ArrowBody {
        if (check(TokenType.OPEN_BRACE)) {
            val body = parseFunctionBody()
            return BlockBody(body, body.span)
        }
        val expression = parseAssignmentExpression()
        return ExpressionBody(expression, expression.span)
    }

    private fun isAssignmentOperator(token: Token): Boolean = when (token.type) {
        TokenType.EQUALS,
        TokenType.PLUS_EQUALS,
        TokenType.MINUS_EQUALS,
        TokenType.STAR_EQUALS,
        TokenType.SLASH_EQUALS,
        TokenType.PERCENT_EQUALS,
        TokenType.STAR_STAR_EQUALS,
        TokenType.LESS_LESS_EQUALS,
        TokenType.GREATER_GREATER_EQUALS,
        TokenType.GREATER_GREATER_GREATER_EQUALS,
        TokenType.AMPERSAND_EQUALS,
        TokenType.PIPE_EQUALS,
        TokenType.CARET_EQUALS,
        TokenType.AMPERSAND_AMPERSAND_EQUALS,
        TokenType.PIPE_PIPE_EQUALS,
        TokenType.QUESTION_QUESTION_EQUALS,
        -> true

        else -> false
    }

    private fun parseConditionalExpression(): Expression {
        val start = current
        val test = parseBinaryExpression(0)
        if (!match(TokenType.QUESTION)) {
            return test
        }
        val consequent = parseAssignmentExpression()
        expect(TokenType.COLON, "':'")
        val alternate = parseAssignmentExpression()
        return ConditionalExpression(test, consequent, alternate, spanOf(start))
    }

    private fun parseBinaryExpression(minPrecedence: Int): Expression {
        val start = current
        var left = parseUnaryExpression()

        while (true) {
            val precedence = binaryPrecedence(current)
            if (precedence < 0 || precedence < minPrecedence) {
                break
            }
            val operator = advance()
            val rightAssociative = operator.type == TokenType.STAR_STAR
            val right = parseBinaryExpression(if (rightAssociative) precedence else precedence + 1)
            left = if (isLogicalOperator(operator)) {
                LogicalExpression(left, operator.text, right, spanOf(start))
            } else {
                BinaryExpression(left, operator.text, right, spanOf(start))
            }
        }
        return left
    }

    private fun isLogicalOperator(token: Token): Boolean = when (token.type) {
        TokenType.AMPERSAND_AMPERSAND, TokenType.PIPE_PIPE, TokenType.QUESTION_QUESTION -> true
        else -> false
    }

    private fun binaryPrecedence(token: Token): Int = when (token.type) {
        TokenType.QUESTION_QUESTION -> 1
        TokenType.PIPE_PIPE -> 2
        TokenType.AMPERSAND_AMPERSAND -> 3
        TokenType.PIPE -> 4
        TokenType.CARET -> 5
        TokenType.AMPERSAND -> 6
        TokenType.EQUALS_EQUALS,
        TokenType.EXCLAMATION_EQUALS,
        TokenType.EQUALS_EQUALS_EQUALS,
        TokenType.EXCLAMATION_EQUALS_EQUALS,
        -> 7

        TokenType.LESS,
        TokenType.GREATER,
        TokenType.LESS_EQUALS,
        TokenType.GREATER_EQUALS,
        -> 8

        TokenType.LESS_LESS,
        TokenType.GREATER_GREATER,
        TokenType.GREATER_GREATER_GREATER,
        -> 9

        TokenType.PLUS, TokenType.MINUS -> 10
        TokenType.STAR, TokenType.SLASH, TokenType.PERCENT -> 11
        TokenType.STAR_STAR -> 12
        else -> if (token.type == TokenType.KEYWORD &&
            (token.keyword == Keyword.IN || token.keyword == Keyword.INSTANCEOF)
        ) {
            8
        } else {
            -1
        }
    }

    private fun parseUnaryExpression(): Expression {
        val start = current

        when (current.type) {
            TokenType.PLUS, TokenType.MINUS, TokenType.BANG, TokenType.TILDE -> {
                val operator = advance().text
                val operand = parseUnaryExpression()
                return UnaryExpression(operator, operand, true, spanOf(start))
            }

            TokenType.PLUS_PLUS, TokenType.MINUS_MINUS -> {
                val operator = advance().text
                val operand = parseUnaryExpression()
                return UpdateExpression(operator, operand, true, spanOf(start))
            }

            TokenType.LESS -> {
                // Angle bracket type assertion, only valid at the start of an expression.
                advance()
                val type = parseType()
                expectTypeArgumentCloseOrGreater()
                val expression = parseUnaryExpression()
                return TypeAssertionExpression(expression, type, spanOf(start))
            }

            else -> Unit
        }

        if (current.type == TokenType.KEYWORD) {
            when (current.keyword) {
                Keyword.TYPEOF, Keyword.VOID, Keyword.DELETE, Keyword.AWAIT -> {
                    val operator = advance().text
                    val operand = parseUnaryExpression()
                    return UnaryExpression(operator, operand, true, spanOf(start))
                }

                else -> Unit
            }
        }

        return parsePostfix()
    }

    private fun expectTypeArgumentCloseOrGreater() {
        splitGreaterRun()
        expect(TokenType.GREATER, "'>'")
    }

    private fun parsePostfix(): Expression {
        val start = current
        var expression = parsePrimary()
        expression = parseCallChain(expression, start)

        if ((check(TokenType.PLUS_PLUS) || check(TokenType.MINUS_MINUS)) && !current.precededByLineBreak) {
            val operator = advance().text
            expression = UpdateExpression(operator, expression, false, spanOf(start))
        }
        return expression
    }

    private fun parseCallChain(initial: Expression, start: Token): Expression {
        var expression = initial
        while (true) {
            when {
                check(TokenType.DOT) -> {
                    advance()
                    val name = expectPropertyName()
                    expression = MemberExpression(
                        expression, Identifier(name, previousToken().span), false, false, spanOf(start),
                    )
                }

                check(TokenType.QUESTION_DOT) -> {
                    advance()
                    if (check(TokenType.OPEN_PAREN)) {
                        val arguments = parseArguments()
                        expression = CallExpression(expression, arguments, emptyList(), true, spanOf(start))
                    } else if (check(TokenType.OPEN_BRACKET)) {
                        advance()
                        val index = parseExpression()
                        expect(TokenType.CLOSE_BRACKET, "']'")
                        expression = MemberExpression(expression, index, true, true, spanOf(start))
                    } else {
                        val name = expectPropertyName()
                        expression = MemberExpression(
                            expression, Identifier(name, previousToken().span), false, true, spanOf(start),
                        )
                    }
                }

                check(TokenType.OPEN_BRACKET) -> {
                    advance()
                    val index = parseExpression()
                    expect(TokenType.CLOSE_BRACKET, "']'")
                    expression = MemberExpression(expression, index, true, false, spanOf(start))
                }

                check(TokenType.OPEN_PAREN) -> {
                    val arguments = parseArguments()
                    expression = CallExpression(expression, arguments, emptyList(), false, spanOf(start))
                }

                check(TokenType.LESS) -> {
                    val saved = position
                    val typeArguments = try {
                        parseTypeArguments()
                    } catch (e: SyntaxException) {
                        position = saved
                        null
                    }
                    if (typeArguments != null && check(TokenType.OPEN_PAREN)) {
                        val arguments = parseArguments()
                        expression = CallExpression(expression, arguments, typeArguments, false, spanOf(start))
                    } else {
                        position = saved
                        break
                    }
                }

                check(TokenType.TEMPLATE_NO_SUBST) || check(TokenType.TEMPLATE_HEAD) -> {
                    val template = parseTemplateLiteral()
                    expression = TaggedTemplateExpression(expression, template, spanOf(start))
                }

                check(TokenType.BANG) && !current.precededByLineBreak -> {
                    advance()
                    expression = NonNullExpression(expression, spanOf(start))
                }

                checkKeyword(Keyword.AS) -> {
                    advance()
                    val type = parseType()
                    expression = AsExpression(expression, type, spanOf(start))
                }

                checkKeyword(Keyword.SATISFIES) -> {
                    advance()
                    val type = parseType()
                    expression = SatisfiesExpression(expression, type, spanOf(start))
                }

                else -> break
            }
        }
        return expression
    }

    private fun parseArguments(): List<Expression> {
        expect(TokenType.OPEN_PAREN, "'('")
        val arguments = mutableListOf<Expression>()
        while (!check(TokenType.CLOSE_PAREN) && !check(TokenType.EOF)) {
            if (match(TokenType.DOT_DOT_DOT)) {
                val start = previousToken()
                val argument = parseAssignmentExpression()
                arguments.add(SpreadElement(argument, spanOf(start)))
            } else {
                arguments.add(parseAssignmentExpression())
            }
            if (!match(TokenType.COMMA)) {
                break
            }
        }
        expect(TokenType.CLOSE_PAREN, "')'")
        return arguments
    }

    private fun parsePrimary(): Expression {
        val start = current

        when (current.type) {
            TokenType.IDENTIFIER -> return Identifier(advance().text, start.span)

            TokenType.NUMERIC_LITERAL -> {
                advance()
                val value = (start.value as? NumericValue)
                return NumericLiteral(
                    start.text, value?.value ?: 0.0, value?.isBigInt ?: false, start.span,
                )
            }

            TokenType.STRING_LITERAL -> return StringLiteral(
                stringValue(start), (start.value as? StringChunk)?.quote ?: '"',
                (advance()).span,
            )

            TokenType.REGEX_LITERAL -> {
                advance()
                val value = start.value as? RegexChunk
                return RegexLiteral(value?.pattern ?: "", value?.flags ?: "", start.span)
            }

            TokenType.TEMPLATE_NO_SUBST, TokenType.TEMPLATE_HEAD -> return parseTemplateLiteral()

            TokenType.OPEN_PAREN -> {
                advance()
                val inner = parseExpression()
                expect(TokenType.CLOSE_PAREN, "')'")
                return ParenthesizedExpression(inner, spanOf(start))
            }

            TokenType.OPEN_BRACKET -> return parseArrayLiteral()

            TokenType.OPEN_BRACE -> return parseObjectLiteral()

            else -> Unit
        }

        if (current.type == TokenType.KEYWORD) {
            when (current.keyword) {
                Keyword.THIS -> {
                    advance()
                    return SpecialExpression(SpecialExpression.Kind.THIS, start.span)
                }

                Keyword.SUPER -> {
                    advance()
                    return SpecialExpression(SpecialExpression.Kind.SUPER, start.span)
                }

                Keyword.TRUE -> {
                    advance()
                    return BooleanLiteral(true, start.span)
                }

                Keyword.FALSE -> {
                    advance()
                    return BooleanLiteral(false, start.span)
                }

                Keyword.NULL -> {
                    advance()
                    return NullLiteral(start.span)
                }

                Keyword.UNDEFINED -> {
                    advance()
                    return UndefinedLiteral(start.span)
                }

                Keyword.FUNCTION -> return parseFunctionExpression(false)

                Keyword.ASYNC -> {
                    if (peekToken(1).isKeyword(Keyword.FUNCTION)) {
                        advance()
                        return parseFunctionExpression(true)
                    }
                }

                Keyword.CLASS -> return parseClassExpression()

                Keyword.NEW -> return parseNewExpression()

                else -> Unit
            }
        }

        // Contextual words such as `object`, `string` or `type` are lexed as keywords but remain usable as
        // identifiers, so an expression position accepts any keyword that is not reserved.
        if (current.type == TokenType.KEYWORD && current.keyword?.isReservedWord != true) {
            return Identifier(advance().text, start.span)
        }

        throw unexpected("expected an expression")
    }

    private fun parseNewExpression(): Expression {
        val start = current
        advance() // new
        val typeArguments = if (check(TokenType.LESS)) {
            speculate { parseTypeArguments() } ?: emptyList()
        } else {
            emptyList()
        }
        var callee = if (check(TokenType.OPEN_PAREN)) {
            // `new (class extends Base { })(...)` and `new (factory())(...)` give the constructor itself
            // as a parenthesised expression, so the inner expression is the callee.
            advance()
            val inner = parseExpression()
            expect(TokenType.CLOSE_PAREN, "')'")
            inner
        } else {
            parsePrimary()
        }
        while (true) {
            when {
                check(TokenType.DOT) -> {
                    advance()
                    val name = expectPropertyName()
                    callee = MemberExpression(
                        callee, Identifier(name, previousToken().span), false, false, spanOf(start),
                    )
                }

                check(TokenType.OPEN_BRACKET) -> {
                    advance()
                    val index = parseExpression()
                    expect(TokenType.CLOSE_BRACKET, "']'")
                    callee = MemberExpression(callee, index, true, false, spanOf(start))
                }

                else -> break
            }
        }
        // `new Map<string, unknown>(1)` puts the type arguments on the constructed class, not on a call of the
        // result, so they are read here instead of being left to the call chain outside.
        var resolvedTypeArguments = typeArguments
        var arguments = emptyList<Expression>()
        if (check(TokenType.LESS)) {
            val saved = position
            val parsed = speculate { parseTypeArguments() }
            if (parsed != null && check(TokenType.OPEN_PAREN)) {
                resolvedTypeArguments = parsed
            } else {
                position = saved
                if (check(TokenType.OPEN_PAREN)) {
                    arguments = parseArguments()
                }
            }
        }
        if (arguments.isEmpty() && check(TokenType.OPEN_PAREN)) {
            arguments = parseArguments()
        }
        return NewExpression(callee, arguments, resolvedTypeArguments, spanOf(start))
    }

    private fun parseFunctionExpression(isAsync: Boolean): Expression {
        val start = current
        if (isAsync) {
            advance() // async
        }
        advance() // function
        val isGenerator = match(TokenType.STAR)
        val name = if (current.type == TokenType.IDENTIFIER || current.type == TokenType.OPEN_PAREN ||
            current.type == TokenType.LESS
        ) {
            if (current.type == TokenType.IDENTIFIER) advance().text else null
        } else {
            null
        }
        val typeParameters = parseTypeParameters()
        val parameters = parseParameters()
        val returnType = if (match(TokenType.COLON)) parseType() else null
        val body = parseFunctionBody()
        val node = FunctionExpression(name, parameters, body, isAsync, returnType, typeParameters)
        if (isGenerator) {
            // generator flag is not part of the function expression node; the body is kept as is
        }
        return node.copy(span = spanOf(start))
    }

    private fun parseClassExpression(): Expression {
        val start = current
        expectKeyword(Keyword.CLASS)
        val name = if (current.type == TokenType.IDENTIFIER && !current.isKeyword(Keyword.EXTENDS)) {
            advance().text
        } else {
            null
        }
        parseTypeParameters()
        val superClass = parseHeritage()
        val implementsTypes = parseImplements()
        val members = parseClassBody()
        return ClassExpression(name, superClass, members, implementsTypes, spanOf(start))
    }

    private fun parseArrayLiteral(): Expression {
        val start = expect(TokenType.OPEN_BRACKET, "'['")
        val elements = mutableListOf<Expression?>()
        while (!check(TokenType.CLOSE_BRACKET) && !check(TokenType.EOF)) {
            if (check(TokenType.COMMA)) {
                advance()
                elements.add(null)
                continue
            }
            if (match(TokenType.DOT_DOT_DOT)) {
                val spreadStart = previousToken()
                val argument = parseAssignmentExpression()
                elements.add(SpreadElement(argument, spanOf(spreadStart)))
            } else {
                elements.add(parseAssignmentExpression())
            }
            if (!match(TokenType.COMMA)) {
                break
            }
        }
        expect(TokenType.CLOSE_BRACKET, "']'")
        return ArrayLiteral(elements, spanOf(start))
    }

    private fun parseObjectLiteral(): Expression {
        val start = expect(TokenType.OPEN_BRACE, "'{'")
        val properties = mutableListOf<ObjectMember>()

        while (!check(TokenType.CLOSE_BRACE) && !check(TokenType.EOF)) {
            properties.add(parseObjectMember())
            if (!match(TokenType.COMMA)) {
                break
            }
        }

        expect(TokenType.CLOSE_BRACE, "'}'")
        return ObjectLiteral(properties, spanOf(start))
    }

    private fun parseObjectMember(): ObjectMember {
        val start = current

        if (check(TokenType.DOT_DOT_DOT)) {
            advance()
            val argument = parseAssignmentExpression()
            return SpreadPropertyMember(argument, spanOf(start))
        }

        var kind = MethodKind.METHOD
        var isAsync = false

        if (checkKeyword(Keyword.ASYNC)) {
            val next = peekToken(1)
            if (next.type == TokenType.IDENTIFIER || next.type == TokenType.KEYWORD ||
                next.type == TokenType.STRING_LITERAL || next.type == TokenType.NUMERIC_LITERAL ||
                next.type == TokenType.OPEN_BRACKET || next.type == TokenType.STAR
            ) {
                advance()
                isAsync = true
            }
        }

        if (checkWord("get") || checkWord("set")) {
            val next = peekToken(1)
            if (next.type == TokenType.IDENTIFIER || next.type == TokenType.KEYWORD ||
                next.type == TokenType.STRING_LITERAL || next.type == TokenType.NUMERIC_LITERAL ||
                next.type == TokenType.OPEN_BRACKET
            ) {
                kind = if (checkWord("get")) MethodKind.GET else MethodKind.SET
                advance()
            }
        }

        if (match(TokenType.STAR)) {
            // generator marker
        }

        val computed = check(TokenType.OPEN_BRACKET)
        var keyExpression: Expression? = null
        val key = if (computed) {
            advance()
            val inner = parseExpression()
            expect(TokenType.CLOSE_BRACKET, "']'")
            keyExpression = inner
            if (inner is Identifier) inner.name else inner.span.text(source)
        } else {
            expectPropertyName()
        }

        if (check(TokenType.OPEN_PAREN) || check(TokenType.LESS)) {
            if (check(TokenType.LESS)) {
                parseTypeParameters()
            }
            val parameters = parseParameters()
            val returnType = if (match(TokenType.COLON)) parseType() else null
            if (returnType != null) {
                // return type annotations are dropped here, the method body keeps the behaviour
            }
            val body = parseFunctionBody()
            return MethodMember(key, parameters, body, kind, isAsync, computed, keyExpression, spanOf(start))
        }

        if (match(TokenType.COLON)) {
            val value = parseAssignmentExpression()
            return PropertyMember(key, value, computed, keyExpression, spanOf(start))
        }

        var defaultValue: Expression? = null
        if (match(TokenType.EQUALS)) {
            defaultValue = parseAssignmentExpression()
        }
        return ShorthandPropertyMember(key, defaultValue, spanOf(start))
    }

    private fun parseTemplateLiteral(): TemplateLiteral {
        val start = current
        val quasis = mutableListOf<TemplateElement>()
        val expressions = mutableListOf<Expression>()

        if (check(TokenType.TEMPLATE_NO_SUBST)) {
            quasis.add(templateElement(advance()))
            return TemplateLiteral(quasis, expressions, spanOf(start))
        }

        expect(TokenType.TEMPLATE_HEAD, "a template head")
        quasis.add(templateElement(previousToken()))

        while (true) {
            expressions.add(parseExpression())

            if (check(TokenType.TEMPLATE_MIDDLE)) {
                quasis.add(templateElement(advance()))
                continue
            }
            if (check(TokenType.TEMPLATE_TAIL)) {
                quasis.add(templateElement(advance()))
                break
            }
            throw unexpected("expected the continuation of a template literal")
        }

        return TemplateLiteral(quasis, expressions, spanOf(start))
    }

    private fun templateElement(token: Token): TemplateElement {
        val chunk = token.value as? TemplateChunk
        return TemplateElement(chunk?.raw ?: token.text, chunk?.cooked ?: token.text)
    }

    private fun stringValue(token: Token): String =
        (token.value as? StringChunk)?.value ?: token.text
}
