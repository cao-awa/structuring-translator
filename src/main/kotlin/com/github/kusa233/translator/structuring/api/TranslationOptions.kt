package com.github.kusa233.translator.structuring.api

/**
 * Formatting knobs shared by every emitter.
 *
 * [DEFAULT] produces four space indentation and no trailing semicolons, which is what idiomatic Kotlin
 * script looks like.
 */
data class TranslationOptions(
    /** One indentation level. */
    val indent: String = "    ",

    /** Levels of indentation the whole document starts at. */
    val baseIndentLevel: Int = 0,

    /** Emit statement terminating semicolons even where the target language does not need them. */
    val useSemicolons: Boolean = false,

    /** Prefix the output with a comment naming the translator and the source file. */
    val emitHeaderComment: Boolean = false,

    /** Line separator written between output lines. */
    val lineSeparator: String = "\n",

    /**
     * Throw [UnsupportedNodeException] for nodes the emitter cannot translate instead of writing a
     * placeholder comment.
     */
    val failOnUnsupportedNode: Boolean = false,
) {
    /** The indentation prefix for [level], accounting for [baseIndentLevel]. */
    fun indent(level: Int): String = indent.repeat(baseIndentLevel + level)

    /** The suffix that terminates a statement, honouring [useSemicolons]. */
    fun terminator(): String = if (useSemicolons) ";" else ""

    companion object {
        val DEFAULT: TranslationOptions = TranslationOptions()
    }
}
