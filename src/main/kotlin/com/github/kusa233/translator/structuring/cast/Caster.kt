package com.github.kusa233.translator.structuring.cast

object Caster {
    fun <T> cast(any: Any): T {
        @Suppress("UNCHECKED_CAST")
        return any as T
    }
}