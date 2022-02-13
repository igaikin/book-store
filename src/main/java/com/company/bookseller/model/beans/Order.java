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

    public String getFormattedOutput() {
        return String.format("Order:%n"
                        + "ID          | %d%n"
                        + "Date        | %s%n"
                        + "Status      | %s%n"
                        + "User        | %s%n"
                        + "Books       | %s%n"
                        + "Total price | $%.2f%n"
                        + "%n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ",
                getId(), getDate(), status.name, getUser(), orderItems, getTotalPrice());
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
