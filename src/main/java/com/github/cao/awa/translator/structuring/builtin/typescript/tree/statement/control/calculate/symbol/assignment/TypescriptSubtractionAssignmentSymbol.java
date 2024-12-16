package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.assignment;

import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptOperators;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptSubtractionAssignmentSymbol extends TypescriptSymbol {
    public TypescriptSubtractionAssignmentSymbol(StructuringAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return "-=";
    }

    @Override
    public TypescriptSymbol operatorSymbol() {
        return TypescriptOperators.MINUS;
    }

    @Override
    public String name() {
        return "minus";
    }

    @Override
    public boolean isAssigment() {
        return true;
    }

    @Override
    public int level() {
        return 2;
    }
}
