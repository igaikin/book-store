package com.company.bookseller.model.dao.impl;

import com.company.bookseller.model.beans.User;
import com.company.bookseller.model.dao.UserDao;
import com.company.bookseller.model.dao.connection.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {
    private static final String CREATE_USER =
            "INSERT INTO users  (first_name, last_name, role_id, email, password)"
                    + "VALUES (?, ?, (SELECT id FROM roles WHERE role = ?), ?, ?)";
    private static final String UPDATE_USER =
            "UPDATE users SET first_name = ?, last_name = ?, role_id = ?, email = ?, password = ?"
                    + "WHERE id = ? AND deleted = false";
    private static final String DELETE_USER = "UPDATE users SET deleted = true WHERE id = ? AND  deleted = false";
    private static final String USER_ALL = "SELECT u.id, u.first_name, u.last_name, r.role, u.email, u.password "
            + "FROM users u JOIN roles r ON u.role_id = r.id ";
    private static final String GET_ALL = USER_ALL + "WHERE u.deleted = false ORDER BY u.id";
    private static final String GET_BY_ID = USER_ALL + "WHERE u.id = ? AND u.deleted = false ORDER BY u.id";
    private final ConnectionManager connectionManager = ConnectionManager.getInstance();

    private User processUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setRole(User.Role.valueOf(resultSet.getString("role")));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
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
    public User get(Long id) {
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
    public User create(User user) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_USER);
            statement.setLong(1, user.getId());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, String.valueOf(user.getRole()));
            statement.setString(5, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("User created");
        return user;
    }

    @Override
    public User update(User user) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER);
            statement.setLong(1, user.getId());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, String.valueOf(user.getRole()));
            statement.setString(5, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("User updated");
        return user;
    }

    @Override
    public boolean delete(Long id) {
        try {
            Connection connection = connectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_USER);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("User deleted");
        return true;
    }
}
