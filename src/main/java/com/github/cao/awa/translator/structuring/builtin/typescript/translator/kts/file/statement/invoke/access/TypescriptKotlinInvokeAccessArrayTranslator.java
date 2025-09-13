package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.invoke.access;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.invoke.access.TypescriptInvokeAccessArrayTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.access.TypescriptInvokeAccessArray;

public class TypescriptKotlinInvokeAccessArrayTranslator extends TypescriptKotlinScriptTranslator<TypescriptInvokeAccessArray> implements TypescriptInvokeAccessArrayTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptInvokeAccessArray ast) {
        postTranslate(TypescriptTranslateElement.INVOKE_ACCESS_ELEMENT, ast.target());

        builder.append("[");
        postTranslate(TypescriptTranslateElement.STATEMENT, ast.accessParam());
        builder.append("]");
    }
}
