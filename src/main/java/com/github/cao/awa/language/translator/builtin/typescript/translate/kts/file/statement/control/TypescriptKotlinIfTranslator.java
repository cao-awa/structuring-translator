package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.control;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.control.TypescriptIfTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.TypescriptIf;

public class TypescriptKotlinIfTranslator extends TypescriptKotlinScriptTranslator<TypescriptIf> implements TypescriptIfTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptIf ast) {
        builder.append("if(");
        postTranslate(TypescriptTranslateElement.STATEMENT, ast.predicate());
        builder.append("){\n");
        for (TypescriptStatement statement : ast.statements()) {
            postTranslate(TypescriptTranslateElement.STATEMENT, statement);
        }
        builder.append("}");

        if (!ast.elseStatements().isEmpty()) {
            builder.append("else{\n");
            for (TypescriptStatement statement : ast.elseStatements()) {
                postTranslate(TypescriptTranslateElement.STATEMENT, statement);
            }
            builder.append("}");
        }

        if (ast.elseIfStatement() != null) {
            postTranslate(TypescriptTranslateElement.IF, ast.elseIfStatement());
        }
    }
}
