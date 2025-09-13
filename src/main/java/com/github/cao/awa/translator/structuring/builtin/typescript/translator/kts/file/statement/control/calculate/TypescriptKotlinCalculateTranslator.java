package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.control.calculate;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.control.calculate.TypescriptCalculateTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.TypescriptCalculate;

public class TypescriptKotlinCalculateTranslator extends TypescriptKotlinScriptTranslator<TypescriptCalculate> implements TypescriptCalculateTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptCalculate ast) {
        translateTotal(this);
    }
}
