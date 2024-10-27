package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.importing;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.List;

public class TypescriptImportStatement extends TypescriptStatement {
    private final List<String> imports = CollectionFactor.linkedList();
    private String from;

    public TypescriptImportStatement from(String from) {
        this.from = from;
        return this;
    }

    public String from() {
        return this.from;
    }

    public void addImport(String importName) {
        this.imports.add(importName);
    }

    public List<String> imports() {
        return this.imports;
    }

    public TypescriptImportStatement(LanguageAst parent) {
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
