package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.result.referecen;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.result.referecen.TypescriptReferenceTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.ref.TypescriptReference;
import com.github.cao.awa.translator.structuring.translate.StructuringTranslator;
import org.jetbrains.annotations.NotNull;

public class TypescriptKotlinReferenceTranslator extends TypescriptKotlinScriptTranslator<TypescriptReference> implements TypescriptReferenceTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptReference ast, @NotNull StructuringTranslator<?> source) {
        inheritIndent(source);
        translateIndent();
        translate(builder, ast);
    }

    @Override
    public void translate(StringBuilder builder, TypescriptReference ast) {
        builder.append(ast.name());
    }
}
