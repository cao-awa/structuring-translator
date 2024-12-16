package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.TypescriptStatementElementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.translate.LanguageTranslator;
import org.jetbrains.annotations.NotNull;

public class TypescriptKotlinScriptStatementTranslator extends TypescriptKotlinScriptTranslator<TypescriptStatement> implements TypescriptStatementElementTranslator<TypescriptStatement> {
    @Override
    public void translate(StringBuilder builder, TypescriptStatement ast, @NotNull LanguageTranslator<?> source) {
        inheritIdent(source);
        translateIdent();
        translate(builder, ast);
    }

    @Override
    public void translate(StringBuilder builder, TypescriptStatement ast) {
        translateStatement(this);
    }
}
