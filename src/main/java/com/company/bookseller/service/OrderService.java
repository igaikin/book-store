package com.company.bookseller.service;

import com.company.bookseller.service.dto.OrderDto;

import java.util.List;

public interface OrderService extends AbstractService<OrderDto, Long> {
    List<OrderDto> getOrderByBookId(Long bookId);

    List<OrderDto> getOrderByUserId(Long userId);
}
