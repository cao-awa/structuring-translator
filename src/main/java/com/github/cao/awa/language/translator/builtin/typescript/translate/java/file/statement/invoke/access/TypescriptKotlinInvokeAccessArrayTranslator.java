package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.invoke.access;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.invoke.access.TypescriptInvokeAccessArrayTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.access.TypescriptInvokeAccessArray;

public class TypescriptKotlinInvokeAccessArrayTranslator extends TypescriptKotlinScriptTranslator<TypescriptInvokeAccessArray> implements TypescriptInvokeAccessArrayTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptInvokeAccessArray ast) {
        postTranslate(TypescriptTranslateElement.INVOKE_ACCESS_ELEMENT, ast.target());

        builder.append("[");
        postTranslate(TypescriptTranslateElement.STATEMENT, ast.accessParam());
        builder.append("]");
    }
}
