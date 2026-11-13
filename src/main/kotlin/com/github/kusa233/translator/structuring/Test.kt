package com.github.kusa233.translator.structuring

import com.github.kusa233.translator.structuring.api.LanguageType
import com.github.kusa233.translator.structuring.api.Translator
import java.io.File
import java.nio.charset.StandardCharsets

fun main() {
    // No setup call: the first use of the registry discovers the providers on the classpath.
    val registry = Translator.registry()
    println(registry.parsableSourceLanguages())
    val contents: MutableMap<File, String> = mutableMapOf()
    val files: MutableList<File> = mutableListOf()
    for (file in File("samples/").listFiles()) {
        if (file.name.endsWith(".ts")) {
            files.add(file)
        }
    }
    for (file in files) {
        contents[file] = file.readText(StandardCharsets.UTF_8)
    }
    for ((file, content) in contents) {
        val result = Translator.translate(LanguageType.TYPESCRIPT, LanguageType.KOTLIN_SCRIPT, content)
        println("----- ${file.name} -----")
        println(result)
    }
}