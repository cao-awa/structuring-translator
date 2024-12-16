package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.invoke.access;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.invoke.access.TypescriptInvokeAccessElementTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.access.TypescriptInvokeAccessElement;

public class TypescriptKotlinInvokeAccessElementTranslator extends TypescriptKotlinScriptTranslator<TypescriptInvokeAccessElement> implements TypescriptInvokeAccessElementTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptInvokeAccessElement ast) {
        builder.append(ast.target());
    }
}
