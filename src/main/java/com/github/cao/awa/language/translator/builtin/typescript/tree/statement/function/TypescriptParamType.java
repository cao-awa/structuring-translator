package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.function;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.vararg.TypescriptArgType;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public class TypescriptParamType extends TypescriptStatement {
    private TypescriptArgType type;
    private String name;

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

    public TypescriptParamType(LanguageAst parent) {
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
