package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.loop;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.List;

public class TypescriptFor extends TypescriptStatement {
    private final List<TypescriptStatement> statements = CollectionFactor.arrayList();
    private TypescriptStatement initStatement;
    private TypescriptResultStatement condition;
    private TypescriptResultStatement operationStatement;

    public TypescriptFor addStatement(TypescriptStatement statement) {
        this.statements.add(statement);
        return this;
    }

    public List<TypescriptStatement> statements() {
        return this.statements;
    }

    public TypescriptStatement initStatement() {
        return this.initStatement;
    }

    public TypescriptFor initStatement(TypescriptStatement initStatement) {
        this.initStatement = initStatement;
        return this;
    }

    public TypescriptResultStatement condition() {
        return this.condition;
    }

    public TypescriptFor condition(TypescriptResultStatement condition) {
        this.condition = condition;
        return this;
    }

    public TypescriptResultStatement operationStatement() {
        return this.operationStatement;
    }

    public TypescriptFor operationStatement(TypescriptResultStatement operationStatement) {
        this.operationStatement = operationStatement;
        return this;
    }

    public TypescriptFor(LanguageAst parent) {
        super(parent);
    }

    @Override
    public void generateStructure(JSONObject json) {

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
