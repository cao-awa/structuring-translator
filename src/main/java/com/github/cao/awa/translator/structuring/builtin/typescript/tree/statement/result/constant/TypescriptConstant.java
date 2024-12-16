package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.constant;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public abstract class TypescriptConstant<T> extends TypescriptResultStatement {
    public TypescriptConstant(StructuringAst parent) {
        super(parent);
    }

    @Override
    public void generateStructure(JSONObject json) {
        json.put("statement_type", "constant");
        json.put("value", constantValue());
    }

    public abstract String literal();

    public abstract T constantValue();

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
