package com.github.cao.awa.translator.structuring.builtin.typescript.tree;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.List;

public class TypescriptFile extends StructuringAst {
    private final List<TypescriptStatement> statements = CollectionFactor.linkedList();

    public void addStatement(TypescriptStatement statement) {
        this.statements.add(statement);
    }

    public List<TypescriptStatement> statements() {
        return this.statements;
    }

    public TypescriptFile(StructuringAst parent) {
        super(parent);
    }

    @Override
    public void generateStructure(JSONObject json) {
        JSONArray array = new JSONArray();

        for (TypescriptStatement statement : this.statements) {
            JSONObject theStatement = new JSONObject();
            statement.generateStructure(theStatement);
            array.add(theStatement);
        }
        json.put("statements", array);
    }

    @Override
    public void preprocess() {
        this.statements.forEach(StructuringAst::preprocess);
    }

    @Override
    public void postprocess() {
        this.statements.forEach(StructuringAst::postprocess);
    }

    @Override
    public void consequence() {
        this.statements.forEach(StructuringAst::consequence);
    }
}
