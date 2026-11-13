package com.github.kusa233.translator.structuring

import com.github.kusa233.translator.structuring.api.LanguageRegistry
import com.github.kusa233.translator.structuring.api.LanguageType
import com.github.kusa233.translator.structuring.api.TranslationException
import com.github.kusa233.translator.structuring.api.TranslationOptions
import com.github.kusa233.translator.structuring.api.Translator
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import kotlin.system.exitProcess

/**
 * Command line front end.
 *
 * Usage:
 *   structuring-translator [options] input [output]
 *
 * Both languages are derived from the file names, so normally only the two paths are needed. When the
 * output path is omitted the translation is written to standard output. Options may pin the languages
 * explicitly, which is how a file without a recognised extension can still be translated.
 */
object Main {
    private val USAGE: String = """
Usage: structuring-translator [options] <input> [output]

  --from <type>             source language id; defaults to the input file extension
  --to <type>               target language id; defaults to the output file extension
  --indent <text>           one indentation level (default: four spaces)
  --semicolons              terminate statements with semicolons
  --header                  prepend a generated-by comment
  --strict                  fail when a node cannot be translated instead of writing a comment
  --base-indent <level>     start the document at this indentation level
  --list                    print the registered languages and exit
  --help                    print this text and exit
""".trimIndent()

    @JvmStatic
    fun main(args: Array<String>) {
        val exitCode = try {
            run(args.toList())
        } catch (e: TranslationException) {
            System.err.println("error: ${e.message}")
            1
        } catch (e: IllegalArgumentException) {
            System.err.println("error: ${e.message}")
            1
        } catch (e: IOException) {
            System.err.println("error: ${e.message}")
            1
        }
        exitProcess(exitCode)
    }

    /** Runs one invocation and returns the process exit code. */
    fun run(args: List<String>): Int {
        var sourceType: LanguageType? = null
        var targetType: LanguageType? = null
        var indent = "    "
        var useSemicolons = false
        var emitHeaderComment = false
        var failOnUnsupportedNode = false
        var baseIndentLevel = 0
        val positional = mutableListOf<String>()

        var index = 0
        while (index < args.size) {
            val argument = args[index]
            when (argument) {
                "--help", "-h" -> {
                    println(USAGE)
                    return 0
                }

                "--list" -> {
                    printLanguages(Translator.registry())
                    return 0
                }

                "--from", "--source" -> {
                    index += 1
                    sourceType = LanguageType.fromIdOrThrow(requireValue(args, index, argument))
                }

                "--to", "--target" -> {
                    index += 1
                    targetType = LanguageType.fromIdOrThrow(requireValue(args, index, argument))
                }

                "--indent" -> {
                    index += 1
                    indent = requireValue(args, index, argument)
                }

                "--base-indent" -> {
                    index += 1
                    baseIndentLevel = requireValue(args, index, argument).toIntOrNull()
                        ?: throw IllegalArgumentException("'$argument' expects a whole number")
                }

                "--semicolons" -> useSemicolons = true
                "--header" -> emitHeaderComment = true
                "--strict" -> failOnUnsupportedNode = true
                else -> {
                    if (argument.startsWith("--")) {
                        throw IllegalArgumentException("unknown option '$argument'")
                    }
                    positional.add(argument)
                }
            }
            index += 1
        }

        if (positional.isEmpty()) {
            throw IllegalArgumentException("no input file given\n\n$USAGE")
        }
        if (positional.size > 2) {
            throw IllegalArgumentException("expected at most one input and one output path")
        }

        val input = Path.of(positional[0])
        if (!Files.exists(input)) {
            throw IllegalArgumentException("input file '$input' does not exist")
        }
        val output = if (positional.size == 2) Path.of(positional[1]) else null

        val resolvedSource = sourceType ?: LanguageType.fromFileNameOrThrow(input.fileName.toString())
        val resolvedTarget = targetType
            ?: output?.let { LanguageType.fromFileNameOrThrow(it.fileName.toString()) }
            ?: throw IllegalArgumentException(
                "the target language cannot be derived: pass an output file or '--to <type>'",
            )

        val options = TranslationOptions(
            indent = indent,
            baseIndentLevel = baseIndentLevel,
            useSemicolons = useSemicolons,
            emitHeaderComment = emitHeaderComment,
            failOnUnsupportedNode = failOnUnsupportedNode,
        )
        val result = Translator.translate(
            resolvedSource,
            resolvedTarget,
            Files.readString(input),
            input.fileName.toString(),
            options,
        )

        if (output == null) {
            print(result)
            return 0
        }
        output.parent?.let { Files.createDirectories(it) }
        Files.writeString(output, result)
        println("${resolvedSource.id} -> ${resolvedTarget.id}: wrote ${output}")
        return 0
    }

    private fun requireValue(args: List<String>, index: Int, option: String): String {
        if (index >= args.size) {
            throw IllegalArgumentException("'$option' expects a value")
        }
        return args[index]
    }

    private fun printLanguages(registry: LanguageRegistry) {
        println("source languages:")
        for (type in registry.parsableSourceLanguages()) {
            println("  ${type.id} (${type.displayName})")
        }
        println("translations:")
        val pairs = registry.supportedTranslations()
        if (pairs.isEmpty()) {
            println("  <none>")
        } else {
            for ((source, target) in pairs) {
                println("  ${source.id} -> ${target.id}")
            }
        }
    }
}
