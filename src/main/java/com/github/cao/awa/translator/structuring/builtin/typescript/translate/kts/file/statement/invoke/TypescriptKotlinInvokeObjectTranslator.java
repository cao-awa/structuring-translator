package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.invoke;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.invoke.TypescriptInvokeObjectTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.TypescriptInvokeObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.access.TypescriptInvokeAccess;

public class TypescriptKotlinInvokeObjectTranslator extends TypescriptKotlinScriptTranslator<TypescriptInvokeObject> implements TypescriptInvokeObjectTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptInvokeObject ast) {
        for (TypescriptInvokeAccess access : ast.accesses()) {
            postTranslate(TypescriptTranslateElement.INVOKE_ACCESS, access);
        }
    }
}
