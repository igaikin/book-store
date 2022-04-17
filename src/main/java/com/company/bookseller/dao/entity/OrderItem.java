package com.company.bookseller.dao.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItem {
    private Long id;
    private Long orderId;
    private Long bookId;
    private BigDecimal price;
    private int quantity;
}
