package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.function;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.List;

public class TypescriptParamList extends TypescriptStatement {
    private final List<TypescriptParamType> args = CollectionFactor.linkedList();

    public void addArg(TypescriptParamType arg) {
        this.args.add(arg);
    }

    public List<TypescriptParamType> args() {
        return this.args;
    }

    public TypescriptParamList(StructuringAst parent) {
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
