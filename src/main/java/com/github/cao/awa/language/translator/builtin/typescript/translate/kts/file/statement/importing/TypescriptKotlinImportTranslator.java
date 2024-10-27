package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.importing;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.importing.TypescriptImportingTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.importing.TypescriptImportStatement;

public class TypescriptKotlinImportTranslator extends TypescriptKotlinScriptTranslator<TypescriptImportStatement> implements TypescriptImportingTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptImportStatement ast) {
        builder.append("// Typescript import: ")
                .append(ast.imports())
                .append(" from ")
                .append(ast.from())
                .append("\n");
    }
}
