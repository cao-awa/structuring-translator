package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.result.constant.number;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.result.constant.number.TypescriptNumberTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.result.constant.TypescriptKotlinScriptConstantTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result.constant.number.TypescriptNumber;

public class TypescriptKotlinScriptNumberTranslator extends TypescriptKotlinScriptConstantTranslator<TypescriptNumber> implements TypescriptNumberTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptNumber ast) {
        builder.append(ast.literal());
    }
}
