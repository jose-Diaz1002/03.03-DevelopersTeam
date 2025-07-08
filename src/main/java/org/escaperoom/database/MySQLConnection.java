package org.escaperoom.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static MySQLConnection instance;
    private Connection connection;
/*

    private static final String HOST = System.getenv().getOrDefault("MYSQL_HOST", "127.0.0.1");
    private static final String PORT = System.getenv().getOrDefault("MYSQL_PORT", "3307");
    private static final String DB_NAME = System.getenv().getOrDefault("MYSQL_DB", "virtual_escaperoom_db");
    private static final String USER = System.getenv().getOrDefault("MYSQL_USER", "root");
    private static final String PASSWORD = System.getenv().getOrDefault("MYSQL_PASS", "root123");
*/
private static final String HOST = "localhost";
    private static final String PORT = "3307";
    private static final String DB_NAME = "virtual_escaperoom_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root123";


    private static final String URL = String.format(
            "jdbc:mysql://%s:%s/%s?useSSL=false&allowPublicKeyRetrieval=true",
            HOST, PORT, DB_NAME);

    // Constructor privado para evitar instancias externas
    private MySQLConnection() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para obtener la única instancia de MySQLConnection
    public static synchronized MySQLConnection getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new MySQLConnection();
        }
        return instance;
    }

    // Método para obtener la conexión
    public Connection getConnection() {
        return connection;
    }
}
