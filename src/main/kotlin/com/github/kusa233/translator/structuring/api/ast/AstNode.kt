package com.github.kusa233.translator.structuring.api.ast

import com.github.kusa233.translator.structuring.api.LanguageType
import com.github.kusa233.translator.structuring.api.SourceSpan

/**
 * Root of every syntax tree node, in every language.
 *
 * A node knows the source region it came from, so diagnostics and emitters can point back at it.
 */
interface AstNode {
    val span: SourceSpan
}

/**
 * A parsed translation unit: the single value a language parser produces and a language emitter consumes.
 *
 * Each language declares its own concrete subtype, which is what lets the registry stay language agnostic:
 * it moves units around and never looks inside them.
 */
interface TranslationUnit : AstNode {
    /** The language this unit was parsed from, or `null` when it was built by hand. */
    val sourceType: LanguageType?

    /** The file name the unit was read from, when known. */
    val fileName: String?
}
