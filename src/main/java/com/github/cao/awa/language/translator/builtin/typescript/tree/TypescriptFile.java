package com.github.cao.awa.language.translator.builtin.typescript.tree;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.List;

public class TypescriptFile extends LanguageAst {
    private final List<TypescriptStatement> statements = CollectionFactor.linkedList();

    public void addStatement(TypescriptStatement statement) {
        this.statements.add(statement);
    }

    public List<TypescriptStatement> statements() {
        return this.statements;
    }

    public TypescriptFile(LanguageAst parent) {
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
        this.statements.forEach(LanguageAst::preprocess);
    }

    @Override
    public void postprocess() {
        this.statements.forEach(LanguageAst::postprocess);
    }

    @Override
    public void consequence() {
        this.statements.forEach(LanguageAst::consequence);
    }
}
