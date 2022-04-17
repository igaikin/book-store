package com.company.bookseller.service.util;

import com.company.bookseller.service.dto.OrderDto;
import com.company.bookseller.service.dto.BookDto;
import com.company.bookseller.service.dto.UserDto;

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

    private static String getUserPreviewFormattedOutput(UserDto userDto) {
        return String.format("| %3d | %-19s| %-22s|%n" + "+-----+--------------------+-----------------------+%n",
                userDto.getId(), userDto.getFirstName(), userDto.getLastName());
    }

    public static String getUserFormattedTable(List<UserDto> userDtos) {
        StringBuilder table = new StringBuilder(userHeaderRow);
        userDtos.forEach(u -> table.append(getUserPreviewFormattedOutput(u)));
        return table.toString();
    }

    private static String getFormattedUser(UserDto userDto) {
        return userDto.getFirstName() + " " + userDto.getLastName();
    }

    private static String getFormattedBook(BookDto bookDto) {
        return bookDto.getAuthor() + " - " + bookDto.getTitle();
    }

    private static String getOrderPreviewFormattedOutput(OrderDto orderDto) {
        String user = getFormattedUser(orderDto.getUser());
        String book = getFormattedBook(new BookDto()); //FIXME
        return String.format("| %3d | %-11s| %-22s | %-45s | %-3d | $%-10.2f |%n"
                + "+-----+------------+------------------------+-----------------------------------------------+-----+-------------+%n",
                orderDto.getId(), orderDto.getStatus().getName(), user, book, 1, orderDto.getTotalPrice());
    }

    public static String getOrderFormattedTable(List<OrderDto> orders) {
        StringBuilder table = new StringBuilder(orderHeaderRow);
        orders.forEach(o -> table.append(getOrderPreviewFormattedOutput(o)));
        return table.toString();
    }
}
