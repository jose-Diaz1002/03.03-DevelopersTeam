package org.escaperoom.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static MySQLConnection instance;
    private Connection connection;

    private final String URL;
    private final String USER;
    private final String PASSWORD;

    private MySQLConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Cargar driver MySQL
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
        }

        // Obtener variables de entorno
        String host = System.getenv("MYSQL_HOST");
        String port = System.getenv("MYSQL_PORT");
        String db = System.getenv("MYSQL_DB");
        USER = System.getenv("MYSQL_USER");
        PASSWORD = System.getenv("MYSQL_PASS");

        // Validar variables de entorno
        if (host == null || port == null || db == null || USER == null || PASSWORD == null) {
            throw new SQLException("MySQL environment variables not set properly");
        }

        URL = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=false&serverTimezone=UTC";

        // Crear conexión
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static synchronized MySQLConnection getInstance() throws SQLException {
        if (instance == null || instance.getConnection() == null || instance.getConnection().isClosed()) {
            instance = new MySQLConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("MySQL connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
