package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.list;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.List;

public class TypescriptOfList extends TypescriptResultStatement {
    private final List<TypescriptResultStatement> elements = CollectionFactor.arrayList();

    public TypescriptOfList addElement(TypescriptResultStatement element) {
        this.elements.add(element);
        return this;
    }

    public List<TypescriptResultStatement> elements() {
        return this.elements;
    }

    public TypescriptOfList(StructuringAst parent) {
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
