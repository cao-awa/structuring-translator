package com.github.kusa233.translator.structuring.api

import com.github.kusa233.translator.structuring.api.ast.TranslationUnit
import com.github.kusa233.translator.structuring.typescript.ast.SourceFile
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * The public entry point: language selection, the shared registry and the "unimplemented type" errors.
 */
class TranslatorApiTest {
    @Test
    fun `the bundled provider registers typescript and the kotlin script target`() {
        val registry = Translator.registry()
        assertTrue(registry.supportsSource(LanguageType.TYPESCRIPT))
        assertTrue(registry.supportsTranslation(LanguageType.TYPESCRIPT, LanguageType.KOTLIN_SCRIPT))
        assertEquals(listOf(LanguageType.TYPESCRIPT), registry.parsableSourceLanguages())
    }

    @Test
    fun `parsing returns a detached unit that knows its language`() {
        val unit = Translator.parse(LanguageType.TYPESCRIPT, "let a = 1;", "a.ts")
        assertTrue(unit is SourceFile)
        assertSame(LanguageType.TYPESCRIPT, unit.sourceType)
        assertEquals("a.ts", unit.fileName)
    }

    @Test
    fun `translating by explicit types produces kotlin script`() {
        val text = Translator.translate(LanguageType.TYPESCRIPT, LanguageType.KOTLIN_SCRIPT, "const a = 1;")
        assertEquals("val a = 1", text.trimEnd())
    }

    @Test
    fun `an unparsable source language is named in the error`() {
        val failure = assertThrows<UnsupportedSourceLanguageException> {
            Translator.translate(LanguageType.JAVASCRIPT, LanguageType.KOTLIN_SCRIPT, "let a = 1;")
        }
        assertSame(LanguageType.JAVASCRIPT, failure.sourceType)
        assertTrue(failure.message!!.contains("'javascript'"))
        assertTrue(failure.message!!.contains("'typescript'"))
    }

    @Test
    fun `an unimplemented target language is named in the error`() {
        val failure = assertThrows<UnsupportedTargetLanguageException> {
            Translator.translate(LanguageType.TYPESCRIPT, LanguageType.KOTLIN, "let a = 1;")
        }
        assertSame(LanguageType.TYPESCRIPT, failure.sourceType)
        assertSame(LanguageType.KOTLIN, failure.targetType)
        assertTrue(failure.message!!.contains("'kotlin'"))
        assertTrue(failure.message!!.contains("typescript -> kotlin-script"))
    }

    @Test
    fun `a source type without a parser fails before any parsing happens`() {
        // The text is not even valid TypeScript, but the missing parser must be reported first.
        val failure = assertThrows<UnsupportedSourceLanguageException> {
            Translator.translate(LanguageType.JAVASCRIPT, LanguageType.KOTLIN_SCRIPT, "!! not javascript at all")
        }
        assertSame(LanguageType.JAVASCRIPT, failure.sourceType)
    }

    @Test
    fun `a detached unit without a source language is rejected`() {
        val detached = object : TranslationUnit {
            override val fileName: String? = null
            override val sourceType: LanguageType? = null
            override val span: SourceSpan = SourceSpan.NONE
        }
        val failure = assertThrows<TranslationException> { Translator.translate(detached, LanguageType.KOTLIN_SCRIPT) }
        assertTrue(failure.message!!.contains("detached AST"))
    }

    @Test
    fun `the language is derived from the file names`() {
        val text = Translator.translateFile("input.ts", "let a = 1;", "output.kts")
        assertEquals("var a = 1", text.trimEnd())
    }

    @Test
    fun `an unknown extension is rejected`() {
        val failure = assertThrows<UnsupportedLanguageException> {
            Translator.translateFile("input.ts", "let a = 1;", "output.rs")
        }
        assertTrue(failure.message!!.contains(".kts"))
    }

    @Test
    fun `extensions map back to language types`() {
        assertSame(LanguageType.TYPESCRIPT, LanguageType.fromExtensionOrNull("ts"))
        assertSame(LanguageType.TYPESCRIPT, LanguageType.fromExtensionOrNull(".mts"))
        assertSame(LanguageType.KOTLIN_SCRIPT, LanguageType.fromExtensionOrNull("kts"))
        assertNull(LanguageType.fromExtensionOrNull("rs"))
        assertNull(LanguageType.fromId("cobol"))
        assertSame(LanguageType.JAVASCRIPT, LanguageType.fromIdOrThrow(" JavaScript "))
    }

