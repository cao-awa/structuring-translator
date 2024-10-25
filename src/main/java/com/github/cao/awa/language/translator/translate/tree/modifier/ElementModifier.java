package com.github.cao.awa.language.translator.translate.tree.modifier;

public abstract class ElementModifier<T extends ElementModifierType> {
    public abstract T type();
    public abstract String literal();
    public boolean isLiteral() {
        return true;
    }
}
