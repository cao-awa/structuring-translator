package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.param;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

import java.util.LinkedList;
import java.util.List;

public class TypescriptInvokeParamList extends TypescriptStatement {
    private final List<TypescriptInvokeParam> params = new LinkedList<>();

    public TypescriptInvokeParamList addParam(TypescriptInvokeParam invokeTarget) {
        this.params.add(invokeTarget);
        return this;
    }

    public List<TypescriptInvokeParam> params() {
        return this.params;
    }

    public int size() {
        return this.params.size();
    }

    public TypescriptInvokeParamList(StructuringAst parent) {
        super(parent);
    }

    @Override
    public void generateStructure(JSONObject json) {

    }

    @Override
    public void preprocess() {
        this.params.forEach(StructuringAst::preprocess);
    }

    @Override
    public void postprocess() {
        this.params.forEach(StructuringAst::postprocess);
    }

    @Override
    public void consequence() {
        this.params.forEach(StructuringAst::consequence);
    }
}
