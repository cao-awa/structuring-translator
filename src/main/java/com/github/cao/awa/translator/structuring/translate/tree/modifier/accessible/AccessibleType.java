package com.github.cao.awa.translator.structuring.translate.tree.modifier.accessible;

import com.github.cao.awa.translator.structuring.translate.tree.modifier.genergic.GenericAccessibleModifier;

public enum AccessibleType {
    PUBLIC("public"),
    PROTECTED("protected"),
    PRIVATE("private");

    private final String literal;

    AccessibleType(String literal) {
        this.literal = literal;
    }

    public String literal() {
        return this.literal;
    }

    public GenericAccessibleModifier generic() {
        return new GenericAccessibleModifier(this);
    }
}
