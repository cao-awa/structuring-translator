package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.result.constant.undefined;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.result.constant.string.TypescriptStringTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.result.constant.undefined.TypescriptUndefinedTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.string.TypescriptString;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.undefined.TypescriptUndefined;

public class TypescriptKotlinScriptUndefinedTranslator extends TypescriptKotlinScriptTranslator<TypescriptUndefined> implements TypescriptUndefinedTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptUndefined ast) {
        builder.append("undefined");
    }
}
