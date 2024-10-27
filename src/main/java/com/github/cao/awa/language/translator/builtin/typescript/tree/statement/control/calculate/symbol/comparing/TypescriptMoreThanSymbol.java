package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public class TypescriptMoreThanSymbol extends TypescriptSymbol {
    public TypescriptMoreThanSymbol(LanguageAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return ">";
    }

    @Override
    public String name() {
        return "isMoreThan";
    }

    @Override
    public String oppositeName() {
        return "isLessThan";
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
