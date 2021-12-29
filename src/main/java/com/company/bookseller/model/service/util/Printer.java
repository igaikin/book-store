package com.company.bookseller.model.service.util;

import com.company.bookseller.model.beans.Book;
import com.company.bookseller.model.beans.User;

import java.util.List;

public class Printer {
    private static final String bookHeaderRow = """
            +-------------------------------------------------------------------------+
            |  ID |          Author         |             Title             |  Price  |
            +-----+-------------------------+-------------------------------+---------+
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

    public static String getUserFormattedTable(List<User> users) {//FIXME
        throw new UnsupportedOperationException();
    }
}
