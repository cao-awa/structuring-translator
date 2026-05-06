package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.variable;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.result.TypescriptResultStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.vararg.TypescriptArgType;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptDefineVariable extends TypescriptStatement {
    private TypescriptArgType type;
    private String name;
    private TypescriptResultStatement assignment;
    private boolean isFinal = false;
    private boolean isDefine = false;

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

    public TypescriptDefineVariable isDefine(boolean isDefine) {
        this.isDefine = isDefine;
        return this;
    }

    public boolean isDefine() {
        return this.isDefine;
    }

    public void assignment(TypescriptResultStatement assignment) {
        this.assignment = assignment;
    }

    public TypescriptResultStatement assignment() {
        return this.assignment;
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
        if (this.assignment != null) {
            JSONObject theAssignment = new JSONObject();
            this.assignment.generateStructure(theAssignment);
            json.put("assignment", theAssignment);
        }
    }

    @Override
    public void preprocess() {
        this.type.preprocess();
        this.assignment.preprocess();
    }

    @Override
    public void postprocess() {
        this.type.postprocess();
        this.assignment.postprocess();
    }

    @Override
    public void consequence() {
        this.type.consequence();
        this.assignment.consequence();
    }
}
