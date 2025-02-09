package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.access;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptInvokeAccessElement extends TypescriptInvokeAccess {
    private String target;

    public TypescriptInvokeAccessElement target(String target) {
        this.target = target;
        return this;
    }

    public String target() {
        return this.target;
    }

    public TypescriptInvokeAccessElement(StructuringAst parent) {
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
