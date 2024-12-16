package com.github.cao.awa.translator.structuring.translate.tree.modifier;

import com.github.cao.awa.translator.structuring.translate.tree.modifier.accessible.AccessibleModifier;
import com.github.cao.awa.translator.structuring.translate.tree.modifier.accessible.AccessibleType;

import java.util.Collection;

public interface ModifierRequiredAst<T extends ElementModifier<?>> {
    Collection<T> modifierValues();

    AccessibleModifier accessible();

    void addModifier(T modifier);

    void addAccessible(AccessibleModifier modifier);

    default void addAccessible(AccessibleType type) {
        addAccessible(type.generic());
    }
}
