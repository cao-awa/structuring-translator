package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.result.constant.string;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.result.constant.string.TypescriptStringTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.string.TypescriptString;

public class TypescriptKotlinScriptStringTranslator extends TypescriptKotlinScriptTranslator<TypescriptString> implements TypescriptStringTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptString ast) {
        builder.append("\"").append(ast.literal()).append("\"");
    }
}
