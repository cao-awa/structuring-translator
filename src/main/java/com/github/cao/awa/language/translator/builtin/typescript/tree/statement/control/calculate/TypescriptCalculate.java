package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.TypescriptSymbol;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.LinkedList;

public class TypescriptCalculate extends TypescriptResultStatement {
    private TypescriptResultStatement left;
    private TypescriptSymbol symbol;
    private TypescriptResultStatement right;
    private LinkedList<TypescriptCalculate> rights = CollectionFactor.linkedList();
    private boolean leftWithParen;
    private boolean rightWithParen;
    private boolean totalWithParen;
    private boolean doNotGroup;

    public TypescriptResultStatement left() {
        return left;
    }

    public TypescriptCalculate left(TypescriptResultStatement left) {
        this.left = left;
        return this;
    }

    public TypescriptSymbol symbol() {
        return symbol;
    }

    public TypescriptCalculate symbol(TypescriptSymbol symbol) {
        this.symbol = symbol;
        return this;
    }

    public TypescriptResultStatement right() {
        return right;
    }

    public TypescriptCalculate right(TypescriptResultStatement right) {
        this.right = right;
        return this;
    }

    public LinkedList<TypescriptCalculate> rights() {
        return rights;
    }

    public TypescriptCalculate rights(LinkedList<TypescriptCalculate> rights) {
        this.rights = rights;
        return this;
    }

    public boolean leftWithParen() {
        return leftWithParen;
    }

    public TypescriptCalculate leftWithParen(boolean leftWithParen) {
        this.leftWithParen = leftWithParen;
        return this;
    }

    public boolean rightWithParen() {
        return rightWithParen;
    }

    public TypescriptCalculate rightWithParen(boolean rightWithParen) {
        this.rightWithParen = rightWithParen;
        return this;
    }

    public boolean totalWithParen() {
        return totalWithParen;
    }

    public TypescriptCalculate totalWithParen(boolean totalWithParen) {
        this.totalWithParen = totalWithParen;
        return this;
    }

    public boolean doNotGroup() {
        return doNotGroup;
    }

    public TypescriptCalculate doNotGroup(boolean doNotGroup) {
        this.doNotGroup = doNotGroup;
        return this;
    }

    public TypescriptCalculate(LanguageAst parent) {
        super(parent);
    }

    @Override
    public void generateStructure(JSONObject json) {
        json.put("statement_type", "calculate");

        if (this.left != null) {
            JSONObject left = new JSONObject();
            this.left.generateStructure(left);
            json.put("left", left);
        }

        if (this.symbol != null) {
            json.put("symbol", this.symbol.symbol());

            JSONArray rights = new JSONArray();
            rights.add(this.right);

            if (this.rights != null) {
                for (TypescriptCalculate right : this.rights) {
                    JSONObject theRight = new JSONObject();
                    right.generateStructure(theRight);
                    rights.add(theRight);
                }
            }
            json.put("rights", rights);
        }
    }

    @Override
    public void print(String ident) {
    }


    public TypescriptCalculate dump(LanguageAst parent) {
        return new TypescriptCalculate(parent)
                .left(this.left)
                .symbol(this.symbol)
                .right(this.right)
                .rights(this.rights == null ? null : new LinkedList<>(this.rights))
                .leftWithParen(this.leftWithParen)
                .rightWithParen(this.rightWithParen)
                .totalWithParen(this.totalWithParen);
    }

    @Override
    public void preprocess() {
        this.left.isEnding(false);
        this.left.preprocess();

        this.right.isEnding(false);
        this.right.preprocess();

        for (TypescriptCalculate typescriptCalculate : this.rights) {
            typescriptCalculate.isEnding(false);
            typescriptCalculate.preprocess();
        }
    }

    @Override
    public void postprocess() {
    }

    @Override
    public void consequence() {
    }
}
