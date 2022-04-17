package com.company.bookseller.dao.entity;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Order {
    private Long id;
    private Status status;
    private LocalDateTime orderDateTime;
    private Long userId;
    private BigDecimal totalPrice;

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
