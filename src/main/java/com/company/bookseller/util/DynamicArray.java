package com.company.bookseller.util;

import java.util.Arrays;

public class DynamicArray implements MyCollection {

    private Object[] array;
    private int size;

    public DynamicArray(int initialSize) {
        if (initialSize < 1) {
            throw new IllegalArgumentException("WARNING!!!");
        }
        array = new Object[initialSize];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object obj) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = obj;
    }

    @Override
    public boolean remove(Object obj) {
        boolean isDeleted = false;
        for (int i = 0; i < size; i++) {
            if (isDeleted) {
                array[i - 1] = array[i];
            } else if (array[i].equals(obj)) {
                array[i] = null;
                size--;
                isDeleted = true;
            }
        }
        if (isDeleted) {
            array[size] = null;
        }
        return isDeleted;
    }

    @Override
    public boolean contains(Object obj) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object get() {
        if (size == 0) {
            return null;
        }
        return array[size - 1];
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }
}
