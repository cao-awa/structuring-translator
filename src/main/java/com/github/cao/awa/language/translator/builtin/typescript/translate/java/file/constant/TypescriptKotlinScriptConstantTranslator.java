package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.constant;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.constant.TypescriptConstantTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.TypescriptStatementElementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.TypescriptConstant;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;

public class TypescriptKotlinScriptConstantTranslator extends TypescriptKotlinScriptTranslator<TypescriptConstant<?>> implements TypescriptConstantTranslator<TypescriptConstant<?>> {
    @Override
    public void translate(StringBuilder builder, TypescriptConstant<?> ast) {
        translateConstant(this);
    }
}
