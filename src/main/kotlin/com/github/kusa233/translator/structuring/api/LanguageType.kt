package com.github.kusa233.translator.structuring.api

/**
 * Languages that can be used as a translation source or target.
 *
 * The translator registry is keyed by these values: a [LanguageType] can be used as source only when a
 * parser is registered for it, and as target only when an emitter is registered for it. Requesting an
 * unsupported combination raises [UnsupportedSourceLanguageException] or
 * [UnsupportedTargetLanguageException].
 */
enum class LanguageType(
    val id: String,
    val displayName: String,
    val fileExtensions: List<String>,
) {
    /** ECMAScript 2015 (ES6) with TypeScript syntax extensions. */
    TYPESCRIPT(
        id = "typescript",
        displayName = "TypeScript",
        fileExtensions = listOf("ts", "mts", "cts"),
    ),

    /** Kotlin script (`.kts`), the default translation target. */
    KOTLIN_SCRIPT(
        id = "kotlin-script",
        displayName = "Kotlin Script",
        fileExtensions = listOf("kts"),
    ),

    /**
     * Plain Kotlin source. Registered only so that callers can name it; it has no parser and no
     * emitter, so both directions raise an unsupported language error.
     */
    KOTLIN(
        id = "kotlin",
        displayName = "Kotlin",
        fileExtensions = listOf("kt"),
    ),

    /**
     * ECMAScript without the TypeScript extensions. No parser is registered yet, so it is a valid
     * demonstration of the "unimplemented source type" error path.
     */
    JAVASCRIPT(
        id = "javascript",
        displayName = "JavaScript",
        fileExtensions = listOf("js", "mjs", "cjs"),
    ),
    ;

    val primaryFileExtension: String get() = fileExtensions.first()

    fun matchesFileName(fileName: String): Boolean {
        val plain = fileName.substringAfterLast('/').substringAfterLast('\\')
        val dot = plain.lastIndexOf('.')
        if (dot <= 0) {
            return false
        }
        val extension = plain.substring(dot + 1).lowercase()
        return fileExtensions.any { it == extension }
    }

    companion object {
        private val byId: Map<String, LanguageType> = entries.associateBy { it.id }

        // The first language declaring an extension wins, so ordering of the entries is meaningful.
        private val byExtension: Map<String, LanguageType> = LinkedHashMap<String, LanguageType>().also { map ->
            for (each in entries) {
                for (extension in each.fileExtensions) {
                    map.putIfAbsent(extension, each)
                }
            }
        }

        fun fromId(id: String): LanguageType? = byId[id.trim().lowercase()]

        fun fromIdOrNull(id: String): LanguageType? = fromId(id)

        fun fromIdOrThrow(id: String): LanguageType = fromId(id) ?: throw UnsupportedLanguageException(
            "Unknown language type '$id'; known types are: " +
                entries.joinToString(", ") { it.id },
        )

        fun fromFileNameOrNull(fileName: String): LanguageType? {
            val plain = fileName.substringAfterLast('/').substringAfterLast('\\')
            val dot = plain.lastIndexOf('.')
            if (dot <= 0 || dot == plain.length - 1) {
                return null
            }
            return byExtension[plain.substring(dot + 1).lowercase()]
        }

        fun fromFileNameOrThrow(fileName: String): LanguageType = fromFileNameOrNull(fileName)
            ?: throw UnsupportedLanguageException(
                "Cannot infer a language type from file name '$fileName'; " +
                    "known extensions are: " +
                    entries.flatMap { it.fileExtensions }.sorted().joinToString(", ") { ".$it" },
            )

        fun fromExtensionOrNull(extension: String): LanguageType? =
            byExtension[extension.trim().removePrefix(".").lowercase()]
    }
}
