package com.github.cao.awa.translator.structuring.builtin.typescript.tree.object.anonymous;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptAnonymousObject extends TypescriptResultStatement {
    private TypescriptAnonymousObjectParamList params = new TypescriptAnonymousObjectParamList(this);

    public TypescriptAnonymousObject params(TypescriptAnonymousObjectParamList params) {
        this.params = params;
        return this;
    }

    public TypescriptAnonymousObjectParamList params() {
        return this.params;
    }

    public TypescriptAnonymousObject(StructuringAst parent) {
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
