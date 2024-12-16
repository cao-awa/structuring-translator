package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result;

import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public abstract class TypescriptResultStatement extends TypescriptStatement {
    public TypescriptResultStatement(StructuringAst parent) {
        super(parent);
    }
}
