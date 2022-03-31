package com.company.bookseller.model.beans;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Order {
    private long id;
    private Status status;
    private LocalDateTime date;
    private User user;
    private BigDecimal totalPrice;
    private OrderItem orderItems;

    public enum Status {
        PENDING("Pending"),
        DELIVERING("Delivering"),
        DELIVERED("Delivered"),
        CANCELLED("Cancelled");

        @Getter
        private final String name;

        Status(String name) {
            this.name = name;
        }
    }
}
