package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.ref;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptReference extends TypescriptResultStatement {
    private String name;

    public TypescriptReference(StructuringAst parent) {
        super(parent);
    }

    @Override
    public void generateStructure(JSONObject json) {
        json.put("statement_type", "reference");
        json.put("reference", this.name);
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

    public String name() {
        return this.name;
    }

    public TypescriptReference name(String name) {
        this.name = name;
        return this;
    }
}
