package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.access;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public abstract class TypescriptInvokeAccess extends TypescriptStatement {
    public TypescriptInvokeAccess(LanguageAst parent) {
        super(parent);
    }
}
