package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.constant.undefined;

import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.constant.TypescriptConstant;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptUndefined extends TypescriptConstant<Object> {
    public TypescriptUndefined(StructuringAst parent) {
        super(parent);
    }

    @Override
    public String literal() {
        return "undefined";
    }

    @Override
    public Boolean constantValue() {
        return null;
    }
}
