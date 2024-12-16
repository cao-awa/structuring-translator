package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.result.constant.undefined;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.result.constant.undefined.TypescriptUndefinedTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.result.constant.TypescriptKotlinScriptConstantTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result.constant.undefined.TypescriptUndefined;

public class TypescriptKotlinScriptUndefinedTranslator extends TypescriptKotlinScriptConstantTranslator<TypescriptUndefined> implements TypescriptUndefinedTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptUndefined ast) {
        builder.append("undefined");
    }
}
