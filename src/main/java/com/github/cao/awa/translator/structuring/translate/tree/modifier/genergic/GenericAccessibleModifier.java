package com.github.cao.awa.translator.structuring.translate.tree.modifier.genergic;

import com.github.cao.awa.translator.structuring.translate.tree.modifier.accessible.AccessibleModifier;
import com.github.cao.awa.translator.structuring.translate.tree.modifier.accessible.AccessibleType;

public class GenericAccessibleModifier implements AccessibleModifier {
    private final AccessibleType accessibleType;

    public GenericAccessibleModifier(AccessibleType accessibleType) {
        this.accessibleType = accessibleType;
    }

    public GenericAccessibleModifier(String keyword) {
        this.accessibleType = switch (keyword) {
            case "public" -> AccessibleType.PUBLIC;
            case "protected" -> AccessibleType.PROTECTED;
            case "private"-> AccessibleType.PRIVATE;
            default -> throw new IllegalArgumentException("Unable to find accessible keyword: " + keyword);
        };
    }

    @Override
    public AccessibleType getAccessibleType() {
        return this.accessibleType;
    }
}
