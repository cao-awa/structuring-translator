package com.github.kusa233.translator.structuring.api

/**
 * Base class of every failure raised by the translator.
 */
open class TranslationException(
    message: String,
    cause: Throwable? = null,
) : RuntimeException(message, cause)

/**
 * Raised when a language id / file extension cannot be resolved to a known [LanguageType].
 */
class UnsupportedLanguageException(
    message: String,
) : TranslationException(message)

/**
 * Raised when [sourceType] has no registered parser.
 *
 * The message always names the offending source type so callers can surface it directly.
 */
class UnsupportedSourceLanguageException(
    val sourceType: LanguageType,
) : TranslationException(
    "No parser is registered for source language '${sourceType.id}' (${sourceType.displayName}); " +
        "supported source languages are: " +
        Translator.registry().parsableSourceLanguages().joinToString(", ") { "'${it.id}'" },
)

/**
 * Raised when no emitter is registered for the requested source -> target pair.
 *
 * The message always names the offending source type (and the target) so callers can surface it directly.
 */
class UnsupportedTargetLanguageException(
    val sourceType: LanguageType,
    val targetType: LanguageType,
) : TranslationException(
    buildString {
        append("No translation from source language '${sourceType.id}' to target language '${targetType.id}' ")
        append("is registered; supported translations are: ")
        val pairs = Translator.registry().supportedTranslations()
        append(
            if (pairs.isEmpty()) {
                "<none>"
            } else {
                pairs.joinToString(", ") { (source, target) -> "${source.id} -> ${target.id}" }
            },
        )
    },
)

/**
 * Raised by the lexer or parser. Carries the position so tooling can print a caret diagnostic.
 */
class SyntaxException(
    val stage: String,
    message: String,
    val span: SourceSpan,
) : TranslationException("$message (at $span)")

/**
 * Raised when an AST node cannot be expressed in the requested target language.
 */
class UnsupportedNodeException(
    val targetType: LanguageType,
    val nodeType: String,
    message: String,
) : TranslationException("Cannot translate node '$nodeType' to '${targetType.id}': $message")
