package com.github.kusa233.translator.structuring.typescript.lexer

/**
 * Decoded payload of a string literal: the unescaped text plus the delimiter that was used.
 */
data class StringChunk(
    val value: String,
    val quote: Char,
)

/**
 * Decoded payload of a numeric token.
 */
data class NumericValue(
    val raw: String,
    val value: Double,
    val isBigInt: Boolean = false,
)

/**
 * Decoded payload of a regex literal token.
 */
data class RegexChunk(
    val pattern: String,
    val flags: String,
)

/**
 * One chunk of a template literal, with both the raw source text and its cooked (unescaped) value.
 */
data class TemplateChunk(
    val raw: String,
    val cooked: String,
)
