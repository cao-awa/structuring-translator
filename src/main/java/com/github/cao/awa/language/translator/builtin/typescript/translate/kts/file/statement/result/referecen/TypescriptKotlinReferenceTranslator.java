package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.result.referecen;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.result.referecen.TypescriptReferenceTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result.ref.TypescriptReference;
import com.github.cao.awa.language.translator.translate.LanguageTranslator;
import org.jetbrains.annotations.NotNull;

public class TypescriptKotlinReferenceTranslator extends TypescriptKotlinScriptTranslator<TypescriptReference> implements TypescriptReferenceTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptReference ast, @NotNull LanguageTranslator<?> source) {
        inheritIdent(source);
        translateIdent();
        translate(builder, ast);
    }

    @Override
    public void translate(StringBuilder builder, TypescriptReference ast) {
        builder.append(ast.name());
    }
}
