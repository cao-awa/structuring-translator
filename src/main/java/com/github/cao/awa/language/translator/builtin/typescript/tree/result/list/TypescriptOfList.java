package com.github.cao.awa.language.translator.builtin.typescript.tree.result.list;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.TypescriptResultStatement;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;
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

    public TypescriptOfList(LanguageAst parent) {
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
