package com.company.bookseller.util;

public interface MyCollection {

    int size();

    void add(Object obj);

    boolean remove(Object obj);

    boolean contains(Object obj);

    Object get();

    Object[] toArray();
}
