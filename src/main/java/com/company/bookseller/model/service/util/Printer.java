package com.company.bookseller.model.service.util;

import com.company.bookseller.model.beans.Book;
import com.company.bookseller.model.beans.Order;
import com.company.bookseller.model.beans.User;

import java.util.List;

public class Printer {
    public static final String orderHeaderRow = """
            +---------------------------------------------------------------------------------------------------------------+
            | ID  |   Status   |          User          |                     Book                      | QTY | Total Price |
            +-----+------------+------------------------+-----------------------------------------------+-----+-------------+
            """;
    private static final String bookHeaderRow = """
            +-------------------------------------------------------------------------+
            |  ID |          Author         |             Title             |  Price  |
            +-----+-------------------------+-------------------------------+---------+
            """;
    private static final String userHeaderRow = """
            +--------------------------------------------------+
            |  ID |     First Name     |       Last Name       |
            +-----+--------------------+-----------------------+
            """;

    private static String getBookPreviewFormattedOutput(Book book) {
        return String.format("| %3d | %-24s| %-30s| $%-7s|%n"
                        + "+-----+-------------------------+-------------------------------+---------+%n",
                book.getId(), book.getAuthor(), book.getTitle(), book.getPrice());
    }

    public static String getBookFormattedTable(List<Book> books) {
        StringBuilder table = new StringBuilder(bookHeaderRow);
        books.forEach(b -> table.append(getBookPreviewFormattedOutput(b)));
        return table.toString();
    }

    private static String getUserPreviewFormattedOutput(User user) {
        return String.format("| %3d | %-19s| %-22s|%n"
                        + "+-----+--------------------+-----------------------+%n",
                user.getId(), user.getFirstName(), user.getLastName());
    }

    public static String getUserFormattedTable(List<User> users) {
        StringBuilder table = new StringBuilder(userHeaderRow);
        users.forEach(u -> table.append(getUserPreviewFormattedOutput(u)));
        return table.toString();
    }

    private static String getFormattedUser(User user) {
        return user.getFirstName() + " " + user.getLastName();
    }

    private static String getFormattedBook(Book book) {
        return book.getAuthor() + " - " + book.getTitle();
    }

    private static String getOrderPreviewFormattedOutput(Order order) {
        String user = getFormattedUser(order.getUser());
        String book = getFormattedBook(order.getBook());
        return String.format("| %3d | %-11s| %-22s | %-45s | %-3d | $%-10.2f |%n"
                        +
                        "+-----+------------+------------------------+-----------------------------------------------+-----+-------------+%n",
                order.getId(), order.getStatus().getName(), user, book, order.getQuantity(), order.getTotalPrice());
    }

    public static String getOrderFormattedTable(List<Order> orders) {
        StringBuilder table = new StringBuilder(orderHeaderRow);
        orders.forEach(o -> table.append(getOrderPreviewFormattedOutput(o)));
        return table.toString();
    }
}
