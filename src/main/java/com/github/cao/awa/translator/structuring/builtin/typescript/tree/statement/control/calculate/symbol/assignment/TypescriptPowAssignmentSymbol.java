package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.assignment;

import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptOperators;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptPowAssignmentSymbol extends TypescriptSymbol {
    public TypescriptPowAssignmentSymbol(StructuringAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return "^=";
    }

    @Override
    public TypescriptSymbol operatorSymbol() {
        return TypescriptOperators.POW;
    }

    @Override
    public String name() {
        return "pow";
    }

    @Override
    public boolean isAssignment() {
        return true;
    }

    @Override
    public int level() {
        return 4;
    }
}