    @Test
    fun `a file name only matches when the extension does`() {
        assertTrue(LanguageType.TYPESCRIPT.matchesFileName("dir/file.TS"))
        assertTrue(LanguageType.TYPESCRIPT.matchesFileName("file.cts"))
        assertFalse(LanguageType.TYPESCRIPT.matchesFileName("file.js"))
        assertFalse(LanguageType.TYPESCRIPT.matchesFileName("noextension"))
        assertSame(LanguageType.KOTLIN_SCRIPT, LanguageType.fromFileNameOrNull("C:\\tmp\\x.kts"))
    }

    @Test
    fun `translating needs no setup call and discovers the providers once`() {
        // No loadProviders call ahead of this: the first translate has to find the bundled provider itself.
        assertEquals("val a = 1", Translator.translate(LanguageType.TYPESCRIPT, LanguageType.KOTLIN_SCRIPT, "const a = 1;").trimEnd())
        // Discovery stays done, so the second call neither fails nor registers the provider a second time.
        assertEquals("val b = 2", Translator.translate(LanguageType.TYPESCRIPT, LanguageType.KOTLIN_SCRIPT, "const b = 2;").trimEnd())
        assertEquals(listOf(LanguageType.TYPESCRIPT), Translator.registry().parsableSourceLanguages())
    }

    @Test
    fun `an explicit registration survives the automatic discovery`() {
        val registry = Translator.registry()
        val emitter = object : LanguageEmitter {
            override val sourceType: LanguageType = LanguageType.JAVASCRIPT
            override val targetType: LanguageType = LanguageType.KOTLIN_SCRIPT

            override fun emit(file: TranslationUnit, options: TranslationOptions): String = "// replaced"
        }
        Translator.registerEmitter(emitter)
        try {
            assertSame(emitter, registry.findEmitter(LanguageType.JAVASCRIPT, LanguageType.KOTLIN_SCRIPT))
        } finally {
            registry.unregisterEmitter(LanguageType.JAVASCRIPT, LanguageType.KOTLIN_SCRIPT)
        }
        // The bundled languages are still the ones discovered on the classpath.
        assertTrue(registry.supportsSource(LanguageType.TYPESCRIPT))
    }

    @Test
    fun `a custom provider can extend the registry without touching the api`() {
        val registry = LanguageRegistry()
        Translator.loadProviders(registry, EchoProvider())
        assertTrue(registry.supportsSource(LanguageType.JAVASCRIPT))
        assertTrue(registry.supportsTranslation(LanguageType.JAVASCRIPT, LanguageType.KOTLIN_SCRIPT))

        val text = registry.translate(LanguageType.JAVASCRIPT, LanguageType.KOTLIN_SCRIPT, "anything")
        assertEquals("// anything", text)
    }

    @Test
    fun `the option record controls the emitted formatting`() {
        val options = TranslationOptions(useSemicolons = true, indent = "  ", baseIndentLevel = 1)
        val text = Translator.translate(
            LanguageType.TYPESCRIPT,
            LanguageType.KOTLIN_SCRIPT,
            "let a = 1;",
            options = options,
        )
        assertEquals("  var a = 1;", text.trimEnd())
    }

    @Test
    fun `an unsupported node is marked instead of throwing by default`() {
        val text = Translator.translate(
            LanguageType.TYPESCRIPT,
            LanguageType.KOTLIN_SCRIPT,
            "fetch('a');",
        )
        assertTrue(text.contains("not translatable"))
        assertNotNull(text)
    }

    @Test
    fun `an unsupported node throws when the caller asks for strictness`() {
        val failure = assertThrows<UnsupportedNodeException> {
            Translator.translate(
                LanguageType.TYPESCRIPT,
                LanguageType.KOTLIN_SCRIPT,
                "fetch('a');",
                options = TranslationOptions(failOnUnsupportedNode = true),
            )
        }
        assertSame(LanguageType.KOTLIN_SCRIPT, failure.targetType)
        assertTrue(failure.message!!.contains("fetch"))
    }

    /** A provider that only proves the span is language agnostic: it registers a fake JavaScript front end. */
    private class EchoProvider : LanguageProvider {
        override val id: String = "test-echo"

        override fun registerLanguages(registry: LanguageRegistry) {
            registry.registerParser(
                object : LanguageParser {
                    override val languageType: LanguageType = LanguageType.JAVASCRIPT

                    override fun parse(source: String, fileName: String?): TranslationUnit =
                        object : TranslationUnit {
                            override val fileName: String? = fileName
                            override val sourceType: LanguageType? = LanguageType.JAVASCRIPT
                            override val span: SourceSpan = SourceSpan.NONE

                            override fun toString(): String = source
                        }
                },
            )
            registry.registerEmitter(
                object : LanguageEmitter {
                    override val sourceType: LanguageType = LanguageType.JAVASCRIPT
                    override val targetType: LanguageType = LanguageType.KOTLIN_SCRIPT

                    override fun emit(file: TranslationUnit, options: TranslationOptions): String = "// $file"
                },
            )
        }
    }
}
