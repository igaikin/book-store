package com.company.bookseller.model.dao;

import com.company.bookseller.model.beans.order.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getAll();

    Order getById(long id);

    static Order getByBookId(long bookId) {
        return null;
    }

    static Order getByUserId(long userId) {
        return null;
    }
}
