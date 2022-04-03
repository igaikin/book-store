package com.company.bookseller.model.beans;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderItem {
    public Long id;
    private Book book;
    private int quantity;
    private BigDecimal price;
    private List<Book> orderItems;
}
