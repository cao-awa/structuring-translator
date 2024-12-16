package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.constant.bool;

import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.constant.TypescriptConstant;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptBoolean extends TypescriptConstant<Boolean> {
    private boolean value;

    public TypescriptBoolean(StructuringAst parent) {
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
