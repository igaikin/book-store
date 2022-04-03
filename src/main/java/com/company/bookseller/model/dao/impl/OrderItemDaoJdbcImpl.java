package com.company.bookseller.model.dao.impl;

import com.company.bookseller.model.dao.OrderItemDao;
import com.company.bookseller.model.dao.connection.ConnectionManager;
import com.company.bookseller.model.entity.OrderItem;
import com.company.bookseller.model.entity.User;

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
    public static final String GET_BY_ID = "SELECT oi.id, oi.order_id, oi.book_id, oi.price, oi.quantity FROM "
            + "order_items oi WHERE oi.deleted = false AND oi.id = ?";
    private final ConnectionManager connectionManager = ConnectionManager.getInstance();

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
    public OrderItem create(OrderItem entity) {
        return null;
    }

    @Override
    public OrderItem update(OrderItem entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
