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
    private BigDecimal price;

    public String getFormattedOutput() {
        return String.format("Book:%n"
                        + "ID              | %d%n"
                        + "Author          | %s%n"
                        + "Title           | %s%n"
                        + "Cover           | %s%n"
                        + "Number of Pages | %d%n"
                        + "Price           | $%.2f%n"
                        + "%n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ",
                getId(), getAuthor(), getTitle(), cover.name, getNumberOfPages(), getPrice());
    }

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
