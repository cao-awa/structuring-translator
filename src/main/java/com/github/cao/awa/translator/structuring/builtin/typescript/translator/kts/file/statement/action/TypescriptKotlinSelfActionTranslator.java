package com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.file.statement.action;

import com.github.cao.awa.translator.structuring.builtin.typescript.translator.element.file.statement.action.TypescriptSelfActionTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.translator.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.action.TypescriptSelfAction;

public class TypescriptKotlinSelfActionTranslator extends TypescriptKotlinScriptTranslator<TypescriptSelfAction> implements TypescriptSelfActionTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptSelfAction ast) {
        translateStatement(this);
    }
}
