package com.company.bookseller.model.dao.impl;

import com.company.bookseller.model.beans.Book;
import com.company.bookseller.model.beans.Order;
import com.company.bookseller.model.beans.Order.Status;
import com.company.bookseller.model.beans.User;
import com.company.bookseller.model.dao.OrderDao;
import com.company.bookseller.model.dao.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoJdbcImpl implements OrderDao {
    private static final String ORDERS_ALL =
            "SELECT o.id, o.status, o.quantity, o.user_id, o.book_id, o.total_price FROM orders o ";
    private static final String GET_ALL = ORDERS_ALL + "WHERE deleted = false";
    private static final String GET_BY_ID = ORDERS_ALL + "WHERE id = ? AND deleted = false";
    private static final String GET_BY_BOOK_ID =
            "SELECT o.id, o.status, o.total_price FROM orders o JOIN books b on o.id = b.order_id WHERE b.id = ?";
    private static final String GET_BY_USER_ID =
            "SELECT o.id, o.status, o.total_price FROM orders o JOIN users u on o.id = u.order_id WHERE u.id = ?";
    private final ConnectionManager connectionManager = ConnectionManager.getInstance();

    private Order processOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getLong("id"));
        order.setStatus(Status.valueOf(resultSet.getString("status")));
        order.setQuantity(resultSet.getInt("quantity"));
        order.setUser(getUser(resultSet));
        order.setBook(getBook(resultSet));
        order.setTotalPrice(resultSet.getBigDecimal("total_price"));
        return order;
    }

    private Book getBook(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("book_id"));
        return book;
    }

    private User getUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("user_id"));
        return user;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        try {
            Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                orders.add(processOrder(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<Order> getByBookId(long bookId) {
        return getOrder(bookId, GET_BY_BOOK_ID);
    }

    @Override
    public Order get(Long id) {
        Order order = null;
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                order = processOrder(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public Order create(Order entity) {
        return null;
    }

    @Override
    public Order update(Order entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    public List<Order> getByUserId(long userId) {
        return getOrder(userId, GET_BY_USER_ID);
    }

    private List<Order> getOrder(long userId, String sql) {
        List<Order> orders = new ArrayList<>();
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(processOrder(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
