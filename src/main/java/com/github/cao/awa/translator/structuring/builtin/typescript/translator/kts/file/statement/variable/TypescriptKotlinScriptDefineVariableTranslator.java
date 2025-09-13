package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.variable;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.variable.TypescriptDefineVariableTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.variable.TypescriptDefineVariable;

public class TypescriptKotlinScriptDefineVariableTranslator extends TypescriptKotlinScriptTranslator<TypescriptDefineVariable> implements TypescriptDefineVariableTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptDefineVariable ast) {
        if (ast.isDefine()) {
            if (ast.isFinal()) {
                builder.append("val ");
            } else {
                builder.append("var ");
            }
        }
        builder.append(ast.name());

//        if (ast.type() != null) {
//            builder.append(":");
//            postTranslate(TypescriptTranslateElement.ARG_TYPE, ast.type());
//        }

        if (ast.assignment() != null) {
            builder.append("=");
            postTranslate(TypescriptTranslateElement.STATEMENT, ast.assignment());
        } else {
            builder.append(":Any?=null");
        }

        translateEnding(this);
    }
}
