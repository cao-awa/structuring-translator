package com.github.cao.awa.language.translator.builtin.typescript.translate.kts.file.statement.action;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.action.TypescriptSelfActionTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.action.TypescriptSelfAction;

public class TypescriptKotlinSelfActionTranslator extends TypescriptKotlinScriptTranslator<TypescriptSelfAction> implements TypescriptSelfActionTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptSelfAction ast) {
        translateStatement(this);
    }
}
