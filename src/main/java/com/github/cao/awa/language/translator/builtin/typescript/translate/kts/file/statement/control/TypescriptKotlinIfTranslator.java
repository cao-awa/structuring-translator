package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.TypescriptIfTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.TypescriptIf;
import com.github.cao.awa.language.translator.translate.LanguageTranslator;
import org.jetbrains.annotations.NotNull;

public class TypescriptKotlinIfTranslator extends TypescriptKotlinScriptTranslator<TypescriptIf> implements TypescriptIfTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptIf ast, @NotNull LanguageTranslator<?> source) {
        inheritIdent(source);
        translate(builder, ast);
    }

    @Override
    public void translate(StringBuilder builder, TypescriptIf ast) {
        builder.append("if(");
        postTranslate(TypescriptTranslateElement.STATEMENT, ast.predicate(), false);
        builder.append("){");
        translateLineWrap(this);

        pushIdent();
        for (TypescriptStatement statement : ast.statements()) {
            postTranslate(TypescriptTranslateElement.STATEMENT, statement);
            if (!statement.isEnding()) {
                translateEnding(this);
            }
        }
        popIdent();

        translateIdent();

        builder.append("}");

        if (!ast.elseStatements().isEmpty()) {
            builder.append("else{");
            translateLineWrap(this);

            pushIdent();
            for (TypescriptStatement statement : ast.elseStatements()) {
                postTranslate(TypescriptTranslateElement.STATEMENT, statement);
                if (!statement.isEnding()) {
                    translateEnding(this);
                }
            }
            popIdent();

            translateIdent();

            builder.append("}");
        }

        if (ast.elseIfStatement() != null) {
            postTranslate(TypescriptTranslateElement.IF, ast.elseIfStatement());
        }

        translateEnding(this);
    }
}
