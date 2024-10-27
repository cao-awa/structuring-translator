package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.function.param;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.function.param.TypescriptParamListTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.function.TypescriptParamList;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.function.TypescriptParamType;

import java.util.List;

public class TypescriptKotlinParamListTranslator extends TypescriptKotlinScriptTranslator<TypescriptParamList> implements TypescriptParamListTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptParamList ast) {
        for (TypescriptParamType arg : ast.args()) {
            postTranslate(TypescriptTranslateElement.PARAM_TYPE, arg);
        }
    }
}
