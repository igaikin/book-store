package com.company.bookseller.model.service;

import com.company.bookseller.model.beans.Order;

import java.util.List;

public interface OrderService extends AbstractService<Order, Long> {
    List<Order> getOrderByBookId(long bookId);

    List<Order> getOrderByUserId(long userId);
}
