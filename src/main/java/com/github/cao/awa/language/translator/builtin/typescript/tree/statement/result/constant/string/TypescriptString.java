package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result.constant.string;

import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.result.constant.TypescriptConstant;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public class TypescriptString extends TypescriptConstant<String> {
    private String value;

    public TypescriptString(LanguageAst parent) {
        super(parent);
    }

    public void value(String value) {
        this.value = value;
    }

    @Override
    public String literal() {
        return this.value;
    }

    @Override
    public String constantValue() {
        return this.value;
    }
}
