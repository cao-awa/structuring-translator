package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.action;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.action.TypescriptSelfIncrementTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
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
