package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.invoke.param;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.invoke.param.TypescriptInvokeParamListTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.param.TypescriptInvokeParam;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.param.TypescriptInvokeParamList;

import java.util.List;

public class TypescriptKotlinInvokeParamListTranslator extends TypescriptKotlinScriptTranslator<TypescriptInvokeParamList> implements TypescriptInvokeParamListTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptInvokeParamList ast) {
        for (TypescriptInvokeParam arg : ast.params()) {
            postTranslate(TypescriptTranslateElement.INVOKE_PARAM, arg);
            builder.append(",");
        }
    }
}
