package com.company.bookseller.dao.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final Logger LOG = LogManager.getLogger(ConnectionManager.class);
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/bookstore";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "root";
    private static ConnectionManager instance;
    private Connection connection;

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
                LOG.info("Connection opened");
            } catch (SQLException e) {
                LOG.error(e);
            }
        }
        return connection;
    }

    public void tearDown() {
        if (connection != null) {
            try {
                connection.close();
                LOG.info("Connection closed");
                connection = null;
            } catch (SQLException e) {
                LOG.error(e);
            }
        }
    }
}
