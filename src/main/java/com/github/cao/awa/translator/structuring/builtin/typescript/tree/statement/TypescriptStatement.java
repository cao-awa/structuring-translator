package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement;

import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public abstract class TypescriptStatement extends StructuringAst {
    private boolean isEnding = false;

    public TypescriptStatement isEnding(boolean isEnding) {
        this.isEnding = isEnding;
        return this;
    }

    public boolean isEnding() {
        return this.isEnding;
    }

    public TypescriptStatement(StructuringAst parent) {
        super(parent);
    }
}
