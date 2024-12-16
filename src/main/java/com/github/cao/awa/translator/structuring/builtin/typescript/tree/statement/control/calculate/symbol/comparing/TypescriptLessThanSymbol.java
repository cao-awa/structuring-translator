package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptLessThanSymbol extends TypescriptSymbol {
    public TypescriptLessThanSymbol(StructuringAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return "<";
    }

    @Override
    public String name() {
        return "isLessThan";
    }

    @Override
    public String oppositeName() {
        return "isMoreThan";
    }

    @Override
    public boolean leftPrimary() {
        return true;
    }

    @Override
    public int level() {
        return 1;
    }
}
