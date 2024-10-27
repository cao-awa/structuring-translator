package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.object.anonymous;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.object.anonymous.TypescriptAnonymousObjectTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.object.anonymous.TypescriptAnonymousObject;

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
