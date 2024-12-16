package com.github.cao.awa.translator.structuring.builtin.typescript.tree.object.callback;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.function.TypescriptParamList;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.List;

public class TypescriptCallbackFunction extends TypescriptResultStatement {
    private final List<TypescriptStatement> statements = CollectionFactor.linkedList();
    private TypescriptParamList params;

    public TypescriptCallbackFunction addStatement(TypescriptStatement statement) {
        this.statements.add(statement);
        return this;
    }

    public List<TypescriptStatement> statements() {
        return this.statements;
    }

    public TypescriptCallbackFunction params(TypescriptParamList params) {
        this.params = params;
        return this;
    }

    public TypescriptParamList params() {
        return this.params;
    }

    public TypescriptCallbackFunction(StructuringAst parent) {
        super(parent);
    }

    @Override
    public void generateStructure(JSONObject json) {
        json.put("statement_type", "callback_function");
        if (this.params != null) {
            JSONObject theParams = new JSONObject();
            this.params.generateStructure(theParams);
            json.put("params", theParams);
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
