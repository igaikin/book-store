package com.company.bookseller.service.dto;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
public class BookDto {
    private Long id;
    private String image;
    private String author;
    private String title;
    private Cover cover;
    private int pages;
    private String isbn;
    private BigDecimal price;

    public enum Cover {
        HARD("Hardcover"),
        SOFT("Paperback");

        @Getter
        private final String name;

        Cover(String name) {
            this.name = name;
        }
    }
}
