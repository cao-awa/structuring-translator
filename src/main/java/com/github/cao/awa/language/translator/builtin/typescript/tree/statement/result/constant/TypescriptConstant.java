package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result.constant;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public abstract class TypescriptConstant<T> extends TypescriptResultStatement {
    public TypescriptConstant(LanguageAst parent) {
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