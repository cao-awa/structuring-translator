package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.referecen;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.invoke.param.TypescriptInvokeParamTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.referecen.TypescriptReferenceTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.ref.TypescriptReference;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.param.TypescriptInvokeParam;

public class TypescriptKotlinReferenceTranslator extends TypescriptKotlinScriptTranslator<TypescriptReference> implements TypescriptReferenceTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptReference ast) {
        builder.append(ast.name());
    }
}
