package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.result.constant.undefined;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.result.constant.undefined.TypescriptNullTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.result.constant.TypescriptKotlinScriptConstantTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.constant.undefined.TypescriptNull;

public class TypescriptKotlinScriptNullTranslator extends TypescriptKotlinScriptConstantTranslator<TypescriptNull> implements TypescriptNullTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptNull ast) {
        builder.append("null");
    }
}
