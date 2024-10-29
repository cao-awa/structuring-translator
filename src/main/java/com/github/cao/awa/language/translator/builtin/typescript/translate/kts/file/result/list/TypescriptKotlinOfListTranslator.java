package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.result.list;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.result.list.TypescriptOfListTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.result.referecen.TypescriptReferenceTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.TypescriptResultStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.list.TypescriptOfList;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.ref.TypescriptReference;

public class TypescriptKotlinOfListTranslator extends TypescriptKotlinScriptTranslator<TypescriptOfList> implements TypescriptOfListTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptOfList ast) {
        builder.append("mutableListOf(");
        for (TypescriptResultStatement element : ast.elements()) {
            postTranslate(TypescriptTranslateElement.STATEMENT, element);
            builder.append(",");
        }
        builder.append(")");
    }
}
