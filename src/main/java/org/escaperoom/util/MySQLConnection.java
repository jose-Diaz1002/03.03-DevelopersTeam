package org.escaperoom.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME ="scape_room_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
    }

    public static Connection getRootConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

