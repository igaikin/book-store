package com.company.bookseller.model.beans;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Data
public class Order {
    private static final String NEW_LINE = System.lineSeparator();
    private long id;
    private Status status;
    private BigDecimal totalPrice;
    private int quantity;
    private User user;
    private Book book;

    public String getFormattedOutput() {
        StringBuilder sb = new StringBuilder("* * * * * * * G R O U P * * * * * * *" + NEW_LINE)
                .append("\t\t---------")
                .append(getStatus())
                .append("----------")
                .append(NEW_LINE);
        if (user != null) {
            sb.append(user.getId())
                    .append(user.getFirstName())
                    .append(" ")
                    .append(user.getLastName())
                    .append(NEW_LINE);
        }
        sb.append("\t")
                .append(1)
                .append(":  ")
                .append(book.getAuthor())
                .append(" ")
                .append(book.getTitle())
                .append(NEW_LINE);
        return sb.toString();
    }

    public String getHeaderLine() {
        return String.format(
                "* * * * * * * O R D E R * * * * * * * %n"
                        + "-------------------------------------%n"
                        + "%d %s %s ", user.getId(), user.getFirstName(), user.getLastName());
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
