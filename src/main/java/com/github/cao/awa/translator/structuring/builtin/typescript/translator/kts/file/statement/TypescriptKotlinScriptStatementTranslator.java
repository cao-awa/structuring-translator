package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.TypescriptStatementElementTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.translate.StructuringTranslator;
import org.jetbrains.annotations.NotNull;

public class TypescriptKotlinScriptStatementTranslator extends TypescriptKotlinScriptTranslator<TypescriptStatement> implements TypescriptStatementElementTranslator<TypescriptStatement> {
    @Override
    public void translate(StringBuilder builder, TypescriptStatement ast, @NotNull StructuringTranslator<?> source) {
        inheritIndent(source);
        translateIndent();
        translate(builder, ast);
    }

    @Override
    public void translate(StringBuilder builder, TypescriptStatement ast) {
        translateStatement(this);
    }
}
