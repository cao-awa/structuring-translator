package com.github.cao.awa.translator.structuring.translate.tree.modifier;

public abstract class ElementModifier<T extends ElementModifierType> {
    public abstract T type();
    public abstract String literal();
    public boolean isLiteral() {
        return true;
    }
}
