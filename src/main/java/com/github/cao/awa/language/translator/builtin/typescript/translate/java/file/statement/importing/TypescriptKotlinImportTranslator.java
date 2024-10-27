package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.importing;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.TypescriptStatementElementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.importing.TypescriptImportingTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.importing.TypescriptImportStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.vararg.TypescriptArgType;

import java.math.BigDecimal;
import java.util.LinkedList;

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
