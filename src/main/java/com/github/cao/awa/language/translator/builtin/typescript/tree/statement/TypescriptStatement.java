package com.github.cao.awa.language.translator.builtin.typescript.tree.statement;

import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public abstract class TypescriptStatement extends LanguageAst {
    private boolean isEnding = true;

    public TypescriptStatement isEnding(boolean isEnding) {
        this.isEnding = isEnding;
        return this;
    }

    public boolean isEnding() {
        return this.isEnding;
    }

    public TypescriptStatement(LanguageAst parent) {
        super(parent);
    }
}
