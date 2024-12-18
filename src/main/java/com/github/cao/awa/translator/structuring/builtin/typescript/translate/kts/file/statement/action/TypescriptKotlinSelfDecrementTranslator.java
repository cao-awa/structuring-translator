package com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.file.statement.action;

import com.github.cao.awa.translator.structuring.builtin.typescript.translate.base.file.statement.action.TypescriptSelfDecrementTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.translator.structuring.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.action.TypescriptSelfDecrement;

public class TypescriptKotlinSelfDecrementTranslator extends TypescriptKotlinScriptTranslator<TypescriptSelfDecrement> implements TypescriptSelfDecrementTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptSelfDecrement ast) {
        if (ast.isBefore()) {
            builder.append("--");
        }

        postTranslate(TypescriptTranslateElement.INVOKE_ACCESS, ast.access());

        if (!ast.isBefore()) {
            builder.append("--");
        }

        if (ast.isEnding()) {
            translateEnding(this);
        }
    }
}
