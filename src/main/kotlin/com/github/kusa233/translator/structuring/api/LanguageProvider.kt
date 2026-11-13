package com.github.kusa233.translator.structuring.api

/**
 * Contributes parsers and emitters to a [LanguageRegistry].
 *
 * The contract lives in the api package on purpose: it mentions no particular language, so a jar that
 * adds a front end or a back end only has to implement this interface and be listed as a service.
 * [Translator] discovers implementations through the service loader, and [Translator.registerParser]
 * remains available for callers that prefer to wire a language by hand.
 */
interface LanguageProvider {
    /** A short identifier, used only in diagnostics. */
    val id: String

    /** Adds every parser and emitter this provider knows about to [registry]. */
    fun registerLanguages(registry: LanguageRegistry)
}
