package org.escaperoom.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {private static Connection connection;

    private MySQLConnection() { }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String host = System.getenv().getOrDefault("MYSQL_HOST", "localhost");
            String port = System.getenv().getOrDefault("MYSQL_PORT", "3306");
            String db = System.getenv().getOrDefault("MYSQL_DB", "escaperoom_db");
            String user = System.getenv().getOrDefault("MYSQL_USER", "root");
            String pass = System.getenv().getOrDefault("MYSQL_PASS", "");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=false&serverTimezone=UTC";
            connection = DriverManager.getConnection(url, user, pass);
        }
        return connection;
    }
}
