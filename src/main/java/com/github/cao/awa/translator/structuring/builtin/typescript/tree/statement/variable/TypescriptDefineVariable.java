package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.variable;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.sinuatum.manipulate.Manipulate;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.vararg.TypescriptArgType;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptDefineVariable extends TypescriptStatement {
    private TypescriptArgType type;
    private String name;
    private TypescriptResultStatement assigment;
    private boolean isFinal;

    public TypescriptDefineVariable name(String name) {
        this.name = name;
        return this;
    }

    public String name() {
        return this.name;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends StructuringAst> T postFindAst(Class<T> target) {
        if (target == TypescriptArgType.class) {
            return (T) this.type;
        }
        return null;
    }

    public TypescriptDefineVariable type(TypescriptArgType type) {
        this.type = type;
        return this;
    }

    public TypescriptArgType type() {
        return this.type;
    }

    public TypescriptDefineVariable isFinal(boolean isFinal) {
        this.isFinal = isFinal;
        return this;
    }

    public boolean isFinal() {
        return this.isFinal;
    }

    public void assigment(TypescriptResultStatement assigment) {
        this.assigment = assigment;
    }

    public TypescriptResultStatement assigment() {
        return this.assigment;
    }

    public TypescriptDefineVariable(StructuringAst parent) {
        super(parent);
    }

    @Override
    public void generateStructure(JSONObject json) {
        json.put("statement_type", "define_variable");
        json.put("name", this.name);
        if (this.type != null) {
            JSONObject theType = new JSONObject();
            this.type.generateStructure(theType);
            json.put("type", theType);
        }
        if (this.assigment != null) {
            JSONObject theAssigment = new JSONObject();
            this.assigment.generateStructure(theAssigment);
            json.put("assigment", theAssigment);
        }
    }

    @Override
    public void preprocess() {
        Manipulate.makeNonNull(this.type, TypescriptArgType::preprocess);
        Manipulate.makeNonNull(this.assigment, TypescriptResultStatement::preprocess);
    }

    @Override
    public void postprocess() {
        Manipulate.makeNonNull(this.type, TypescriptArgType::postprocess);
        Manipulate.makeNonNull(this.assigment, TypescriptResultStatement::postprocess);
    }

    @Override
    public void consequence() {
        Manipulate.makeNonNull(this.type, TypescriptArgType::consequence);
        Manipulate.makeNonNull(this.assigment, TypescriptResultStatement::consequence);
    }
}
