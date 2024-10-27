package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.result.TypescriptResultStatement;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.access.TypescriptInvokeAccess;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.param.TypescriptInvokeParam;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.param.TypescriptInvokeParamList;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public class TypescriptInvoke extends TypescriptResultStatement {
    private TypescriptInvokeParamList params;
    private TypescriptInvokeObject invokeTarget;

    public TypescriptInvoke invokeTarget(TypescriptInvokeObject invokeTarget) {
        this.invokeTarget = invokeTarget;
        return this;
    }

    public TypescriptInvokeObject invokeTarget() {
        return this.invokeTarget;
    }

    public TypescriptInvoke params(TypescriptInvokeParamList params) {
        this.params = params;
        return this;
    }

    public TypescriptInvokeParamList params() {
        return this.params;
    }

    public TypescriptInvoke(LanguageAst parent) {
        super(parent);
    }

    @Override
    public void generateStructure(JSONObject json) {
        json.put("statement_type", "invoke");

        JSONObject theInvokeTarget = new JSONObject();
        this.invokeTarget.generateStructure(theInvokeTarget);
        json.put("invoke_target", theInvokeTarget);

        if (this.params != null) {
            JSONArray params = new JSONArray();
            for (TypescriptInvokeParam param : this.params.params()) {
                JSONObject theParam = new JSONObject();
                param.generateStructure(theParam);
                params.add(theParam);
            }
            json.put("invoke_params", params);
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
