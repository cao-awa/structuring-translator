package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic;

import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptMultiplySymbol extends TypescriptSymbol {
    public TypescriptMultiplySymbol(StructuringAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return "*";
    }

    @Override
    public String name() {
        return "multiply";
    }

    @Override
    public int level() {
        return 3;
    }
}
