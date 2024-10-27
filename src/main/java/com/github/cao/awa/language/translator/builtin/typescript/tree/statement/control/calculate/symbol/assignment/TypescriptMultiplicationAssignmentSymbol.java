package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.assignment;

import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.ApsOperators;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public class TypescriptMultiplicationAssignmentSymbol extends TypescriptSymbol {
    public TypescriptMultiplicationAssignmentSymbol(LanguageAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return "*=";
    }

    @Override
    public TypescriptSymbol operatorSymbol() {
        return ApsOperators.MULTIPLY;
    }

    @Override
    public String name() {
        return "multiply";
    }

    @Override
    public boolean isAssigment() {
        return true;
    }

    @Override
    public int level() {
        return 3;
    }
}
