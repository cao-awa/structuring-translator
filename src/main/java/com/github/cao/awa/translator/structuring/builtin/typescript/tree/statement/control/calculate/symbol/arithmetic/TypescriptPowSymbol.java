package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic;

import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptPowSymbol extends TypescriptSymbol {
    public TypescriptPowSymbol(StructuringAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return "^";
    }

    @Override
    public String name() {
        return "pow";
    }

    @Override
    public String oppositeName() {
        return "powBy";
    }

    @Override
    public int level() {
        return 4;
    }
}
