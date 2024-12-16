package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result;

import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public abstract class TypescriptResultStatement extends TypescriptStatement {
    public TypescriptResultStatement(LanguageAst parent) {
        super(parent);
    }
}
