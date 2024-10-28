package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.comparing;

import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public class TypescriptStrictEqualsSymbol extends TypescriptSymbol {
    public TypescriptStrictEqualsSymbol(LanguageAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return "===";
    }

    @Override
    public String name() {
        return "isStrictEquals";
    }

    @Override
    public boolean leftPrimary() {
        return true;
    }

    @Override
    public int level() {
        return 0;
    }
}
