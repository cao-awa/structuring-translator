package com.github.cao.awa.translator.structuring.cast;

public class Caster {
    @SuppressWarnings("unchecked")
    public static <T> T cast(Object target) {
        return (T) target;
    }
}
