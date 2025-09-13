package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.function.param;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.function.param.TypescriptParamTypeTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.function.TypescriptParamType;

public class TypescriptKotlinParamTypeTranslator extends TypescriptKotlinScriptTranslator<TypescriptParamType> implements TypescriptParamTypeTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptParamType ast) {
        builder.append(ast.name());

        if (ast.type() != null) {
            builder.append(":");
            postTranslate(TypescriptTranslateElement.ARG_TYPE, ast.type());
        } else {
            if (ast.isTypeRequired()) {
                builder.append(":Any");
            }
        }
    }
}
