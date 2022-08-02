package com.company.bookseller.dao.impl;

import com.company.bookseller.dao.entity.Book;
import com.company.bookseller.dao.BookDao;
import com.company.bookseller.dao.connection.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;

import static com.company.bookseller.service.util.paging.PagingUtil.totalCounter;

@Log4j2
public class BookDaoJdbcImpl implements BookDao {
    private static final String CREATE_BOOK =
            "INSERT INTO books (image, author, title, cover_id, pages, isbn, price)"
                    + "VALUES (?, ?, ?, (SELECT id FROM covers WHERE cover = ?), ?, ?, ?)";
    private static final String UPDATE_BOOK =
            "UPDATE books SET image = ?, author = ?, title = ?, cover_id = (SELECT id FROM covers WHERE cover = ?), "
                    + "pages =?, isbn = ?, price = ? WHERE id = ? AND deleted = false";
    private static final String DELETE_BOOK = "UPDATE books SET deleted = true WHERE id = ? AND  deleted = false";
    private static final String BOOK_ALL =
            "SELECT b.id, b.image, b.title, b.author, c.cover, b.pages, b.isbn, b.price, b.deleted "
                    + "FROM books b JOIN covers c ON b.cover_id = c.id ";
    private static final String GET_ALL_PAGED = BOOK_ALL + "WHERE b.deleted = false ORDER BY b.id LIMIT ? OFFSET ?";
    private static final String SEARCH = BOOK_ALL + "WHERE b.deleted = false AND b.title ILIKE ? ORDER BY b.id LIMIT "
            + "? OFFSET ?";
    private static final String GET_BY_ID = BOOK_ALL + "WHERE b.id = ? AND deleted = false ORDER BY b.id";
    private static final String GET_BY_ISBN = BOOK_ALL + "WHERE b.isbn = ? AND b.deleted = false ORDER BY b.isbn";
    private static final String GET_BY_ORDER_ID = BOOK_ALL + "WHERE order_id = ?";
    private static final String GET_BY_USER_ID = BOOK_ALL + "WHERE user_id = ?";
    private static final String COUNT = "SELECT count(*) AS total FROM books";
    private final ConnectionManager connectionManager;

    public BookDaoJdbcImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    private Book processBook(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setImage(resultSet.getString("image"));
        book.setAuthor(resultSet.getString("author"));
        book.setTitle(resultSet.getString("title"));
        book.setCover(Book.Cover.valueOf(resultSet.getString("cover")));
        book.setPages(resultSet.getInt("pages"));
        book.setIsbn(resultSet.getString("isbn"));
        book.setPrice(resultSet.getBigDecimal("price"));
        return book;
    }

    @Override
    public List<Book> getAll(int limit, int offset) {
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_ALL_PAGED);
            statement.setInt(1, limit);
            statement.setInt(2, offset);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                books.add(processBook(resultSet));
            }
        } catch (SQLException e) {
            log.error(e);
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
            log.error(e);
        }
        return book;
    }

    @Override
    public List<Book> search(String search, int limit, int offset) {
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(SEARCH);
            statement.setString(1, "%" + search + "%");
            statement.setInt(2, limit);
            statement.setInt(3, offset);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                books.add(processBook(resultSet));
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return books;
    }

    @Override
    public long count() {
        return totalCounter(connectionManager, COUNT, log);
    }

    @Override
    public Book getByIsbn(String isbn) {
        Book book = null;
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_ISBN);
            statement.setString(1, isbn);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                book = processBook(resultSet);
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return book;
    }


    public List<Book> getByOrderId(Long orderId) {
        return getBookByParam(orderId, GET_BY_ORDER_ID);
    }

    public List<Book> getByUserId(Long userId) {
        return getBookByParam(userId, GET_BY_USER_ID);
    }

    private List<Book> getBookByParam(Long paramId, String sql) {
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, paramId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                books.add(processBook(resultSet));
            }
        } catch (SQLException e) {
            log.error(e);
        }
        return books;
    }

    @Override
    public Book create(Book book) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_BOOK, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, book.getImage());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getTitle());
            statement.setString(4, String.valueOf(book.getCover()));
            statement.setInt(5, book.getPages());
            statement.setString(6, book.getIsbn());
            statement.setBigDecimal(7, book.getPrice());
            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                book.setId(keys.getLong(1));
                return book;
            }
        } catch (SQLException e) {
            log.error(e);
        }
        throw new RuntimeException("Couldn't create object: " + book);
    }

    @Override
    public Book update(Book book) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK);
            statement.setString(1, book.getImage());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getTitle());
            statement.setString(4, String.valueOf(book.getCover()));
            statement.setInt(5, book.getPages());
            statement.setString(6, book.getIsbn());
            statement.setBigDecimal(7, book.getPrice());
            statement.setLong(8, book.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error(e);
        }
        return book;
    }

    @Override
    public boolean delete(Long id) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_BOOK);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error(e);
        }
        return true;
    }
}
