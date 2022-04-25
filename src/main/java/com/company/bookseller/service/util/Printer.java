package com.company.bookseller.service.util;

import com.company.bookseller.dao.entity.Book;
import com.company.bookseller.dao.entity.OrderItem;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.service.dto.OrderDto;
import com.company.bookseller.service.dto.UserDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class Printer {

    public static final String LINE_SEPARATOR =
            String.format("+------------------------------------------------------------------------+%n");

    private static String getOrderDataLine(OrderDto orderDto) {
        LocalDateTime time = LocalDateTime.now();
        return String.format("Client: %s     Status: %s    ID: %s"
                        + "Date: %s                    Time: %s %n"
                        + LINE_SEPARATOR,
                getFormattedUser(orderDto.getUser()),
                OrderDto.StatusDto.valueOf(orderDto.getStatus().getName()),
                orderDto.getId(),
                time.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                time.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

    public static final String orderHeaderRow = """
            +-----------------------------------------------------------------------+
            | ID  |                     Book                      | QTY |   Price   |
            +-----+-----------------------------------------------+-----+-----------+
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

    public static String getOrderFormattedOutput(OrderDto orderDto) {
        StringBuilder output = new StringBuilder();
        output.append(Printer.getOrderDataLine(orderDto));
        output.append(Printer.orderHeaderRow);
        orderDto.getItems().forEach(item -> output.append(getItemLine(orderDto, orderDto.getItems(), item())));
        output.append(LINE_SEPARATOR).append(Printer.getTotalLine());
        return output.toString();
    }

    private static String getItemLine(Map<BookDto, Integer> item, OrderItem quantity) {
        String price = getFormattedMoney(bookDto.getItems(BigDecimal.valueOf(item.getPrice()));

        return String.format("|%4s | %-43s|%9d |%9d |%n" + LINE_SEPARATOR,
                getItems(), getItems(), quantity, price);
    }

    private static String getOrderPreviewFormattedOutput(OrderDto orderDto) {
        String user = getFormattedUser(orderDto.getUser());
        String book = getFormattedBook((BookDto) orderDto.getItems());
        return String.format("| %3d | %-11s| %-22s | %-45s | %-3d | $%-10.2f |%n"
                        + "+-----+------------+------------------------+-----------------------------------------------+-----+-------------+%n",
                orderDto.getId(), orderDto.getStatus().getName(), user, book, 1, orderDto.getTotalPrice());
    }

    public static String getOrderFormattedTable(List<OrderDto> orders) {
        StringBuilder table = new StringBuilder(orderHeaderRow);
        orders.forEach(o -> table.append(getOrderPreviewFormattedOutput(o)));
        return table.toString();
    }

    private static String getTotalLine() {
        String total = getFormattedMoney(.getTotalCost());
        return String.format("|                                                  |     TOTAL:%9s |%n"
                + "+--------------------------------------------------+---------------------+%n", total);
    }

    private static String getFormattedUser(UserDto userDto) {
        return userDto.getFirstName() + " " + userDto.getLastName();
    }

    private static String getUserPreviewFormattedOutput(UserDto userDto) {
        return String.format("| %3d | %-19s| %-22s|%n" + "+-----+--------------------+-----------------------+%n",
                userDto.getId(), userDto.getFirstName(), userDto.getLastName());
    }

    public static String getUserFormattedTable(List<UserDto> userDtos) {
        StringBuilder table = new StringBuilder(userHeaderRow);
        userDtos.forEach(u -> table.append(getUserPreviewFormattedOutput(u)));
        return table.toString();
    }

    private static String getFormattedBook(BookDto bookDto) {
        return bookDto.getAuthor() + " - " + bookDto.getTitle();
    }

    private static String getBookPreviewFormattedOutput(BookDto bookDto) {
        return String.format("| %3d | %-24s| %-30s| $%-7s|%n"
                        + "+-----+-------------------------+-------------------------------+---------+%n",
                bookDto.getId(), bookDto.getAuthor(), bookDto.getTitle(), bookDto.getPrice());
    }

    public static String getBookFormattedTable(List<BookDto> bookDtos) {
        StringBuilder table = new StringBuilder(bookHeaderRow);
        bookDtos.forEach(b -> table.append(getBookPreviewFormattedOutput(b)));
        return table.toString();
    }

    private static String getFormattedMoney(BigDecimal price) {
        return "$" + String.format("%.2f", price);
    }
}
