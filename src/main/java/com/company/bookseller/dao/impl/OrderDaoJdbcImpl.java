package com.company.bookseller.dao.impl;

import com.company.bookseller.dao.OrderDao;
import com.company.bookseller.dao.connection.ConnectionManager;
import com.company.bookseller.dao.entity.Order;
import com.company.bookseller.dao.entity.Order.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoJdbcImpl implements OrderDao {
    private static final String CREATE_ORDER =
            "INSERT INTO orders  (date, status_id, user_id, total_price)"
                    + "VALUES (?, (SELECT id FROM statuses WHERE status = ?), ?, ?)";
    private static final String UPDATE_ORDER =
            "UPDATE orders SET date = ?, status_id = (SELECT id FROM statuses WHERE status = ?), user_id = ?, "
                    + "total_price = ? WHERE id = ?";
    private static final String ORDERS_ALL = "SELECT o.id, o.date, s.status, o.user_id, o.total_price "
            + "FROM orders o JOIN statuses s ON o.status_id = s.id";
    private static final String GET_ALL = ORDERS_ALL + " ORDER BY o.id";
    private static final String GET_BY_ID = ORDERS_ALL + " WHERE o.id = ? ORDER BY o.id";
    private static final String GET_BY_USER_ID = ORDERS_ALL + " WHERE user_id = ?";
    private static final String DELETE_ORDER = "UPDATE orders SET status_id = (SELECT id FROM statuses WHERE status = 'CANCELLED')"
            + " WHERE id = ?";

    private final ConnectionManager connectionManager = ConnectionManager.getInstance();

    private Order processOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getLong("id"));
        order.setOrderDateTime(resultSet.getTimestamp("date").toLocalDateTime());
        order.setStatus(Status.valueOf(resultSet.getString("status")));
        order.setUserId(resultSet.getLong("user_id"));
        order.setTotalPrice(resultSet.getBigDecimal("total_price"));
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
    public Order create(Order order) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_ORDER, Statement.RETURN_GENERATED_KEYS);
            statement.setTimestamp(1, Timestamp.valueOf(order.getOrderDateTime()));
            statement.setString(2, String.valueOf(order.getStatus()));
            statement.setLong(3, order.getUserId());
            statement.setBigDecimal(4, order.getTotalPrice());
            statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                order.setId(keys.getLong(1));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Couldn't create object: " + order);
    }

    @Override
    public Order update(Order order) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER);
            statement.setTimestamp(1, Timestamp.valueOf(order.getOrderDateTime()));
            statement.setString(2, String.valueOf(order.getStatus()));
            statement.setLong(3, order.getUserId());
            statement.setBigDecimal(4, order.getTotalPrice());
            statement.setLong(5, order.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public boolean delete(Long id) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_ORDER);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<Order> getByUserId(Long userId) {
        return getOrderByParam(userId, GET_BY_USER_ID);
    }

    private List<Order> getOrderByParam(Long paramId, String sql) {
        List<Order> orders = new ArrayList<>();
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, paramId);
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
