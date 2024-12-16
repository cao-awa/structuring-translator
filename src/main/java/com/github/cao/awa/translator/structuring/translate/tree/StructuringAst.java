package com.github.cao.awa.translator.structuring.translate.tree;

import com.alibaba.fastjson2.JSONObject;

public abstract class StructuringAst {
    private StructuringAst parent;

    public StructuringAst(StructuringAst parent) {
        this.parent = parent;
    }

    public StructuringAst parent() {
        return this.parent;
    }

    public void parent(StructuringAst parent) {
        this.parent = parent;
    }

    public abstract void generateStructure(JSONObject json);

    public void print() {
        print("");
    }

    public void print(String ident) {
        print(ident, true);
    }

    public void print(String ident, boolean endElement) {
//        print(ident);
    }

    public void prepares() {
        preprocess();
        postprocess();
        consequence();
    }

    public abstract void preprocess();

    public abstract void postprocess();

    public abstract void consequence();

    @SuppressWarnings("all")
    public <T extends StructuringAst> T findAst(Class<T> target) {
        if (getClass() == target) {
            return (T) this;
        } else {
            T posted = postFindAst(target);
            if (posted != null) {
                return posted;
            }
            if (this.parent != null) {
                return this.parent.findAst(target);
            } else {
                return null;
            }
        }
    }

    public <T extends StructuringAst> T postFindAst(Class<T> target) {
        return null;
    }
}
