package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.vararg;

import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public abstract class TypescriptAstWithVarargs extends StructuringAst {
    private TypescriptArgType argType;

    public TypescriptAstWithVarargs(StructuringAst parent) {
        super(parent);
    }
}
