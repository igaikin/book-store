package com.company.bookseller.model.beans.order;

import com.company.bookseller.model.beans.entities.Book;
import com.company.bookseller.model.beans.entities.User;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Data
public class Order {
    private long id;
    private Status status;
    private BigDecimal totalPrice;
    private int quantity;
    private boolean deleted;
    private User user;
    private List<Book> books = new LinkedList<>();
    private static final String NEW_LINE = System.lineSeparator();

    public enum Status {
        PENDING("Pending"),
        DELIVERING("Delivering"),
        DELIVERED("Delivered"),
        CANCELLED("Cancelled");

        @Getter
        private String name;

        Status(String name) {
            this.name = name;
        }
    }

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
        for (int i = 0; i < books.size(); i++) {
            sb.append("\t")
                    .append(i + 1)
                    .append(":  ")
                    .append(books.get(i).getAuthor())
                    .append(" ")
                    .append(books.get(i).getTitle())
                    .append(NEW_LINE);
        }
        return sb.toString();
    }

    public String getHeaderLine() {
        return String.format(
                "* * * * * * * O R D E R * * * * * * * %n"
                        + "-------------------------------------%n"
                        + "%d %s %s ", user.getId(), user.getFirstName(), user.getLastName());
    }

    public boolean addBook(Book book) {
        return books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    public void setUser(List<User> user) {
    }

    public static Status setStatus(Status status) {
        return status;
    }

    public Order() {
        Order order = new Order();
    }


}
