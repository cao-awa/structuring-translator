package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.not;

import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptNotSymbol extends TypescriptSymbol {
    public TypescriptNotSymbol(StructuringAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return "!";
    }

    @Override
    public String name() {
        return "isNot";
    }

    @Override
    public int level() {
        return 0;
    }
}
