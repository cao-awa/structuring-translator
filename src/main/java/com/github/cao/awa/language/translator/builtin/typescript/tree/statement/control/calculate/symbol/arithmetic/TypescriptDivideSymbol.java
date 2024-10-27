package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic;

import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public class TypescriptDivideSymbol extends TypescriptSymbol {
    public TypescriptDivideSymbol(LanguageAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return "/";
    }

    @Override
    public String name() {
        return "divide";
    }

    @Override
    public String oppositeName() {
        return "divideBy";
    }

    @Override
    public int level() {
        return 3;
    }
}
