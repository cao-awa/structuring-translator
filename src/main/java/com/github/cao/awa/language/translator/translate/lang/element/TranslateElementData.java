package com.github.cao.awa.language.translator.translate.lang.element;

import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

public class TranslateElementData<T extends LanguageAst> {
    private final Class<T> clazz;

    public Class<T> clazz() {
        return this.clazz;
    }

    public TranslateElementData(final Class<T> clazz) {
        this.clazz = clazz;
    }
}