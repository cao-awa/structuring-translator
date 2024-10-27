package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.invoke.param;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.invoke.param.TypescriptInvokeParamTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.param.TypescriptInvokeParam;

public class TypescriptKotlinInvokeParamTranslator extends TypescriptKotlinScriptTranslator<TypescriptInvokeParam> implements TypescriptInvokeParamTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptInvokeParam ast) {
        if (ast.reference() != null) {
            builder.append(ast.reference());
        } else if (ast.result() != null) {
            postTranslate(TypescriptTranslateElement.STATEMENT, ast.result());
        }
    }
}
