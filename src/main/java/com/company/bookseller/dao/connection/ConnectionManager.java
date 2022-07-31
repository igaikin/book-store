package com.company.bookseller.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionManager {
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/bookstore";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "root";
    private static ConnectionManager instance;
    private Connection connection;

    public ConnectionManager() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                log.info("Connection opened");
            } catch (SQLException e) {
                log.error(e);
            }
        }
        return connection;
    }

    public void tearDown() {
        if (connection != null) {
            try {
                connection.close();
                log.info("Connection closed");
                connection = null;
            } catch (SQLException e) {
                log.error(e);
            }
        }
    }
}
