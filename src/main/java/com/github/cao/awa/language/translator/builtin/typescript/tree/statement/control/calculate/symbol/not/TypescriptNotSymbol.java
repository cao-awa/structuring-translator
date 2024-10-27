package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.not;

import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public class TypescriptNotSymbol extends TypescriptSymbol {
    public TypescriptNotSymbol(LanguageAst ast) {
        super(ast);
    }

    @Override
    public String symbol() {
        return "!";
    }

    @Override
    public String name() {
        return "isNot";
    }

    @Override
    public int level() {
        return 0;
    }
}
