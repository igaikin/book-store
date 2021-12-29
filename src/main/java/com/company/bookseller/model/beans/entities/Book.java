package com.company.bookseller.model.beans.entities;

import com.company.bookseller.model.beans.order.Order;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
public class Book {
    long id;
    private String author;
    private String title;
    private Cover cover;
    private int numberOfPages;
    private BigDecimal price;
    private boolean deleted;
    private Order order;

    public enum Cover {
        HARD("Hardcover"),
        SOFT("Paperback");

        @Getter
        private final String name;

        Cover(String name) {
            this.name = name;
        }
    }

    public String getAllBooksList() {
        return String.format("ID - %d, Author - %s, Title - %s%n", getId(), getAuthor(), getTitle());
    }

    public String getFormattedOutput() {
        return String.format("Book:%n"
                        + "ID              | %d%n"
                        + "Author          | %s%n"
                        + "Title           | %s%n"
                        + "Cover           | %s%n"
                        + "Number of Pages | %d%n"
                        + "Price           | %.2f%n"
                        + "%n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ",
                getId(), getAuthor(), getTitle(), cover.name, getNumberOfPages(), getPrice());
    }
}
