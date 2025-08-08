package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.List;

public class TypescriptIf extends TypescriptResultStatement {
    private final List<TypescriptStatement> statements = CollectionFactor.linkedList();
    private final List<TypescriptStatement> elseStatements = CollectionFactor.linkedList();
    private TypescriptIf elseIfStatement;
    private TypescriptResultStatement predicate;

    public List<TypescriptStatement> statements() {
        return this.statements;
    }

    public List<TypescriptStatement> elseStatements() {
        return elseStatements;
    }

    public TypescriptIf addStatement(TypescriptStatement statement) {
        this.statements.add(statement);
        return this;
    }

    public TypescriptIf addElseStatement(TypescriptStatement statement) {
        this.elseStatements.add(statement);
        return this;
    }

    public TypescriptIf elseIfStatement() {
        return elseIfStatement;
    }

    public TypescriptIf elseIfStatement(TypescriptIf elseIfStatement) {
        this.elseIfStatement = elseIfStatement;
        return this;
    }

    public TypescriptResultStatement predicate() {
        return this.predicate;
    }

    public TypescriptIf predicate(TypescriptResultStatement predicate) {
        this.predicate = predicate;
        return this;
    }

    public TypescriptIf(StructuringAst ast) {
        super(ast);
    }

    @Override
    public void generateStructure(JSONObject json) {
        json.put("statement_type", "if");

        if (this.predicate != null) {
            JSONObject thePredicate = new JSONObject();
            this.predicate.generateStructure(thePredicate);
            json.put("predicate", thePredicate);
        }

        if (!this.statements.isEmpty()) {
            JSONArray statements = new JSONArray();
            for (TypescriptStatement statement : this.statements) {
                JSONObject theStatement = new JSONObject();
                statement.generateStructure(theStatement);
                statements.add(theStatement);
            }
            json.put("statements", statements);
        }

        if (this.elseIfStatement != null) {
            JSONObject theElse = new JSONObject();
            this.elseIfStatement.generateStructure(theElse);
            json.put("else_if", theElse);
        }

        if (!this.elseStatements.isEmpty()) {
            JSONArray elseStatements = new JSONArray();
            for (TypescriptStatement statement : this.elseStatements) {
                JSONObject theElse = new JSONObject();
                statement.generateStructure(theElse);
                elseStatements.add(theElse);
            }
            json.put("else", elseStatements);
        }
    }

    @Override
    public void print(String indent) {
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
