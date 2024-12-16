package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.function;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.List;

public class TypescriptFunction extends TypescriptStatement {
    private final List<TypescriptStatement> statements = CollectionFactor.linkedList();
    private TypescriptParamList params;
    private String name;

    public TypescriptFunction name(String name) {
        this.name = name;
        return this;
    }

    public String name() {
        return this.name;
    }

    public void addStatement(TypescriptStatement statement) {
        this.statements.add(statement);
    }

    public List<TypescriptStatement> statements() {
        return this.statements;
    }

    public void params(TypescriptParamList params) {
        this.params = params;
    }

    public TypescriptParamList params() {
        return this.params;
    }

    public TypescriptFunction(StructuringAst parent) {
        super(parent);
    }

    @Override
    public void generateStructure(JSONObject json) {
        json.put("name", this.name);
        if (this.params != null && !this.params.args().isEmpty()) {
            JSONArray params = new JSONArray();
            for (TypescriptParamType arg : this.params.args()) {
                JSONObject theParams = new JSONObject();
                arg.generateStructure(theParams);
                params.add(theParams);
            }
            json.put("params", params);
        }

        JSONArray statements = new JSONArray();
        for (TypescriptStatement statement : this.statements) {
            JSONObject theStatement = new JSONObject();
            statement.generateStructure(theStatement);
            statements.add(theStatement);
        }
        json.put("statements", statements);
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
