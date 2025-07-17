package org.escaperoom.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static MySQLConnection instance;
    private Connection connection;

    private static final String HOST = System.getenv().getOrDefault("MYSQL_HOST", "localhost");
    private static final String PORT = System.getenv().getOrDefault("MYSQL_PORT", "3307");
    private static final String DB_NAME = System.getenv().getOrDefault("MYSQL_DB", "virtual_escaperoom_db");
    private static final String USER = System.getenv().getOrDefault("MYSQL_USER", "root");
    private static final String PASSWORD = System.getenv().getOrDefault("MYSQL_PASSWORD", "root123");

    private static final String URL = String.format(
            "jdbc:mysql://%s:%s/%s?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
            HOST, PORT, DB_NAME);

    public MySQLConnection() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static synchronized MySQLConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new MySQLConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new MySQLConnection();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}
