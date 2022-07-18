package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> {

    private Object[] keys;
    private Object[] values;
    private int size;

    HashMap() {
        size = 0;
        keys = new Object[2];
        values = new Object[keys.length];
    }

    public void put(K key, V value) {

        int keyIndex = getKeyIndex(key);

        sizeUpArrWhenFull();

        if (keyIndex == -1) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            values[keyIndex] = value;
        }

    }

    private void sizeUpArrWhenFull() {
        if (isFull()) {
            sizeUpArr();
        }
    }

    private void sizeUpArr() {
        keys = Util.arr.sizeUp(keys);
        values = Util.arr.sizeUp(values);
    }

    private boolean isFull() {
        return size == keys.length;
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

        Util.arr.moveLeft(keys, keyIndex + 1, size - 1);
        Util.arr.moveLeft(values, keyIndex + 1, size - 1);

        size--;

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
