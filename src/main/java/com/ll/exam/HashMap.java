package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

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
            if (key.equals(keys[i])) {
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

    public void remove(K key) {

        int keyIndex = getKeyIndex(key);

        if (keyIndex == -1) {
            return;
        }

        moveLeft(keys, keyIndex + 1, size - 1);
        moveLeft(values, keyIndex + 1, size - 1);

        size--;

    }

    private void moveLeft(Object[] arr, int from, int to) {

        for (int i = from; i <= to; i++) {
            arr[i - 1] = arr[i];
        }
    }

    public int size() {
        return size;
    }

    public List<K> keySet() {

        List<K> keyList = new ArrayList<>();

        for (Object key : keys) {
            keyList.add((K)key);
        }

        return keyList;

    }
}
