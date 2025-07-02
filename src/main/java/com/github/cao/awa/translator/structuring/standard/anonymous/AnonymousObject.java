package com.github.cao.awa.translator.structuring.standard.anonymous;

import com.github.cao.awa.sinuatum.util.collection.CollectionFactor;

import java.util.Iterator;
import java.util.Map;

public class AnonymousObject<Object> implements Iterable<Map.Entry<String, Object>> {
    private final Map<String, Object> delegate = CollectionFactor.hashMap();

    public void set(String key, Object element) {
        this.delegate.put(key, element);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) this.delegate.get(key);
    }

    public Iterator<Map.Entry<String, Object>> iterator() {
        return this.delegate.entrySet().iterator();
    }
}
