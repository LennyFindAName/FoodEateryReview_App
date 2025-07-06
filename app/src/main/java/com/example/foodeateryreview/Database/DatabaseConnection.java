package com.example.foodeateryreview.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:sqlserver://192.168.1.57:1433;databaseName=YourDatabaseName";
    private static final String USER = "YourUsername";
    private static final String PASSWORD = "YourPassword";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}
