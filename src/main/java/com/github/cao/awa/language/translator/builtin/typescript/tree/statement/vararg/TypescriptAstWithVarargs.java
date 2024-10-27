package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.vararg;

import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public abstract class TypescriptAstWithVarargs extends LanguageAst {
    private TypescriptArgType argType;

    public TypescriptAstWithVarargs(LanguageAst parent) {
        super(parent);
    }
}
