package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public class TypescriptLessThanSymbol extends TypescriptSymbol {
    public TypescriptLessThanSymbol(LanguageAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return "<";
    }

    @Override
    public String name() {
        return "isLessThan";
    }

    @Override
    public String oppositeName() {
        return "isMoreThan";
    }

    @Override
    public boolean leftPrimary() {
        return true;
    }

    @Override
    public int level() {
        return 1;
    }
}
