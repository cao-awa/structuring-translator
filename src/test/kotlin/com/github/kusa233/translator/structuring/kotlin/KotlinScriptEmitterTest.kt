package com.github.kusa233.translator.structuring.kotlin

import com.github.kusa233.translator.structuring.api.LanguageType
import com.github.kusa233.translator.structuring.api.TranslationOptions
import com.github.kusa233.translator.structuring.api.Translator
import java.io.File
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * End to end checks: TypeScript source in, Kotlin script out.
 *
 * The samples are also checked against the rendered files kept next to them, so a change in the emitter has to be
 * reflected in the samples. Regenerate them with the command line entry point:
 * `structuring-translator samples/micro.ts samples/micro.out.kts`.
 */
class KotlinScriptEmitterTest {
    private fun translate(source: String, options: TranslationOptions = TranslationOptions.DEFAULT): String =
        Translator.translate(LanguageType.TYPESCRIPT, LanguageType.KOTLIN_SCRIPT, source, options = options)

    private fun sample(name: String): String = File("samples", name).readText()

    @Test
    fun `the declaration kind decides between var and val`() {
        assertEquals("var a = 1", translate("let a = 1;").trimEnd())
        assertEquals("var b = 1", translate("var b = 1;").trimEnd())
        assertEquals("val c = 1", translate("const c = 1;").trimEnd())
    }

    @Test
    fun `an uninitialised declaration gains a null initializer`() {
        assertEquals("var a: Any? = null", translate("let a;").trimEnd())
        assertEquals("var a: Double? = null", translate("let a: number;").trimEnd())
    }

    @Test
    fun `a function keeps its parameters and return type`() {
        val text = translate("function add(a: number, b: number): number { return a + b; }")
        assertEquals(
            listOf(
                "fun add(a: Double, b: Double): Double {",
                "    return a + b",
                "}",
            ),
            text.trimEnd().lines(),
        )
    }

    @Test
    fun `an untyped parameter becomes a nullable any`() {
        assertTrue(translate("function f(a) { }").contains("fun f(a: Any?)"))
    }

    @Test
    fun `an array literal becomes a mutable list`() {
        assertEquals("val a = mutableListOf(1, 2, 3)", translate("const a = [1, 2, 3];").trimEnd())
    }

    @Test
    fun `an object literal without methods becomes a map`() {
        assertEquals(
            "val o = mutableMapOf(\"k\" to 1)",
            translate("const o = { k: 1 };").trimEnd(),
        )
    }

    @Test
    fun `an object literal with methods becomes an anonymous object`() {
        val text = translate("const o = { count: 1, bump() { this.count += 1; } };")
        assertTrue(text.contains("val o = object {"))
        assertTrue(text.contains("fun bump()"))
    }

    @Test
    fun `an arrow with an expression body stays a lambda`() {
        assertEquals("val f = { x: Any? -> x * 2 }", translate("const f = (x) => x * 2;").trimEnd())
    }

    @Test
    fun `an arrow with a block body becomes an anonymous function`() {
        val text = translate("const f = (x) => { return x; };")
        assertTrue(text.contains("fun(x: Any?)"))
        assertTrue(text.contains("return x"))
    }

    @Test
    fun `a class keeps its heritage and moves statics into a companion`() {
        val text = translate(
            """
            class Point extends Base {
                static origin = 0;
                x = 0;
                move(dx: number): void { this.x += dx; }
            }
            """.trimIndent(),
        )
        assertTrue(text.contains("class Point : Base() {"))
        assertTrue(text.contains("companion object {"))
        assertTrue(text.contains("fun move(dx: Double): Unit {"))
    }

    @Test
    fun `an abstract class keeps its abstract member`() {
        val text = translate("abstract class Base { abstract area(): number; }")
        assertTrue(text.contains("abstract class Base {"))
        assertTrue(text.contains("abstract fun area(): Double"))
    }

    @Test
    fun `an overload signature becomes a comment`() {
        val text = translate(
            """
            function f(a: number): void;
            function f(a: string): void;
            function f(a: any): void { }
            """.trimIndent(),
        )
        assertTrue(text.contains("// overload fun f(a: Double): Unit"))
        assertTrue(text.contains("fun f(a: Any?): Unit"))
    }

    @Test
    fun `a c style loop is rewritten as a while loop`() {
        val text = translate("for (let i = 0; i < 3; i++) { use(i); }")
        val lines = text.trimEnd().lines()
        assertEquals("var i = 0", lines[0])
        assertTrue(lines[1].startsWith("while (i < 3) {"))
        assertTrue(text.contains("i++"))
    }

    @Test
    fun `a for of loop becomes a plain for loop`() {
        assertTrue(translate("for (const i of items) { use(i); }").contains("for (i in items) {"))
    }

    @Test
    fun `a switch becomes a when`() {
        val text = translate("switch (a) { case 1: b(); break; default: c(); }")
        assertEquals(
            listOf(
                "when (a) {",
                "    1 -> run case0@ {",
                "        b()",
                "        return@case0",
                "    }",
                "    else -> {",
                "        c()",
                "    }",
                "}",
            ),
            text.trimEnd().lines(),
        )
    }

    @Test
    fun `a try statement keeps its handler and finalizer`() {
        val text = translate("try { a(); } catch (e) { b(); } finally { c(); }")
        assertTrue(text.contains("} catch (e: Throwable) {"))
        assertTrue(text.contains("} finally {"))
    }

