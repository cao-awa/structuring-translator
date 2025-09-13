package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.importing;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.importing.TypescriptImportingTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.importing.TypescriptImportStatement;

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
