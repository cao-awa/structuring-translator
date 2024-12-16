package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.access;

import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public abstract class TypescriptInvokeAccess extends TypescriptStatement {
    public TypescriptInvokeAccess(StructuringAst parent) {
        super(parent);
    }
}
