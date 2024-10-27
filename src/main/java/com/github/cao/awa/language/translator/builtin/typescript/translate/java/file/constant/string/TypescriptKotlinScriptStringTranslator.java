package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.constant.string;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.constant.string.TypescriptStringTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.string.TypescriptString;

public class TypescriptKotlinScriptStringTranslator extends TypescriptKotlinScriptTranslator<TypescriptString> implements TypescriptStringTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptString ast) {
        builder.append("\"").append(ast.literal()).append("\"");
    }
}
