package com.github.cao.awa.language.translator.builtin.typescript.translate.java.file.statement.action;

import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.action.TypescriptSelfActionTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.base.file.statement.function.TypescriptFunctionTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.java.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.action.TypescriptSelfAction;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.function.TypescriptFunction;

public class TypescriptKotlinSelfActionTranslator extends TypescriptKotlinScriptTranslator<TypescriptSelfAction> implements TypescriptSelfActionTranslator {
    @Override
    public void translate(StringBuilder builder, TypescriptSelfAction ast) {
        translateStatement(this);
    }
}
