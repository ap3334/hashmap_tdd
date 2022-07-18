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

        int keyIndex = getKeyIndex(key);

        if (keyIndex == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[keyIndex] = value;
        }

    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i]) {
                return i;
            }
        }
        return -1;
    }

    public V get(K key) {

        int keyIndex = getKeyIndex(key);

        if (keyIndex == -1) {
            return null;
        }

        return (V)values[keyIndex];
    }
}
