package com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.undefined;

import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.TypescriptConstant;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public class TypescriptUndefined extends TypescriptConstant<Object> {
    public TypescriptUndefined(LanguageAst parent) {
        super(parent);
    }

    @Override
    public String literal() {
        return "undefined";
    }

    @Override
    public Boolean constantValue() {
        return null;
    }
}
