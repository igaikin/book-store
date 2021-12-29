package com.company.bookseller.model.dao.impl;

import com.company.bookseller.model.beans.Book;
import com.company.bookseller.model.dao.BookDao;
import com.company.bookseller.model.dao.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDaoJdbcImpl implements BookDao {
    private static final String GET_ALL =
            "SELECT id, title, author, cover, number_of_pages, price, deleted FROM books WHERE deleted = false";
    private static final String GET_PREVIEW_BOOKS =
            "SELECT id, title, author, price FROM books WHERE deleted = false ORDER BY id";
    private static final String GET_BY_ID =
            "SELECT id, title, author, cover, number_of_pages, price, deleted FROM books WHERE id = ? AND deleted = "
                    + "false";
    private final ConnectionManager connectionManager = ConnectionManager.getInstance();
//    private static final String GET_BY_ORDER_ID =
//            "SELECT id, title, author, cover, order_id, number_of_pages, price, deleted FROM books WHERE   order_id
//            = ? "
//                    + "AND deleted = false";

    private Book processBook(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setAuthor(resultSet.getString("author"));
        book.setTitle(resultSet.getString("title"));
        Book.Cover cover = Book.Cover.valueOf(resultSet.getString("cover"));
        book.setCover(cover);
        book.setNumberOfPages(resultSet.getInt("number_of_pages"));
        book.setPrice(resultSet.getBigDecimal("price"));
        return book;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                books.add(processBook(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Book get(Long id) {
        Book book = null;
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                book = processBook(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public Book create(Book entity) {
        return null;
    }

    @Override
    public Book update(Book entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

}
