package com.company.bookseller.model.dao.impl;

import com.company.bookseller.model.beans.order.Order;
import com.company.bookseller.model.dao.OrderDao;
import com.company.bookseller.model.dao.connection.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoJdbcImpl implements OrderDao {
    private final ConnectionManager connectionManager = ConnectionManager.getInstance();
    private static final String GET_ALL =
            "SELECT o.id, o.status, o.total_price FROM orders o WHERE deleted = false";
    private static final String GET_BY_ID =
            "SELECT o.id, o.status, o.total_price FROM orders o WHERE id = ? AND deleted = false";
    private static final String GET_BY_BOOK_ID =
            "SELECT o.id, o.status, o.total_price FROM orders o JOIN books b on o.id = b.order_id WHERE b.id = ?";
    private static final String GET_BY_USER_ID =
            "SELECT o.id, o.status, o.total_price FROM orders o JOIN users u on o.id = u.order_id WHERE u.id = ?";

    private Order processOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getLong("id"));
        Order.Status status = Order.Status.valueOf(resultSet.getString("status"));
        Order.setStatus(status);
        order.setTotalPrice(resultSet.getBigDecimal("total_price"));
        order.setDeleted(resultSet.getBoolean("deleted"));

        return order;
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

    @Override
    public Order getById(long id) {
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

    public List<Order> getByBookId(long bookId) {
        return getOrder(bookId, GET_BY_BOOK_ID);
    }

    public List<Order> getByUserId(long userId) {
        return getOrder(userId, GET_BY_USER_ID);
    }

    private List<Order> getOrder(long userId, String getByUserId) {
        List<Order> orders = new ArrayList<>();
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(getByUserId);
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
