package com.company.bookseller.model.service;

import com.company.bookseller.model.beans.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrderByBookId(long bookId);

    List<Order> getOrderByUserId(long userId);

    Order getById(long id);

    List<Order> getAll();
}
