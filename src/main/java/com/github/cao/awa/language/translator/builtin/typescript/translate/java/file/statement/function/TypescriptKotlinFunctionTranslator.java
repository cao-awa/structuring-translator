package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.function;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.function.TypescriptFunctionTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.importing.TypescriptImportingTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.function.TypescriptFunction;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.importing.TypescriptImportStatement;

public class TypescriptKotlinFunctionTranslator extends TypescriptKotlinScriptTranslator<TypescriptFunction> implements TypescriptFunctionTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptFunction ast) {
        builder.append("fun ")
                .append(ast.name())
                .append("(");

        postTranslate(TypescriptTranslateElement.PARAM_LIST, ast.params());

        builder.append("){\n");
        for (TypescriptStatement statement : ast.statements()) {
            postTranslate(TypescriptTranslateElement.STATEMENT, statement);
        }
        builder.append("}\n");
    }
}
