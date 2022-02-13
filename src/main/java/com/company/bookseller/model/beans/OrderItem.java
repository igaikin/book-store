package com.company.bookseller.model.beans;

import lombok.Data;

import java.util.List;
@Data
public class OrderItem {
    private Book book;
    private int quantity;
    private List<Book> orderItems;
}
