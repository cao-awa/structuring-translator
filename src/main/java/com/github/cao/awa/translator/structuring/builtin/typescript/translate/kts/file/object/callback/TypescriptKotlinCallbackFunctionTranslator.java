package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.object.callback;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.object.callback.TypescriptCallbackFunctionTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.object.callback.TypescriptCallbackFunction;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.translate.StructuringTranslator;
import org.jetbrains.annotations.NotNull;

public class TypescriptKotlinCallbackFunctionTranslator extends TypescriptKotlinScriptTranslator<TypescriptCallbackFunction> implements TypescriptCallbackFunctionTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptCallbackFunction ast, @NotNull StructuringTranslator<?> source) {
        inheritIdent(source);
        translate(builder, ast);
    }

    @Override
    public void translate(StringBuilder builder, TypescriptCallbackFunction ast) {
        translateIdent();
        builder.append("{");

        if (ast.params() != null && !ast.params().args().isEmpty()) {
            postTranslate(TypescriptTranslateElement.PARAM_LIST, ast.params());
            builder.append("->");
        }
        builder.append("\n");

        pushIdent();
        for (TypescriptStatement statement : ast.statements()) {
            pushIdent();
            postTranslate(TypescriptTranslateElement.STATEMENT, statement);
            if (!statement.isEnding()) {
                translateEnding(this);
            }
            popIdent();
        }

        translateIdent();
        popIdent();

        builder.append("}");
    }
}
