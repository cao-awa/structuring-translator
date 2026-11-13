package com.github.kusa233.translator.structuring.builtin

import com.github.kusa233.translator.structuring.api.LanguageProvider
import com.github.kusa233.translator.structuring.api.LanguageRegistry
import com.github.kusa233.translator.structuring.api.Translator
import com.github.kusa233.translator.structuring.kotlin.KotlinScriptEmitter
import com.github.kusa233.translator.structuring.typescript.parser.TypeScriptParser

/**
 * Wires the front end and the back end that ship with this library.
 *
 * This is the only class that names both a front end and a back end, which keeps the api package free
 * of any language specific reference. It is listed in the service descriptor for [LanguageProvider], so
 * [Translator] finds it without importing it.
 */
class BuiltinLanguageProvider : LanguageProvider {
    override val id: String = "builtin"

    override fun registerLanguages(registry: LanguageRegistry) {
        registry.registerParser(TypeScriptParser())
        registry.registerEmitter(KotlinScriptEmitter())
    }
}
