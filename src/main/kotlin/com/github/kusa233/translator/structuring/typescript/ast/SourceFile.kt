package com.github.kusa233.translator.structuring.typescript.ast

import com.github.kusa233.translator.structuring.api.LanguageType
import com.github.kusa233.translator.structuring.api.SourceSpan
import com.github.kusa233.translator.structuring.api.ast.TranslationUnit

/**
 * The TypeScript view of a translation unit: a flat list of top level statements.
 */
data class SourceFile(
    val statements: List<Statement>,
    override val fileName: String? = null,
    override val sourceType: LanguageType? = null,
    override val span: SourceSpan = SourceSpan.NONE,
) : TranslationUnit {
    /** Replaces the statement list, keeping the file identity. */
    fun copyWith(statements: List<Statement>): SourceFile = copy(statements = statements)
}
