package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.variable;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.variable.TypescriptDefineVariableTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.variable.TypescriptDefineVariable;

public class TypescriptKotlinScriptDefineVariableTranslator extends TypescriptKotlinScriptTranslator<TypescriptDefineVariable> implements TypescriptDefineVariableTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptDefineVariable ast) {
        if (ast.isFinal()) {
            builder.append("val ");
        } else {
            builder.append("var ");
        }
        builder.append(ast.name());

//        if (ast.type() != null) {
//            builder.append(":");
//            postTranslate(TypescriptTranslateElement.ARG_TYPE, ast.type());
//        }

        if (ast.assigment() != null) {
            builder.append("=");
            postTranslate(TypescriptTranslateElement.STATEMENT, ast.assigment());
        } else {
            builder.append(":Any?=null");
        }

        translateEnding(this);
    }
}
