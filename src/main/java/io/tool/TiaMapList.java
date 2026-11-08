package io.tool;

public class TiaMapList<V> {

    public TiaList<V> keys;

    public TiaMapList() {
        keys = new TiaList<>();
    }

    public int add(String key, V awa) {
        return keys.add(awa);
    }
}