package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.function;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.vararg.TypescriptArgType;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptParamType extends TypescriptStatement {
    private TypescriptArgType type;
    private String name;
    private boolean typeRequired = true;

    public TypescriptArgType type() {
        return this.type;
    }

    public TypescriptParamType type(TypescriptArgType type) {
        this.type = type;
        return this;
    }

    public String name() {
        return name;
    }

    public TypescriptParamType name(String name) {
        this.name = name;
        return this;
    }

    public boolean isTypeRequired() {
        return this.typeRequired;
    }

    public TypescriptParamType typeRequired(boolean typeRequired) {
        this.typeRequired = typeRequired;
        return this;
    }

    public TypescriptParamType(StructuringAst parent) {
        super(parent);
    }

    @Override
    public void generateStructure(JSONObject json) {
        json.put("name", this.name);

        if (this.type != null) {
            JSONObject theType = new JSONObject();
            this.type.generateStructure(theType);
            json.put("type", theType);
        }
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
