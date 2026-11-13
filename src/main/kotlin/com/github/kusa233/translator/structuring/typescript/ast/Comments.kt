package com.github.kusa233.translator.structuring.typescript.ast

import com.github.kusa233.translator.structuring.api.SourceSpan
import com.github.kusa233.translator.structuring.api.ast.AstNode

/**
 * How a comment was written in the source. The variants follow the ECMAScript and TypeScript conventions.
 */
enum class CommentKind {
    /** A line comment, introduced by two slashes. */
    LINE,

    /** A documentation line comment, introduced by three slashes. */
    TRIPLE_SLASH,

    /** A block comment, opened by slash star and closed by star slash. */
    BLOCK,

    /** A documentation block comment, opened by slash star bang. */
    JSDOC,
}

/** A retained comment. Emitters may re-print it or skip it. */
data class Comment(
    val text: String,
    val kind: CommentKind,
    override val span: SourceSpan = SourceSpan.NONE,
) : AstNode
