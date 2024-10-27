package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.constant.bool;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.constant.number.TypescriptNumberTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.number.TypescriptNumber;

public class TypescriptKotlinScriptBooleanTranslator extends TypescriptKotlinScriptTranslator<TypescriptNumber> implements TypescriptNumberTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptNumber ast) {
        builder.append(ast.literal());
    }
}
