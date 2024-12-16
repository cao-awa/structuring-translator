package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic;

import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptMinusSymbol extends TypescriptSymbol {
    public TypescriptMinusSymbol(StructuringAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return "-";
    }

    @Override
    public String name() {
        return "minus";
    }

    @Override
    public String oppositeName() {
        return "minusBy";
    }

    @Override
    public int level() {
        return 2;
    }
}
