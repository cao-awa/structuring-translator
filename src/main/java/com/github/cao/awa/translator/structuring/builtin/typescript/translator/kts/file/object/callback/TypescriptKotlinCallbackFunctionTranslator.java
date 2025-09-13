package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.object.callback;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.object.callback.TypescriptCallbackFunctionTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.object.callback.TypescriptCallbackFunction;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.translate.StructuringTranslator;
import org.jetbrains.annotations.NotNull;

public class TypescriptKotlinCallbackFunctionTranslator extends TypescriptKotlinScriptTranslator<TypescriptCallbackFunction> implements TypescriptCallbackFunctionTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptCallbackFunction ast, @NotNull StructuringTranslator<?> source) {
        inheritIndent(source);
        translate(builder, ast);
    }

    @Override
    public void translate(StringBuilder builder, TypescriptCallbackFunction ast) {
        translateIndent();
        builder.append("{");

        if (ast.params() != null && !ast.params().args().isEmpty()) {
            postTranslate(TypescriptTranslateElement.PARAM_LIST, ast.params());
            builder.append("->");
        }
        builder.append("\n");

        pushIndent();
        for (TypescriptStatement statement : ast.statements()) {
            pushIndent();
            postTranslate(TypescriptTranslateElement.STATEMENT, statement);
            if (!statement.isEnding()) {
                translateEnding(this);
            }
            popIndent();
        }

        translateIndent();
        popIndent();

        builder.append("}");
    }
}
