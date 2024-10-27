package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public class TypescriptBreakingAndSymbol extends TypescriptSymbol {
    public TypescriptBreakingAndSymbol(LanguageAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return "&&";
    }

    @Override
    public String name() {
        return "breakingAnd";
    }

    @Override
    public boolean notBinary() {
        return false;
    }

    @Override
    public int level() {
        return 0;
    }
}