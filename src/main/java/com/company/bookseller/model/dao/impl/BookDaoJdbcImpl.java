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
    private static final String CREATE_BOOK =
            "INSERT INTO books  (id, title, author, cover_id, number_of_pages, price) "
            + "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_BOOK =
            "UPDATE books SET author = ?, title = ?, cover_id = ?, number_of_pages =?, price = ?"
                    + "WHERE id = ? AND deleted = false";
    private static final String DELETE_BOOK = "UPDATE books SET deleted = true WHERE id = ? AND  deleted = false";
    private static final String BOOK_ALL =
            "SELECT b.id, b.title, b.author, c.cover, b.number_of_pages, b.price, b.deleted "
                    + "FROM books b JOIN covers c ON b.cover_id = c.id";
    private static final String GET_ALL = BOOK_ALL + " WHERE b.deleted = false ORDER BY b.id";
    private static final String GET_BY_ID = BOOK_ALL + " WHERE b.id = ? AND deleted = false ORDER BY b.id";
    private final ConnectionManager connectionManager = ConnectionManager.getInstance();
//    private static final String GET_BY_ORDER_ID =
//            "SELECT id, title, author, cover, order_id, number_of_pages, price, deleted FROM books
//            WHERE order_id = ? AND deleted = false";

    private Book processBook(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setAuthor(resultSet.getString("author"));
        book.setTitle(resultSet.getString("title"));
        book.setCover(Book.Cover.valueOf(resultSet.getString("cover")));
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
    public Book create(Book book) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_BOOK);;
            statement.setString(2,book.getAuthor());
            statement.setString(3, book.getTitle());
            statement.setString(4, String.valueOf(book.getCover()));
            statement.setInt(5, book.getNumberOfPages());
            statement.setBigDecimal(6, book.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public Book update(Book book) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK);
            statement.setString(2,book.getAuthor());
            statement.setString(3, book.getTitle());
            statement.setString(4, String.valueOf(book.getCover()));
            statement.setInt(5, book.getNumberOfPages());
            statement.setBigDecimal(6, book.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public boolean delete(Long id) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_BOOK);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
