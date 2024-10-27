package com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.number

import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.TypescriptConstant
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.vararg.TypescriptArgType
import com.github.cao.awa.language.translator.translate.tree.LanguageAst
import java.math.BigDecimal

class TypescriptNumber(parent: LanguageAst?) : TypescriptConstant<BigDecimal>(parent) {
    companion object {
        private val INT_MAX = BigDecimal(Int.MAX_VALUE)
        private val LONG_MAX = BigDecimal(Long.MAX_VALUE)
        private val DOUBLE_MAX = BigDecimal(Double.MAX_VALUE)
        private val FLOAT_MAX = BigDecimal(Float.MAX_VALUE.toString())
    }

    private var value: BigDecimal? = null
    private var isBigDecimal = false
    private var suffix = ""

    fun value(value: BigDecimal?) {
        this.value = value
    }

    override fun literal(): String {
        return if (this.isBigDecimal) {
            "BigDecimal(\"" + this.value.toString() + "\")"
        } else {
            this.value.toString() + this.suffix
        }
    }

    override fun constantValue(): BigDecimal {
        return this.value!!
    }

    override fun preprocess() {
        try {
            val type = findAst(TypescriptArgType::class.java)

            println("????")
            if (literal().contains(".")) {
                val compareDouble = value!!.compareTo(DOUBLE_MAX)
                if (compareDouble < 1) {
                } else {
                    this.isBigDecimal = true
                }
            }

            val compareInt = this.value!!.compareTo(INT_MAX)
            if (compareInt < 1) {
            } else {
                val compareLong = this.value!!.compareTo(LONG_MAX)
                if (compareLong < 1) {
                    this.suffix = "L"
                } else {
                    this.isBigDecimal = true
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
