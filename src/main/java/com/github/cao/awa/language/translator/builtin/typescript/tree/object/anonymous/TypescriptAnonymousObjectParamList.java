package com.github.cao.awa.language.translator.builtin.typescript.tree.object.anonymous;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.TypescriptResultStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.Map;

public class TypescriptAnonymousObjectParamList extends TypescriptStatement {
    private final Map<String, TypescriptResultStatement> values = CollectionFactor.hashMap();

    public TypescriptAnonymousObjectParamList addValue(String key, TypescriptResultStatement value) {
        this.values.put(key, value);
        return this;
    }

    public Map<String, TypescriptResultStatement> values() {
        return this.values;
    }

    public TypescriptAnonymousObjectParamList(LanguageAst parent) {
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
