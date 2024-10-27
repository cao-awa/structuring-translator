package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.object.anonymous;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.object.anonymous.TypescriptAnonymousObjectParamListTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.function.param.TypescriptParamListTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.object.anonymous.TypescriptAnonymousObjectParamList;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.function.TypescriptParamList;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.function.TypescriptParamType;

import java.util.List;

public class TypescriptKotlinAnonymousObjectParamListTranslator extends TypescriptKotlinScriptTranslator<TypescriptAnonymousObjectParamList> implements TypescriptAnonymousObjectParamListTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptAnonymousObjectParamList ast) {
        ast.values().forEach((key, value) -> {
            builder.append(key).append(":");

            postTranslate(TypescriptTranslateElement.STATEMENT, value);
        });
    }
}
