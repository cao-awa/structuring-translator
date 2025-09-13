package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.invoke.access;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.invoke.access.TypescriptInvokeAccessTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.access.TypescriptInvokeAccess;

public class TypescriptKotlinInvokeAccessTranslator extends TypescriptKotlinScriptTranslator<TypescriptInvokeAccess> implements TypescriptInvokeAccessTranslator<TypescriptInvokeAccess> {
    @Override
    public void translate(StringBuilder builder, TypescriptInvokeAccess ast) {
        translateAccess(this);
    }
}
