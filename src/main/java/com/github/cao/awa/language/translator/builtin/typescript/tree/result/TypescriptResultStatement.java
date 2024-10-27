package com.github.cao.awa.language.translator.builtin.typescript.tree.result;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public abstract class TypescriptResultStatement extends TypescriptStatement {
    private boolean isEnding = true;

    public TypescriptResultStatement isEnding(boolean isEnding) {
        this.isEnding = isEnding;
        return this;
    }

    public boolean isEnding() {
        return this.isEnding;
    }

    public TypescriptResultStatement(LanguageAst parent) {
        super(parent);
    }
}
