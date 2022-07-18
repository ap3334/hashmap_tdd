package com.ll.exam;

public class HashMap<K, V> {

    private Object[] keys;
    private Object[] values;
    private int size;

    HashMap() {
        size = 0;
        keys = new Object[100];
        values = new Object[100];
    }

    public void put(K key, V value) {

        keys[size] = key;
        values[size] = value;
        size++;

    }
}
