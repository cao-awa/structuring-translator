package com.github.kusa233.translator.structuring.typescript.lexer

import com.github.kusa233.translator.structuring.api.SourcePosition
import com.github.kusa233.translator.structuring.api.SourceSpan

/**
 * One lexed token.
 *
 * [text] is the raw source slice. [value] holds the decoded payload for literals
 * (a [StringChunk], [NumericValue] or [RegexChunk], plus [TemplateChunk] for template parts).
 */
data class Token(
    val type: TokenType,
    val text: String,
    val span: SourceSpan,
    val keyword: Keyword? = null,
    val value: Any? = null,
    /** True when a line break precedes this token — used for automatic semicolon insertion. */
    val precededByLineBreak: Boolean = false,
) {
    val line: Int get() = span.start.line
    val column: Int get() = span.start.column
    val startIndex: Int get() = span.start.index
    val endIndex: Int get() = span.end.index

    fun isIdentifier(name: String): Boolean =
        type == TokenType.IDENTIFIER && text == name

    fun isKeyword(keyword: Keyword): Boolean =
        type == TokenType.KEYWORD && this.keyword == keyword

    fun isKeyword(name: String): Boolean =
        type == TokenType.KEYWORD && text == name

    override fun toString(): String = when (type) {
        TokenType.EOF -> "EOF"
        TokenType.KEYWORD -> "KEYWORD($text)"
        else -> "${type}('$text')"
    }

    companion object {
        fun eof(index: Int, line: Int, column: Int): Token {
            val position = SourcePosition(index, line, column)
            return Token(TokenType.EOF, "", SourceSpan(position, position))
        }
    }
}
