package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.function.param;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.function.param.TypescriptParamListTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.function.TypescriptParamList;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.function.TypescriptParamType;

public class TypescriptKotlinParamListTranslator extends TypescriptKotlinScriptTranslator<TypescriptParamList> implements TypescriptParamListTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptParamList ast) {
        for (TypescriptParamType arg : ast.args()) {
            postTranslate(TypescriptTranslateElement.PARAM_TYPE, arg);
        }
    }
}
