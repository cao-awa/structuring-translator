package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.result.constant.undefined;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.result.constant.undefined.TypescriptNullTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.result.constant.TypescriptKotlinScriptConstantTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result.constant.undefined.TypescriptNull;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result.constant.undefined.TypescriptUndefined;

public class TypescriptKotlinScriptNullTranslator extends TypescriptKotlinScriptConstantTranslator<TypescriptNull> implements TypescriptNullTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptNull ast) {
        builder.append("null");
    }
}
