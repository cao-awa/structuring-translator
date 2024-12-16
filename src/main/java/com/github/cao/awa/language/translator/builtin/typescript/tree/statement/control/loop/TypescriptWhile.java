package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.loop;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.List;

public class TypescriptWhile extends TypescriptStatement {
    private final List<TypescriptStatement> statements = CollectionFactor.arrayList();
    private TypescriptResultStatement condition;

    public TypescriptWhile addStatement(TypescriptStatement statement) {
        this.statements.add(statement);
        return this;
    }

    public List<TypescriptStatement> statements() {
        return this.statements;
    }

    public TypescriptResultStatement condition() {
        return this.condition;
    }

    public TypescriptWhile condition(TypescriptResultStatement condition) {
        this.condition = condition;
        return this;
    }

    public TypescriptWhile(LanguageAst parent) {
        super(parent);
    }

    @Override
    public void generateStructure(JSONObject json) {
        json.put("statement_type", "while");

        JSONObject theCondition = new JSONObject();
        this.condition.generateStructure(theCondition);
        json.put("condition", theCondition);

        if (!this.statements.isEmpty()) {
            JSONArray theStatements = new JSONArray();
            for (TypescriptStatement statement : this.statements) {
                JSONObject theStatement = new JSONObject();
                statement.generateStructure(theStatement);
            }
            json.put("statements", theStatements);
        }
    }

    @Override
    public void preprocess() {
        this.condition.preprocess();
        this.statements.forEach(LanguageAst::preprocess);
    }

    @Override
    public void postprocess() {
        this.condition.postprocess();
        this.statements.forEach(LanguageAst::postprocess);
    }

    @Override
    public void consequence() {
        this.condition.consequence();
        this.statements.forEach(LanguageAst::consequence);
    }
}
