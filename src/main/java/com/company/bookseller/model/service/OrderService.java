package com.company.bookseller.model.service;

import com.company.bookseller.model.dto.OrderDto;
import com.company.bookseller.model.entity.Order;

import java.util.List;

public interface OrderService extends AbstractService<OrderDto, Long> {
    List<OrderDto> getOrderByBookId(Long bookId);

    List<OrderDto> getOrderByUserId(Long userId);
}
