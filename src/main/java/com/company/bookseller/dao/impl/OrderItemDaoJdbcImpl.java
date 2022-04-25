package com.company.bookseller.dao.impl;

import com.company.bookseller.dao.OrderItemDao;
import com.company.bookseller.dao.connection.ConnectionManager;
import com.company.bookseller.dao.entity.OrderItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDaoJdbcImpl implements OrderItemDao {
    public static final String GET_ALL = "SELECT oi.id, oi.order_id, oi.book_id, oi.price, oi.quantity FROM "
            + "order_items oi WHERE oi.deleted = false";
    public static final String GET_BY_ORDER_ID = "SELECT oi.id, oi.order_id, oi.book_id, oi.price, oi.quantity FROM "
            + "order_items oi WHERE oi.deleted = false AND oi.order_id = ?";
    public static final String GET_BY_BOOK_ID = "SELECT oi.id, oi.order_id, oi.book_id, oi.price, oi.quantity FROM "
            + "order_items oi WHERE oi.deleted = false AND oi.book_id = ?";
    public static final String GET_BY_ID = "SELECT oi.id, oi.order_id, oi.book_id, oi.price, oi.quantity FROM "
            + "order_items oi WHERE oi.deleted = false AND oi.id = ?";
    private static final String CREATE_ITEM = "INSERT INTO order_items (order_id, book_id, price, quantity) "
            + "VALUES (?, ?, ?, ?)";
    private static final String UPDATE_ITEM = "UPDATE order_items SET order_id = ?, book_id = ?, price = ?, quantity "
            + "= ? AND deleted = false";
    private static final String DELETE_ITEM = "UPDATE order_items SET deleted = true WHERE id = ? AND  deleted = false";
    private final ConnectionManager connectionManager = ConnectionManager.getInstance();

    private OrderItem processItem(ResultSet resultSet) throws SQLException {
        OrderItem item = new OrderItem();
        item.setId(resultSet.getLong("id"));
        item.setOrderId(resultSet.getLong("order_id"));
        item.setBookId(resultSet.getLong("book_id"));
        item.setPrice(resultSet.getBigDecimal("price"));
        item.setQuantity(resultSet.getInt("quantity"));
        return item;
    }

    @Override
    public List<OrderItem> getAll() {
        List<OrderItem> items = new ArrayList<>();
        try {
            Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                items.add(processItem(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public OrderItem get(Long id) {
        OrderItem item = null;
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                item = processItem(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public List<OrderItem> getByBookId(Long bookId) {
        List<OrderItem> items = new ArrayList<>();
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_BOOK_ID);
            statement.setLong(1, bookId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                items.add(processItem(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<OrderItem> getByOrderId(Long orderId) {
        List<OrderItem> items = new ArrayList<>();
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_ORDER_ID);
            statement.setLong(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                items.add(processItem(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public OrderItem create(OrderItem item) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(CREATE_ITEM, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, item.getOrderId());
            statement.setLong(2, item.getBookId());
            statement.setBigDecimal(3, item.getPrice());
            statement.setInt(4, item.getQuantity());
            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                item.setId(keys.getLong(1));
                return item;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Couldn't create object: " + item);
    }

    @Override
    public OrderItem update(OrderItem item) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_ITEM);
            statement.setLong(1, item.getOrderId());
            statement.setLong(2, item.getBookId());
            statement.setBigDecimal(3, item.getPrice());
            statement.setInt(4, item.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean delete(Long id) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_ITEM);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
