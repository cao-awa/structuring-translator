package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.object.callback;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.object.callback.TypescriptCallbackFunctionTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.object.callback.TypescriptCallbackFunction;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;

public class TypescriptKotlinCallbackFunctionTranslator extends TypescriptKotlinScriptTranslator<TypescriptCallbackFunction> implements TypescriptCallbackFunctionTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptCallbackFunction ast) {
        builder.append("{\n");

        if (ast.params() != null && !ast.params().args().isEmpty()) {
            postTranslate(TypescriptTranslateElement.PARAM_LIST, ast.params());
            builder.append("->\n");
        }

        for (TypescriptStatement statement : ast.statements()) {
            postTranslate(TypescriptTranslateElement.STATEMENT, statement);
        }

        builder.append("\n}");
    }
}
