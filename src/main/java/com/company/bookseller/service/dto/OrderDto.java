package com.company.bookseller.service.dto;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class OrderDto {
    private Long id;
    private StatusDto status;
    private LocalDateTime orderDateTime;
    private UserDto user;
    private BigDecimal totalPrice;
    private Map<BookDto, Integer> items;

    public enum StatusDto {
        PENDING("Pending"),
        DELIVERING("Delivering"),
        DELIVERED("Delivered"),
        CANCELLED("Cancelled");

        @Getter
        private final String name;

        StatusDto(String name) {
            this.name = name;
        }
    }
}
