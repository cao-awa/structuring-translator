package com.github.cao.awa.language.translator.translate.tree;

import com.alibaba.fastjson2.JSONObject;

public abstract class LanguageAst {
    private LanguageAst parent;

    public LanguageAst(LanguageAst parent) {
        this.parent = parent;
    }

    public LanguageAst parent() {
        return this.parent;
    }

    public void parent(LanguageAst parent) {
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
    public <T extends LanguageAst> T findAst(Class<T> target) {
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

    public <T extends LanguageAst> T postFindAst(Class<T> target) {
        return null;
    }
}
