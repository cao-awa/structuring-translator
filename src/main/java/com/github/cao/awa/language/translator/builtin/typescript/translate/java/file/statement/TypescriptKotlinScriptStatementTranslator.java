package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.TypescriptStatementElementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;

public class TypescriptKotlinScriptStatementTranslator extends TypescriptKotlinScriptTranslator<TypescriptStatement> implements TypescriptStatementElementTranslator<TypescriptStatement> {
    @Override
    public void translate(StringBuilder builder, TypescriptStatement ast) {
        translateStatement(this);
    }
}
