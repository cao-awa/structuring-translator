package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptBreakingAndSymbol extends TypescriptSymbol {
    public TypescriptBreakingAndSymbol(StructuringAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return "&&";
    }

    @Override
    public String name() {
        return "breakingAnd";
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