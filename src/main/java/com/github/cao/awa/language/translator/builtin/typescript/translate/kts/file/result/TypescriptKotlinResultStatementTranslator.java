package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.result;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.result.TypescriptResultStatementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.TypescriptResultStatement;

public class TypescriptKotlinResultStatementTranslator extends TypescriptKotlinScriptTranslator<TypescriptResultStatement> implements TypescriptResultStatementTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptResultStatement ast) {
        translateStatement(this);
    }
}
