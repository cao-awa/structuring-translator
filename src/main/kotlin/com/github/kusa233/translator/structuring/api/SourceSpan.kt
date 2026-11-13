package com.github.kusa233.translator.structuring.api

/**
 * A position inside a source text.
 *
 * [index] is a zero based character offset, [line] and [column] are one based.
 */
data class SourcePosition(
    val index: Int,
    val line: Int,
    val column: Int,
) {
    override fun toString(): String = "$line:$column"
}

/**
 * A half open range `[start, end)` inside a source text.
 */
data class SourceSpan(
    val start: SourcePosition,
    val end: SourcePosition,
) {
    val length: Int get() = end.index - start.index

    fun text(source: CharSequence): String {
        val from = start.index.coerceIn(0, source.length)
        val to = end.index.coerceIn(from, source.length)
        return source.subSequence(from, to).toString()
    }

    override fun toString(): String = "$start-$end"

    companion object {
        val NONE: SourceSpan = SourceSpan(
            SourcePosition(0, 1, 1),
            SourcePosition(0, 1, 1),
        )
    }
}
