package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.access.TypescriptInvokeAccess;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.List;

public class TypescriptInvokeObject extends TypescriptResultStatement {
    private final List<TypescriptInvokeAccess> accesses = CollectionFactor.linkedList();

    public TypescriptInvokeObject addAccess(TypescriptInvokeAccess access) {
        this.accesses.add(access);
        return this;
    }

    public List<TypescriptInvokeAccess> accesses() {
        return this.accesses;
    }

    public TypescriptInvokeObject(LanguageAst parent) {
        super(parent);
    }

    @Override
    public void generateStructure(JSONObject json) {

    }

    @Override
    public void preprocess() {

    }

    @Override
    public void postprocess() {

    }

    @Override
    public void consequence() {

    }
}
