package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.result.constant.string;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.result.constant.string.TypescriptStringTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.result.constant.TypescriptKotlinScriptConstantTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.constant.string.TypescriptString;

public class TypescriptKotlinScriptStringTranslator extends TypescriptKotlinScriptConstantTranslator<TypescriptString> implements TypescriptStringTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptString ast) {
        builder.append("\"").append(ast.literal()).append("\"");
    }
}
