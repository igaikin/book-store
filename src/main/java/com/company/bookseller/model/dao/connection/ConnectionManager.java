package com.company.bookseller.model.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private Connection connection;
    private static ConnectionManager instance;
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/bookstore";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "root";

    public static void main(String[] argv) {

        System.out.println("Testing connection to PostgreSQL JDBC");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;
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
                System.out.println("[LOGGER] connection opened");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void tearDown() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("[LOGGER] connection closed");
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
