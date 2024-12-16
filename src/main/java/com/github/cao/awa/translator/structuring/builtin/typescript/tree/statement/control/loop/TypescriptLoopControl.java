package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.loop;

import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.control.loop.control.TypescriptLoopControlType;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TypescriptLoopControl extends TypescriptStatement {
    private TypescriptLoopControlType controlType;

    public TypescriptLoopControlType controlType() {
        return this.controlType;
    }

    public TypescriptLoopControl controlType(TypescriptLoopControlType controlType) {
        this.controlType = controlType;
        return this;
    }

    public TypescriptLoopControl(StructuringAst parent, TypescriptLoopControlType controlType) {
        super(parent);
        this.controlType = controlType;
    }

    public TypescriptLoopControl(StructuringAst parent) {
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
