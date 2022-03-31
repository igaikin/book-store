package com.company.bookseller.model.beans;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
public class Book {
    private long id;
    private String author;
    private String title;
    private Cover cover;
    private int numberOfPages;
    private long isbn;
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
