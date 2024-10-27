package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.action;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.action.TypescriptSelfDecrementTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.action.TypescriptSelfDecrement;

public class TypescriptKotlinSelfIncrementTranslator extends TypescriptKotlinScriptTranslator<TypescriptSelfDecrement> implements TypescriptSelfDecrementTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptSelfDecrement ast) {
        if (ast.isBefore()) {
            builder.append("++");
        }

        postTranslate(TypescriptTranslateElement.INVOKE_ACCESS, ast.access());

        if (!ast.isBefore()) {
            builder.append("++");
        }

        if (ast.isEnding()) {
            translateEnding(this);
        }
    }
}
