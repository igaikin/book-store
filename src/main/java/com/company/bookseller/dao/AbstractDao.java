package com.company.bookseller.dao;

import java.util.List;

public interface AbstractDao<T, K> {
//    List<T> getAll();

    List<T> getAll(int limit, int offset);

    T get(K id);

    T create(T entity);

    T update(T entity);

    boolean delete(K id);
}