    @Test
    fun `a thrown error becomes a kotlin exception`() {
        assertTrue(translate("throw new Error('boom');").contains("throw RuntimeException(\"boom\")"))
        assertTrue(translate("throw new TypeError('x');").contains("ClassCastException"))
    }

    @Test
    fun `a thrown non exception is wrapped`() {
        assertTrue(translate("throw 'bad';").contains(".toString()"))
    }

    @Test
    fun `console output is redirected to println`() {
        assertEquals("println(\"a\")", translate("console.log('a');").trimEnd())
        assertEquals(
            "println(listOf(\"a\", b).joinToString(\" \"))",
            translate("console.log('a', b);").trimEnd(),
        )
        assertTrue(translate("console.error('x');").contains("System.err.println"))
    }

    @Test
    fun `the equality, power and bitwise operators are rewritten`() {
        assertTrue(translate("const a = b === c;").contains("b == c"))
        assertTrue(translate("const a = b !== c;").contains("b != c"))
        assertTrue(translate("const a = b ** 2;").contains("Math.pow(b, 2)"))
        assertTrue(translate("const a = b >>> 1;").contains("b ushr 1"))
        assertTrue(translate("const a = b & c;").contains("b and c"))
        assertTrue(translate("const a = ~b;").contains("b.inv()"))
    }

    @Test
    fun `a nullish coalesce becomes an elvis operator`() {
        assertTrue(translate("const a = b ?? c;").contains("b ?: c"))
    }

    @Test
    fun `a ternary becomes an if expression`() {
        assertTrue(translate("const a = b ? 1 : 2;").contains("if (b) 1 else 2"))
    }

    @Test
    fun `an instanceof test becomes an is check`() {
        assertTrue(translate("const a = b instanceof C;").contains("b is C"))
    }

    @Test
    fun `an await becomes a call on the awaited value`() {
        assertTrue(translate("async function f(p) { const r = await p; }").contains("p.await()"))
    }

    @Test
    fun `a promise all becomes an awaitAll call`() {
        val text = translate("const a = await Promise.all(items);")
        assertTrue(text.contains("items.awaitAll()"))
        assertFalse(text.contains("awaitAll().await()"))
    }

    @Test
    fun `an imported module is kept as a comment`() {
        assertTrue(translate("import { a } from 'b';").contains("// import { a } from"))
    }

    @Test
    fun `an interface becomes an interface`() {
        val text = translate("interface A { x: number; run(): void }")
        assertTrue(text.contains("interface A {"))
        assertTrue(text.contains("val x: Double"))
    }

    @Test
    fun `a type alias becomes a typealias`() {
        assertTrue(translate("type A = number | string;").contains("typealias A ="))
    }

    @Test
    fun `an enum becomes an enum class`() {
        val text = translate("enum Color { Red, Green = 2 }")
        assertTrue(text.contains("enum class Color"))
        assertTrue(text.contains("Red"))
        assertTrue(text.contains("Green"))
    }

    @Test
    fun `a namespace becomes an object`() {
        val text = translate("namespace A { export const b = 1; }")
        assertTrue(text.contains("object A {"))
        assertTrue(text.contains("val b = 1"))
    }

    @Test
    fun `a generator becomes a sequence`() {
        val text = translate("function* gen() { yield 1; }")
        assertTrue(text.contains("fun gen(): Sequence<Any?> = sequence {"))
        assertTrue(text.contains("yield(1)"))
    }

    @Test
    fun `an unmapped host api is marked instead of silently kept`() {
        assertTrue(translate("fetch('a');").contains("not translatable"))
        assertTrue(translate("setTimeout(f, 1);").contains("not translatable"))
    }

    @Test
    fun `a mapped name only applies to a known collection`() {
        val list = translate("const a = [1]; const n = a.length;")
        assertTrue(list.contains("a.size"))
        val unknown = translate("const n = something.length;")
        assertTrue(unknown.contains("something.length"))
    }

    @Test
    fun `the options control indentation and terminators`() {
        val text = translate(
            "function f() { return 1; }",
            TranslationOptions(indent = "  ", useSemicolons = true),
        )
        assertEquals(
            listOf(
                "fun f(): Any? {",
                "  return 1;",
                "}",
            ),
            text.trimEnd().lines(),
        )
    }

    @Test
    fun `the header comment names both languages`() {
        val text = translate("let a = 1;", TranslationOptions(emitHeaderComment = true))
        assertTrue(text.startsWith("// Generated by structuring-translator: typescript -> kotlin-script"))
    }

    @Test
    fun `the micro sample matches its recorded output`() {
        val produced = Translator.translate(
            LanguageType.TYPESCRIPT,
            LanguageType.KOTLIN_SCRIPT,
            sample("micro.ts"),
            "micro.ts",
        )
        assertEquals(sample("micro.out.kts").trimEnd(), produced.trimEnd())
    }

    @Test
    fun `the stress sample matches its recorded output`() {
        val produced = Translator.translate(
            LanguageType.TYPESCRIPT,
            LanguageType.KOTLIN_SCRIPT,
            sample("stress.ts"),
            "stress.ts",
        )
        assertEquals(sample("stress.out.kts").trimEnd(), produced.trimEnd())
    }
}
