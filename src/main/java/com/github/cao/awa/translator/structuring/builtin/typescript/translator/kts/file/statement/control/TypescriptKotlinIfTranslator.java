package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.control;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.control.TypescriptIfTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.TypescriptIf;
import com.github.cao.awa.translator.structuring.translate.StructuringTranslator;
import org.jetbrains.annotations.NotNull;

public class TypescriptKotlinIfTranslator extends TypescriptKotlinScriptTranslator<TypescriptIf> implements TypescriptIfTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptIf ast, @NotNull StructuringTranslator<?> source) {
        inheritIndent(source);
        translate(builder, ast);
    }

    @Override
    public void translate(StringBuilder builder, TypescriptIf ast) {
        builder.append("if(");
        postTranslate(TypescriptTranslateElement.STATEMENT, ast.predicate(), false);
        builder.append("){");
        translateLineWrap(this);

        pushIndent();
        for (TypescriptStatement statement : ast.statements()) {
            postTranslate(TypescriptTranslateElement.STATEMENT, statement);
            if (!statement.isEnding()) {
                translateEnding(this);
            }
        }
        popIndent();

        translateIndent();

        builder.append("}");

        if (!ast.elseStatements().isEmpty()) {
            builder.append("else{");
            translateLineWrap(this);

            pushIndent();
            for (TypescriptStatement statement : ast.elseStatements()) {
                postTranslate(TypescriptTranslateElement.STATEMENT, statement);
                if (!statement.isEnding()) {
                    translateEnding(this);
                }
            }
            popIndent();

            translateIndent();

            builder.append("}");
        }

        translateLineWrap(this);

        if (ast.elseIfStatement() != null) {
            postTranslate(TypescriptTranslateElement.IF, ast.elseIfStatement());
        }
    }
}
