package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.assignment;

import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptOperators;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public class TypescriptSubtractionAssignmentSymbol extends TypescriptSymbol {
    public TypescriptSubtractionAssignmentSymbol(LanguageAst ast) {
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
