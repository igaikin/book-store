package com.company.bookseller.model.entity;

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
