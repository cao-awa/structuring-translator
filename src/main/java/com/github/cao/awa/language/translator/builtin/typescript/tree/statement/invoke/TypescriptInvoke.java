package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.param.TypescriptInvokeParam;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.invoke.param.TypescriptInvokeParamList;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.List;

public class TypescriptInvoke extends TypescriptResultStatement {
    private TypescriptInvokeParamList params;
    private TypescriptInvokeObject invokeTarget;
    private final List<TypescriptInvoke> fluentInvokes = CollectionFactor.arrayList();
    private boolean isFluent = false;

    public TypescriptInvoke invokeTarget(TypescriptInvokeObject invokeTarget) {
        this.invokeTarget = invokeTarget;
        return this;
    }

    public TypescriptInvokeObject invokeTarget() {
        return this.invokeTarget;
    }

    public TypescriptInvoke addFluentInvoke(TypescriptInvoke fluentInvoke) {
        this.fluentInvokes.add(fluentInvoke);
        return this;
    }

    public boolean fluent() {
        return this.isFluent;
    }

    public TypescriptInvoke fluent(boolean fluent) {
        isFluent = fluent;
        return this;
    }

    public List<TypescriptInvoke> fluentInvokes() {
        return this.fluentInvokes;
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

        if (this.invokeTarget != null) {
            JSONObject theInvokeTarget = new JSONObject();
            this.invokeTarget.generateStructure(theInvokeTarget);
            json.put("invoke_target", theInvokeTarget);
        } else {
            json.put("is_fluent", true);
        }

        if (this.params != null) {
            JSONArray params = new JSONArray();
            for (TypescriptInvokeParam param : this.params.params()) {
                JSONObject theParam = new JSONObject();
                param.generateStructure(theParam);
                params.add(theParam);
            }
            json.put("invoke_params", params);
        }

        if (!this.fluentInvokes.isEmpty()) {
            JSONArray theFluents = new JSONArray();

            for (TypescriptInvoke fluentInvoke : this.fluentInvokes) {
                JSONObject theFluent = new JSONObject();
                fluentInvoke.generateStructure(theFluent);
                theFluents.add(theFluent);
            }

            json.put("fluent_invokes", theFluents);
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
