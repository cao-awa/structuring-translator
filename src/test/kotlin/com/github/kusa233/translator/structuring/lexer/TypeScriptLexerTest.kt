package com.github.kusa233.translator.structuring.lexer

import com.github.kusa233.translator.structuring.api.SyntaxException
import com.github.kusa233.translator.structuring.typescript.lexer.Keyword
import com.github.kusa233.translator.structuring.typescript.lexer.NumericValue
import com.github.kusa233.translator.structuring.typescript.lexer.RegexChunk
import com.github.kusa233.translator.structuring.typescript.lexer.StringChunk
import com.github.kusa233.translator.structuring.typescript.lexer.Token
import com.github.kusa233.translator.structuring.typescript.lexer.TokenType
import com.github.kusa233.translator.structuring.typescript.lexer.TypeScriptLexer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * Lexer behaviour, including the trivia the parser relies on for automatic semicolon insertion.
 */
class TypeScriptLexerTest {
    private fun lex(source: String): List<Token> = TypeScriptLexer(source).tokenize()

    /** The tokens without trivia; the last one is always the end of file marker. */
    private fun significant(source: String): List<Token> =
        lex(source).filter { it.type != TokenType.NEWLINE && it.type != TokenType.COMMENT }

    @Test
    fun `the stream ends with an end of file token`() {
        val tokens = lex("a")
        assertEquals(TokenType.EOF, tokens.last().type)
    }

    @Test
    fun `words become identifiers or keywords`() {
        val tokens = significant("let a = class")
        assertEquals(TokenType.KEYWORD, tokens[0].type)
        assertEquals(Keyword.LET, tokens[0].keyword)
        assertEquals(TokenType.IDENTIFIER, tokens[1].type)
        assertNull(tokens[1].keyword)
        assertEquals(Keyword.CLASS, tokens[3].keyword)
    }

    @Test
    fun `a typescript only keyword is recognised`() {
        val tokens = significant("interface")
        assertEquals(Keyword.INTERFACE, tokens[0].keyword)
        assertTrue(Keyword.isReserved("class"))
        assertTrue(!Keyword.isReserved("readonly"))
        assertTrue(!Keyword.isReserved("value"))
    }

    @Test
    fun `numbers keep their raw text and decoded value`() {
        val tokens = significant("0x1F 0b1010 1_000 1.5 2e3 10n")
        val values = tokens.dropLast(1).map { it.value as NumericValue }
        assertEquals(31.0, values[0].value)
        assertEquals(10.0, values[1].value)
        assertEquals(1000.0, values[2].value)
        assertEquals(1.5, values[3].value)
        assertEquals(2000.0, values[4].value)
        assertEquals(10.0, values[5].value)
        assertTrue(values[5].isBigInt)
        assertEquals("1_000", values[2].raw)
    }

    @Test
    fun `string escapes are decoded`() {
        val token = significant("'a\\nb\\u0041\\x41'").first()
        val chunk = token.value as StringChunk
        assertEquals("a\nbAA", chunk.value)
        assertEquals('\'', chunk.quote)
    }

    @Test
    fun `punctuators are matched longest first`() {
        val types = significant(">>>= a => b ... c ?. d").map { it.type }
        assertEquals(TokenType.GREATER_GREATER_GREATER_EQUALS, types[0])
        assertEquals(TokenType.ARROW, types[2])
        assertEquals(TokenType.DOT_DOT_DOT, types[4])
        assertEquals(TokenType.QUESTION_DOT, types[6])
    }

    @Test
    fun `a statement end is separated by a newline token`() {
        val tokens = lex("a\nb")
        assertTrue(tokens.any { it.type == TokenType.NEWLINE })
        val second = tokens.first { it.text == "b" }
        assertTrue(second.precededByLineBreak)
    }

    @Test
    fun `a comment is kept as trivia`() {
        val tokens = lex("// note\n/* block */ a")
        assertEquals(2, tokens.count { it.type == TokenType.COMMENT })
        assertEquals("// note", tokens.first { it.type == TokenType.COMMENT }.text)
    }

    @Test
    fun `a template without a substitution is one token`() {
        val token = significant("`plain`").first()
        assertEquals(TokenType.TEMPLATE_NO_SUBST, token.type)
    }

    @Test
    fun `a template with a substitution becomes head and tail`() {
        val types = significant("`a\${b}c`").map { it.type }
        assertEquals(
            listOf(TokenType.TEMPLATE_HEAD, TokenType.IDENTIFIER, TokenType.TEMPLATE_TAIL, TokenType.EOF),
            types,
        )
    }

    @Test
    fun `a slash after a value is division and a slash after an operator starts a regex`() {
        val divided = significant("a / b").map { it.type }
        assertEquals(TokenType.SLASH, divided[1])

        val regex = significant("x = /ab+/i").map { it.type }
        assertEquals(TokenType.REGEX_LITERAL, regex[2])
        val chunk = significant("x = /ab+/i")[2].value as RegexChunk
        assertEquals("ab+", chunk.pattern)
        assertEquals("i", chunk.flags)
    }

    @Test
    fun `a private name is a hash followed by an identifier`() {
        val types = significant("#name").map { it.type }
        assertEquals(TokenType.HASH, types[0])
        assertEquals(TokenType.IDENTIFIER, types[1])
    }

    @Test
    fun `positions are one based lines but zero based indexes`() {
        val token = significant("\n  abc").first()
        assertEquals(2, token.line)
        assertEquals(3, token.column)
        assertEquals(3, token.startIndex)
    }

    @Test
    fun `an unterminated string reports its position`() {
        val failure = assertThrows<SyntaxException> { lex("'abc") }
        assertEquals("lexer", failure.stage)
        assertNotNull(failure.span)
        assertTrue(failure.message!!.contains("Unterminated string"))
    }

    @Test
    fun `an unexpected character reports its position`() {
        val failure = assertThrows<SyntaxException> { lex("a \u0001 b") }
        assertTrue(failure.message!!.contains("Unexpected character"))
        assertEquals(1, failure.span.start.line)
    }
}
