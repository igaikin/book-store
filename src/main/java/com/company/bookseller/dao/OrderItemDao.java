package com.company.bookseller.dao;

import com.company.bookseller.dao.entity.OrderItem;

import java.util.List;

public interface OrderItemDao extends AbstractDao<OrderItem, Long> {
    List<OrderItem> getByOrderId(Long orderId);

    List<OrderItem> getByBookId(Long bookId);
}
