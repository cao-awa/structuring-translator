package com.github.kusa233.translator.structuring.api

import com.github.kusa233.translator.structuring.api.ast.TranslationUnit

/**
 * A language front end: turns source text into [TranslationUnit].
 *
 * The registry keys parsers by [languageType]; a type without a parser cannot be used as a translation
 * source and raises [UnsupportedSourceLanguageException].
 */
interface LanguageParser {
    /** The language this parser reads. */
    val languageType: LanguageType

    /** Parses [source], reporting errors as [SyntaxException] with positions. */
    fun parse(source: String, fileName: String? = null): TranslationUnit
}

/**
 * A language back end: turns a [TranslationUnit] into text of the [targetType] language.
 *
 * Emitters are registered per source/target pair, so a missing pair raises
 * [UnsupportedTargetLanguageException].
 */
interface LanguageEmitter {
    /** The language the emitter expects in the AST. */
    val sourceType: LanguageType

    /** The language the emitter produces. */
    val targetType: LanguageType

    /** Renders [file] as [targetType] source text. */
    fun emit(file: TranslationUnit, options: TranslationOptions = TranslationOptions.DEFAULT): String
}

/**
 * Holds the registered parsers and emitters and enforces the "unimplemented type" errors.
 */
class LanguageRegistry {
    private val parsers = LinkedHashMap<LanguageType, LanguageParser>()
    private val emitters = LinkedHashMap<Pair<LanguageType, LanguageType>, LanguageEmitter>()

    fun registerParser(parser: LanguageParser): LanguageRegistry {
        parsers[parser.languageType] = parser
        return this
    }

    fun registerEmitter(emitter: LanguageEmitter): LanguageRegistry {
        emitters[emitter.sourceType to emitter.targetType] = emitter
        return this
    }

    fun unregisterParser(type: LanguageType): LanguageRegistry {
        parsers.remove(type)
        emitters.keys.removeIf { (source, _) -> source == type }
        return this
    }

    fun unregisterEmitter(sourceType: LanguageType, targetType: LanguageType): LanguageRegistry {
        emitters.remove(sourceType to targetType)
        return this
    }

    fun findParser(type: LanguageType): LanguageParser? = parsers[type]

    fun findEmitter(sourceType: LanguageType, targetType: LanguageType): LanguageEmitter? =
        emitters[sourceType to targetType]

    /** Source languages that can actually be parsed right now. */
    fun parsableSourceLanguages(): List<LanguageType> = parsers.keys.toList()

    /** Every `source -> target` pair that can actually be produced right now. */
    fun supportedTranslations(): List<Pair<LanguageType, LanguageType>> = emitters.keys.toList()

    /** Targets reachable from [sourceType]. */
    fun targetsOf(sourceType: LanguageType): List<LanguageType> =
        emitters.keys.filter { (source, _) -> source == sourceType }.map { (_, target) -> target }

    fun supportsSource(type: LanguageType): Boolean = parsers.containsKey(type)

    fun supportsTranslation(sourceType: LanguageType, targetType: LanguageType): Boolean =
        emitters.containsKey(sourceType to targetType)

    fun parse(
        sourceType: LanguageType,
        source: String,
        fileName: String? = null,
    ): TranslationUnit {
        val parser = parsers[sourceType] ?: throw UnsupportedSourceLanguageException(sourceType)
        return parser.parse(source, fileName)
    }

    fun translate(
        sourceType: LanguageType,
        targetType: LanguageType,
        source: String,
        fileName: String? = null,
        options: TranslationOptions = TranslationOptions.DEFAULT,
    ): String {
        // Both lookups happen before any parsing, so an unimplemented language is reported as such instead of
        // surfacing a syntax error from a language that was never parsed. The source is checked first: when the
        // source language itself has no front end, that is the error worth naming.
        val parser = parsers[sourceType] ?: throw UnsupportedSourceLanguageException(sourceType)
        val emitter = emitters[sourceType to targetType] ?: throw UnsupportedTargetLanguageException(
            sourceType,
            targetType,
        )
        return emitter.emit(parser.parse(source, fileName), options)
    }

    fun translate(
        file: TranslationUnit,
        targetType: LanguageType,
        options: TranslationOptions = TranslationOptions.DEFAULT,
    ): String {
        val sourceType = file.sourceType
            ?: throw TranslationException(
                "Cannot translate a detached AST: it carries no source language. " +
                    "Parse it through LanguageRegistry.parse or set the unit's sourceType.",
            )
        val emitter = emitters[sourceType to targetType] ?: throw UnsupportedTargetLanguageException(
            sourceType,
            targetType,
        )
        return emitter.emit(file, options)
    }

    fun translateFile(
        fileName: String,
        source: String,
        targetFileName: String,
        options: TranslationOptions = TranslationOptions.DEFAULT,
    ): String {
        val sourceType = LanguageType.fromFileNameOrThrow(fileName)
        val targetType = LanguageType.fromFileNameOrThrow(targetFileName)
        return translate(sourceType, targetType, source, fileName, options)
    }
}
