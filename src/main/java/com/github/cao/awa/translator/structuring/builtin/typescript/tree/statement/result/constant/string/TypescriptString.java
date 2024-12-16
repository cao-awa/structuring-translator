package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.constant.string;

import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.constant.TypescriptConstant;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptString extends TypescriptConstant<String> {
    private String value;

    public TypescriptString(StructuringAst parent) {
        super(parent);
    }

    public void value(String value) {
        this.value = value;
    }

    @Override
    public String literal() {
        return this.value;
    }

    @Override
    public String constantValue() {
        return this.value;
    }
}
