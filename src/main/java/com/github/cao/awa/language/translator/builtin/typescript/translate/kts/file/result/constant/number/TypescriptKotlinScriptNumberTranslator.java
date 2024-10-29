package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.result.constant.number;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.result.constant.number.TypescriptNumberTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.number.TypescriptNumber;

public class TypescriptKotlinScriptNumberTranslator extends TypescriptKotlinScriptTranslator<TypescriptNumber> implements TypescriptNumberTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptNumber ast) {
        builder.append(ast.literal());
    }
}
