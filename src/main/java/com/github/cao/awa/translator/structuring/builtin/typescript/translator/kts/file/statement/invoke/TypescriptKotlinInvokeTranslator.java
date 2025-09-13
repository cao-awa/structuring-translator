package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.invoke;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.invoke.TypescriptInvokeTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.object.callback.TypescriptCallbackFunction;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.TypescriptInvoke;

public class TypescriptKotlinInvokeTranslator extends TypescriptKotlinScriptTranslator<TypescriptInvoke> implements TypescriptInvokeTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptInvoke ast) {
        if (ast.fluent()) {
            builder.append(".");
        }

        postTranslate(TypescriptTranslateElement.INVOKE_OBJECT, ast.invokeTarget());
        builder.append("(");

        if (ast.params() != null) {
            if (ast.params().size() > 1) {
                translateLineWrap(this);

                pushIndent();
                postTranslate(TypescriptTranslateElement.INVOKE_PARAM_LIST, ast.params());

                translateLineWrap(this);

                translateIndent();

                popIndent();
            } else {
                postTranslate(TypescriptTranslateElement.INVOKE_PARAM_LIST, ast.params(), false);

                if (ast.params().size() > 0 && ast.params().params().getFirst().result() instanceof TypescriptCallbackFunction) {
                    translateLineWrap(this);
                }
            }
        }

        builder.append(")");

        if (ast.fluentAccessArray() != null) {
            builder.append("[");
            postTranslate(TypescriptTranslateElement.STATEMENT, ast.fluentAccessArray());
            builder.append("]");
        }

        for (TypescriptInvoke invoke : ast.fluentInvokes()) {
            postTranslate(TypescriptTranslateElement.INVOKE, invoke);
        }

        if (ast.isEnding()) {
            translateEnding(this);
        }
    }
}
