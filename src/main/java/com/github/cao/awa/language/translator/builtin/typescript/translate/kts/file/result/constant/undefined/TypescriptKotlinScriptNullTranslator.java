package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.result.constant.undefined;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.result.constant.string.TypescriptStringTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.result.constant.undefined.TypescriptNullTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.string.TypescriptString;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.undefined.TypescriptNull;

public class TypescriptKotlinScriptNullTranslator extends TypescriptKotlinScriptTranslator<TypescriptNull> implements TypescriptNullTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptNull ast) {
        builder.append("null");
    }
}
