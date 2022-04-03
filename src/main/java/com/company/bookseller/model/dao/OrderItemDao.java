package com.company.bookseller.model.dao;

import com.company.bookseller.model.entity.OrderItem;

import java.util.List;

public interface OrderItemDao extends AbstractDao<OrderItem, Long> {
    List<OrderItem> getByOrderId(Long orderId);
}
