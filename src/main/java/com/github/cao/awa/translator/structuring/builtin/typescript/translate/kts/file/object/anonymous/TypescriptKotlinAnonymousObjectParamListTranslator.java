package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.object.anonymous;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.object.anonymous.TypescriptAnonymousObjectParamListTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.object.anonymous.TypescriptAnonymousObjectParamList;

public class TypescriptKotlinAnonymousObjectParamListTranslator extends TypescriptKotlinScriptTranslator<TypescriptAnonymousObjectParamList> implements TypescriptAnonymousObjectParamListTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptAnonymousObjectParamList ast) {
        ast.values().forEach((key, value) -> {
            builder.append(key).append(":");

            postTranslate(TypescriptTranslateElement.STATEMENT, value);
        });
    }
}
