package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.invoke.access;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.invoke.TypescriptInvokeObjectTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.invoke.access.TypescriptInvokeAccessTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.TypescriptInvokeObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.access.TypescriptInvokeAccess;

public class TypescriptKotlinInvokeAccessTranslator extends TypescriptKotlinScriptTranslator<TypescriptInvokeAccess> implements TypescriptInvokeAccessTranslator<TypescriptInvokeAccess> {
    @Override
    public void translate(StringBuilder builder, TypescriptInvokeAccess ast) {
        translateAccess(this);
    }
}
