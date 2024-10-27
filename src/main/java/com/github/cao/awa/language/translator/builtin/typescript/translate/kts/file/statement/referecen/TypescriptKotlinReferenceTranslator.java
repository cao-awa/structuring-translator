package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.referecen;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.referecen.TypescriptReferenceTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.ref.TypescriptReference;

public class TypescriptKotlinReferenceTranslator extends TypescriptKotlinScriptTranslator<TypescriptReference> implements TypescriptReferenceTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptReference ast) {
        builder.append(ast.name());
    }
}
