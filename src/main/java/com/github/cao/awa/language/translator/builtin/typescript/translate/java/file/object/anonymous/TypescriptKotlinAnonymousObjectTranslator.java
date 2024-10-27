package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.object.anonymous;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.object.anonymous.TypescriptAnonymousObjectTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.function.param.TypescriptParamListTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.object.anonymous.TypescriptAnonymousObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.function.TypescriptParamList;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.function.TypescriptParamType;

import java.util.List;

public class TypescriptKotlinAnonymousObjectTranslator extends TypescriptKotlinScriptTranslator<TypescriptAnonymousObject> implements TypescriptAnonymousObjectTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptAnonymousObject ast) {
        builder.append("/* NOT IMPLIED: anonymous object\n");
        ast.params().values().forEach((key, value) -> {
            builder.append(key).append(":");
            postTranslate(TypescriptTranslateElement.STATEMENT, value);
            builder.append(",\n");
        });
        builder.append("*/ \n");
    }
}
