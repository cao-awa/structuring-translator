package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic;

import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public class TypescriptMinusSymbol extends TypescriptSymbol {
    public TypescriptMinusSymbol(LanguageAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return "-";
    }

    @Override
    public String name() {
        return "minus";
    }

    @Override
    public String oppositeName() {
        return "minusBy";
    }

    @Override
    public int level() {
        return 2;
    }
}
