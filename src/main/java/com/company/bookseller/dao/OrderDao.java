package com.company.bookseller.dao;

import com.company.bookseller.dao.entity.Order;

import java.util.List;

public interface OrderDao extends AbstractDao<Order, Long> {
    List<Order> getByUserId(Long userId);
}
