package com.company.bookseller.model.dao.impl;

import com.company.bookseller.model.beans.entities.Book;
import com.company.bookseller.model.dao.BookDao;
import com.company.bookseller.model.dao.connection.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class BookDaoJdbcImpl implements BookDao {
    private final ConnectionManager connectionManager = ConnectionManager.getInstance();
    private static final String GET_ALL =
            "SELECT id, title, author, cover, number_of_pages, price, deleted FROM books WHERE deleted = false";
    private static final String GET_PREVIEW_BOOKS =
            "SELECT id, title, author, price FROM books WHERE deleted = false";
    private static final String GET_BY_ID =
            "SELECT id, title, author, cover, number_of_pages, price, deleted FROM books WHERE id = ? AND deleted = false";
    private static final String GET_BY_ORDER_ID =
            "SELECT id, title, author, cover, order_id, number_of_pages, price, deleted FROM books WHERE   order_id = ? "
                    + "AND deleted = false";

    private Book processBook(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setAuthor(resultSet.getString("author"));
        book.setTitle(resultSet.getString("title"));
        Book.Cover cover = Book.Cover.valueOf(resultSet.getString("cover"));
        book.setCover(cover);
        book.setNumberOfPages(resultSet.getInt("number_of_pages"));
        book.setPrice(resultSet.getBigDecimal("price"));
        book.setDeleted(resultSet.getBoolean("deleted"));
        return book;
    }

    private Book processPreviewBook(ResultSet resultSet) throws SQLException {
        Book bookPreview = new Book();
        bookPreview.setId(resultSet.getLong("id"));
        bookPreview.setAuthor(resultSet.getString("author"));
        bookPreview.setTitle(resultSet.getString("title"));
        bookPreview.setPrice(resultSet.getBigDecimal("price"));
        return bookPreview;
    }

    @Override
    public List<Book> getPreviewBooks() {
        List<Book> previewBooks = new ArrayList<>();
        try {
            Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_PREVIEW_BOOKS);
            while (resultSet.next()) {
                previewBooks.add(processPreviewBook(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return previewBooks;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new LinkedList<>();
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
    public Book getById(long id) {
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
    public List<Book> getByOrderId(long orderId) {
        List<Book> books = new LinkedList<>();
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_ORDER_ID);
            statement.setLong(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                books.add(processBook(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
