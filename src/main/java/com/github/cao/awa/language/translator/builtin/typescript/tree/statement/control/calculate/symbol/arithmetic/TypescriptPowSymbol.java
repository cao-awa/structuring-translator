package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic;

import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public class TypescriptPowSymbol extends TypescriptSymbol {
    public TypescriptPowSymbol(LanguageAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return "^";
    }

    @Override
    public String name() {
        return "pow";
    }

    @Override
    public String oppositeName() {
        return "powBy";
    }

    @Override
    public int level() {
        return 4;
    }
}
