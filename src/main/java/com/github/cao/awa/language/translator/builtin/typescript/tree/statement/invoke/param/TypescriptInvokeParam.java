package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.param;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.TypescriptResultStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public class TypescriptInvokeParam extends TypescriptStatement {
    private String reference;
    private TypescriptResultStatement result;

    public TypescriptInvokeParam result(TypescriptResultStatement result) {
        this.result = result;
        return this;
    }

    public TypescriptResultStatement result() {
        return this.result;
    }

    public TypescriptInvokeParam reference(String reference) {
        this.reference = reference;
        return this;
    }

    public String reference() {
        return this.reference;
    }

    public TypescriptInvokeParam(LanguageAst parent) {
        super(parent);
    }

    @Override
    public void generateStructure(JSONObject json) {
        if (this.result != null) {
            json.put("param_type", "statement");
            JSONObject theStatement = new JSONObject();
            this.result.generateStructure(theStatement);
            json.put("statement", theStatement);
        }

        if (this.reference != null) {
            json.put("param_type", "reference");
            json.put("reference", this.reference);
        }
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
