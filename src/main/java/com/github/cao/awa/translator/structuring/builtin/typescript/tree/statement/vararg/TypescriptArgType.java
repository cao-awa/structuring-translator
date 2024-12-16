package com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.vararg;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.cao.awa.translator.structuring.builtin.typescript.tree.statement.TypescriptStatement;
import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;
import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.LinkedList;
import java.util.List;

public class TypescriptArgType extends TypescriptStatement {
    private final LinkedList<TypescriptArgType> args = CollectionFactor.linkedList();
    private String name;
    private boolean arrayArgType = false;
    private int arraySize = -1;
    private int arrayDepth = 1;

    public LinkedList<TypescriptArgType> args() {
        return this.args;
    }

    public String name() {
        return this.name;
    }

    public void name(String name) {
        this.name = name;
    }

    public boolean arrayArgType() {
        return this.arrayArgType;
    }

    public void arrayArgType(boolean arrayArgType) {
        this.arrayArgType = arrayArgType;
    }

    public int arrayDepth() {
        return this.arrayDepth;
    }

    public void arrayDepth(int arrayDepth) {
        this.arrayDepth = arrayDepth;
    }

    public TypescriptArgType(StructuringAst parent) {
        super(parent);
    }

    @Override
    public void generateStructure(JSONObject json) {
        json.put("name", this.name);
        if (this.arrayArgType) {
            json.put("arrayDepth", this.arrayDepth);
            if (this.arraySize != -1) {
                json.put("arraySize", this.arraySize);
            }
        }

        if (!this.args.isEmpty()) {
            JSONArray varargs = new JSONArray();
            for (TypescriptArgType arg : this.args) {
                JSONObject vararg = new JSONObject();
                arg.generateStructure(vararg);
                varargs.add(arg);
            }
            json.put("varargs", varargs);
        }
    }

    public void addArg(TypescriptArgType argType) {
        this.args.add(argType);
    }

    public String formatCompletedName() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name);
        if (!this.args.isEmpty()) {
            builder.append("<");
            LinkedList<TypescriptArgType> args = this.args;
            int size = args.size();
            int edge = size - 1;
            for (int i = 0; i < size; i++) {
                TypescriptArgType arg = args.get(i);
                builder.append(arg.formatCompletedName());
                if (i != edge) {
                    builder.append(",");
                }
            }
            builder.append(">");
        }
        if (this.arrayArgType) {
            int depth = this.arrayDepth;
            while (depth-- > 0) {
                builder.append("[");
                if (this.arraySize == 1) {
                    builder.append(this.arraySize);
                }
                builder.append("]");
            }
        }

        return builder.toString();
    }

    @Override
    public void print(String ident) {
        StringBuilder varargCountBuilder = new StringBuilder();
        if (!this.args.isEmpty()) {
            varargCountBuilder.append("<");
            varargCountBuilder.append("?, ".repeat(this.args.size()));
            varargCountBuilder.delete(varargCountBuilder.length() - 2, varargCountBuilder.length());
            varargCountBuilder.append(">");
        }
        System.out.println(ident + "|_ " + this.name + varargCountBuilder + (this.arrayArgType ? "[?]".repeat(this.arrayDepth) : ""));
        for (TypescriptArgType argType : this.args) {
            argType.print(ident + "    ");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TypescriptArgType argType) {
            List<TypescriptArgType> selfArgs = this.args;
            List<TypescriptArgType> targetArgs = argType.args;

            if (selfArgs.size() != targetArgs.size()) {
                return false;
            }

            for (int i = 0; i < this.args.size(); i++) {
                if (!selfArgs.get(i).equals(targetArgs.get(i))) {
                    return false;
                }
            }

            return argType.name.equals(this.name)
                    && argType.arrayDepth == this.arrayDepth
                    && argType.arraySize == this.arraySize;
        }
        return false;
    }

    @Override
    public void preprocess() {
        for (TypescriptArgType arg : this.args) {
            arg.preprocess();
        }
    }

    @Override
    public void postprocess() {
        for (TypescriptArgType arg : this.args) {
            arg.postprocess();
        }
    }

    @Override
    public void consequence() {
        for (TypescriptArgType arg : this.args) {
            arg.consequence();
        }
    }
}
