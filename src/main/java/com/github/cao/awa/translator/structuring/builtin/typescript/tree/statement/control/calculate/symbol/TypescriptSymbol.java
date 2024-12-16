package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.calculate.symbol;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public abstract class TypescriptSymbol extends TypescriptResultStatement {
    public TypescriptSymbol(StructuringAst ast) {
        super(ast);
    }

    @Override
    public void generateStructure(JSONObject json) {
        json.put("symbol", symbol());
        json.put("symbol_name", name());
    }

    public abstract int level();

    public abstract String symbol();

    public TypescriptSymbol operatorSymbol() {
        return this;
    }

    public abstract String name();

    public boolean is(TypescriptSymbol... asts) {
        for (TypescriptSymbol ast : asts) {
            if (ast.symbol().equals(symbol())) {
                return true;
            }
        }
        return false;
    }

    public String oppositeName() {
        return name();
    }

    public boolean leftPrimary() {
        return false;
    }

    public boolean notBinary() {
        return true;
    }

    public boolean isAssigment() {
        return false;
    }

    public boolean oppositePresent() {
        return !oppositeName().equals(name());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TypescriptSymbol symbol) {
            return symbol.name().equals(name()) && symbol.symbol().equals(symbol()) && symbol.level() == level();
        }
        return false;
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
