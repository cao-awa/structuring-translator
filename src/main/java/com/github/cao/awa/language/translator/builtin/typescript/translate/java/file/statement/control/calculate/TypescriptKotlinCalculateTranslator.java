package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.control.calculate;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.calculate.TypescriptCalculateTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.TypescriptCalculate;

public class TypescriptKotlinCalculateTranslator extends TypescriptKotlinScriptTranslator<TypescriptCalculate> implements TypescriptCalculateTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptCalculate ast) {
        translateTotal(this);
    }
}
