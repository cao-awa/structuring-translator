package com.github.cao.awa.translator.structuring.translate.element;

import com.github.cao.awa.translator.structuring.translate.tree.StructuringAst;

public class TranslateElementData<T extends StructuringAst> {
    private final Class<T> clazz;

    public Class<T> clazz() {
        return this.clazz;
    }

    public TranslateElementData(final Class<T> clazz) {
        this.clazz = clazz;
    }
}
