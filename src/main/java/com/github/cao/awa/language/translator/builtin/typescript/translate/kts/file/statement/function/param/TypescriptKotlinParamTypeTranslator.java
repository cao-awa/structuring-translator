package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.function.param;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.function.param.TypescriptParamTypeTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.function.TypescriptParamType;

public class TypescriptKotlinParamTypeTranslator extends TypescriptKotlinScriptTranslator<TypescriptParamType> implements TypescriptParamTypeTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptParamType ast) {
        builder.append(ast.name())
                .append(":");

        if (ast.type() != null) {
            postTranslate(TypescriptTranslateElement.ARG_TYPE, ast.type());
        } else {
            builder.append("Any");
        }
    }
}
