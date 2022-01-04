package com.company.bookseller.model.service;

import java.util.List;

public interface AbstractService<T, K> {
    List<T> getAll();

    T get(K id);

    T create(T entity);

    T update(T entity);

    boolean delete(K id);
}
