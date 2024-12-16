package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.result.constant;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.result.constant.TypescriptConstantTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result.constant.TypescriptConstant;
import com.github.cao.awa.language.translator.translate.LanguageTranslator;
import org.jetbrains.annotations.NotNull;

public class TypescriptKotlinScriptConstantTranslator<C extends TypescriptConstant<?>> extends TypescriptKotlinScriptTranslator<C> implements TypescriptConstantTranslator<C> {
    @Override
    public void translate(StringBuilder builder, C ast, @NotNull LanguageTranslator<?> source) {
        inheritIdent(source);
        translateIdent();
        translate(builder, ast);
    }

    @Override
    public void translate(StringBuilder builder, C ast) {
        translateConstant(this);
    }
}
