package com.company.bookseller.model.beans;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
public class Order {
    private long id;
    private Status status;
    private BigDecimal totalPrice;
    private int quantity;
    private User user;
    private Book book;

    public String getFormattedOutput() {
        return String.format("Book:%n"
                        + "ID          | %d%n"
                        + "Status      | %s%n"
                        + "User        | %s%n"
                        + "Book        | %s%n"
                        + "Quantity    | %d%n"
                        + "Price       | $%.2f%n"
                        + "%n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ",
                getId(), status.name, getUser(), getBook(), getQuantity(), getTotalPrice());
    }

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
