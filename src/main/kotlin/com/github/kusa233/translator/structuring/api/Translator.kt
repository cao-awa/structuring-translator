package com.github.kusa233.translator.structuring.api

import com.github.kusa233.translator.structuring.api.ast.TranslationUnit
import java.util.ServiceLoader

/**
 * A single entry point for parsing, translating and formatting source code.
 *
 * Every method takes the source [LanguageType] explicitly; when that type has no parser, or when no
 * translation to the requested [LanguageType] exists, an exception naming the offending type is raised.
 *
 * The shared registry fills itself on first use: the first call that needs a language runs the
 * [LanguageProvider] implementations announced on the classpath, which is how the bundled front ends and
 * back ends are wired in without this api package ever naming one. No setup call is required, and the
 * discovery happens once, so repeated calls do not register the same provider twice. Explicit
 * [registerParser] and [registerEmitter] calls always win, because they run after discovery.
 */
object Translator {
    private val defaultRegistry = LanguageRegistry()

    /** Guards [providersLoaded] so that concurrent first calls discover the providers only once. */
    private val loadLock = Any()

    @Volatile
    private var providersLoaded = false

    /**
     * The shared registry, with the languages announced on the classpath already registered.
     *
     * Discovered languages win over nothing: a caller that registered its own parser keeps it, because
     * discovery has already happened by the time that registration runs.
     */
    fun registry(): LanguageRegistry {
        ensureProvidersLoaded(defaultRegistry)
        return defaultRegistry
    }

    fun registerParser(parser: LanguageParser): LanguageRegistry {
        ensureProvidersLoaded(defaultRegistry)
        return defaultRegistry.registerParser(parser)
    }

    fun registerEmitter(emitter: LanguageEmitter): LanguageRegistry {
        ensureProvidersLoaded(defaultRegistry)
        return defaultRegistry.registerEmitter(emitter)
    }

    /** Parses [source] as [sourceType] and returns its AST. */
    fun parse(
        sourceType: LanguageType,
        source: String,
        fileName: String? = null,
    ): TranslationUnit {
        ensureProvidersLoaded(defaultRegistry)
        return defaultRegistry.parse(sourceType, source, fileName)
    }

    /** Parses [source] as [sourceType] and emits [targetType]. */
    fun translate(
        sourceType: LanguageType,
        targetType: LanguageType,
        source: String,
        fileName: String? = null,
        options: TranslationOptions = TranslationOptions.DEFAULT,
    ): String {
        ensureProvidersLoaded(defaultRegistry)
        return defaultRegistry.translate(sourceType, targetType, source, fileName, options)
    }

    /** Translates an already parsed [ast]. */
    fun translate(
        ast: TranslationUnit,
        targetType: LanguageType,
        options: TranslationOptions = TranslationOptions.DEFAULT,
    ): String {
        ensureProvidersLoaded(defaultRegistry)
        return defaultRegistry.translate(ast, targetType, options)
    }

    /** Translates a whole file, deriving both languages from the file names. */
    fun translateFile(
        fileName: String,
        source: String,
        targetFileName: String,
        options: TranslationOptions = TranslationOptions.DEFAULT,
    ): String {
        ensureProvidersLoaded(defaultRegistry)
        return defaultRegistry.translateFile(fileName, source, targetFileName, options)
    }

    /** Registers every provider reachable through the service loader, plus any [extra] given explicitly. */
    fun loadProviders(
        registry: LanguageRegistry = defaultRegistry,
        vararg extra: LanguageProvider,
    ): LanguageRegistry {
        if (registry === defaultRegistry) {
            providersLoaded = true
        }
        for (provider in ServiceLoader.load(LanguageProvider::class.java)) {
            provider.registerLanguages(registry)
        }
        for (provider in extra) {
            provider.registerLanguages(registry)
        }
        return registry
    }

    /**
     * Runs the classpath discovery against [registry] the first time a language is needed.
     *
     * The flag is set before the providers run, so a provider that somehow reaches back into the api still
     * sees a loaded registry instead of recursing.
     */
    private fun ensureProvidersLoaded(registry: LanguageRegistry) {
        if (providersLoaded) {
            return
        }
        synchronized(loadLock) {
            if (providersLoaded) {
                return
            }
            loadProviders(registry)
        }
    }
}
