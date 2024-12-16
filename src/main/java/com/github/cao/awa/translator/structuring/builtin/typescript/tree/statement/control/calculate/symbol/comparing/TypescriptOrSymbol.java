package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptOrSymbol extends TypescriptSymbol {
    public TypescriptOrSymbol(StructuringAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return "|";
    }

    @Override
    public String name() {
        return "or";
    }

    @Override
    public boolean notBinary() {
        return false;
    }

    @Override
    public int level() {
        return 0;
    }
}