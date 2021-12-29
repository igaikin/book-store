package com.company.bookseller.model.dao.impl;

import com.company.bookseller.model.beans.entities.User;
import com.company.bookseller.model.dao.UserDao;
import com.company.bookseller.model.dao.connection.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
    private final ConnectionManager connectionManager = ConnectionManager.getInstance();
    private static final String GET_ALL =
            "SELECT u.id, u.first_name, u.last_name, u.role, u.email, u.password FROM users u WHERE deleted = false";
    private static final String GET_BY_ID =
            "SELECT u.id, u.first_name, u.last_name, u.role, u.email, u.password FROM users u WHERE id = ? AND "
                    + "deleted = false";
    private static final String GET_BY_ORDER_ID =
            "SELECT u.id, u.first_name, u.last_name, u.role, u.email, u.password FROM users u WHERE order_id = ? AND "
                    + "deleted = false";

    private User processUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        User.Role role = User.Role.valueOf(resultSet.getString("role"));
        user.setRole(role);
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new LinkedList<>();
        try {
            Connection connection = connectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()) {
                users.add(processUser(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getById(long id) {
        User user = null;
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = processUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getByOrderId(long orderId) {
        User user = null;
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_ORDER_ID);
            statement.setLong(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = processUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
