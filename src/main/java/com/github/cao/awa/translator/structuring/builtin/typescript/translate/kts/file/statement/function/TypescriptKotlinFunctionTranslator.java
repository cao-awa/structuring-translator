package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.function;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.function.TypescriptFunctionTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.function.TypescriptFunction;

public class TypescriptKotlinFunctionTranslator extends TypescriptKotlinScriptTranslator<TypescriptFunction> implements TypescriptFunctionTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptFunction ast) {
        builder.append("fun ")
                .append(ast.name())
                .append("(");

        postTranslate(TypescriptTranslateElement.PARAM_LIST, ast.params());

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

        builder.append("}");

        translateEnding(this);
    }
}
