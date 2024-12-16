package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.action;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.action.TypescriptSelfIncrementTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.action.TypescriptSelfIncrement;

public class TypescriptKotlinSelfIncrementTranslator extends TypescriptKotlinScriptTranslator<TypescriptSelfIncrement> implements TypescriptSelfIncrementTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptSelfIncrement ast) {
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
