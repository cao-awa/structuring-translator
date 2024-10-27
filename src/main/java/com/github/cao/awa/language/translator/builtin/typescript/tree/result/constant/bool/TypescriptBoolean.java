package com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.bool;

import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.TypescriptConstant;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public class TypescriptBoolean extends TypescriptConstant<Boolean> {
    private boolean value;

    public TypescriptBoolean(LanguageAst parent) {
        super(parent);
    }

    public void value(boolean value) {
        this.value = value;
    }

    @Override
    public String literal() {
        return this.value ? "true" : "false";
    }

    @Override
    public Boolean constantValue() {
        return this.value;
    }
}
