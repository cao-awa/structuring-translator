package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.instance;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.invoke.param.TypescriptInvokeParamList;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.vararg.TypescriptArgType;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptNewInstanceStatement extends TypescriptResultStatement {
    private TypescriptArgType type;
    private TypescriptInvokeParamList paramList;

    public TypescriptInvokeParamList paramList() {
        return this.paramList;
    }

    public TypescriptNewInstanceStatement paramList(TypescriptInvokeParamList paramList) {
        this.paramList = paramList;
        return this;
    }

    public TypescriptArgType type() {
        return this.type;
    }

    public TypescriptNewInstanceStatement type(TypescriptArgType type) {
        this.type = type;
        return this;
    }

    public TypescriptNewInstanceStatement(StructuringAst parent) {
        super(parent);
    }

    @Override
    public void generateStructure(JSONObject json) {
        json.put("statement_type", "new_instance");

        JSONObject theType = new JSONObject();
        this.type.generateStructure(theType);
        json.put("type", theType);

        if (this.paramList != null) {
            JSONObject theParams = new JSONObject();
            this.paramList.generateStructure(theParams);
            json.put("params", theParams);
        }
    }

    @Override
    public void preprocess() {
        this.type.preprocess();
        this.paramList.preprocess();
    }

    @Override
    public void postprocess() {
        this.type.postprocess();
        this.paramList.postprocess();
    }

    @Override
    public void consequence() {
        this.type.consequence();
        this.paramList.consequence();
    }
}
