package org.escaperoom.database;

import com.mongodb.client.MongoDatabase;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    public enum DBType {
        MYSQL,
        MONGODB
    }

    // Método para MySQL (devuelve Connection)
    public static Connection getMySQLConnection() throws SQLException {
        return MySQLConnection.getInstance().getConnection();
    }

    // Método para MongoDB (devuelve MongoDatabase)
    public static MongoDatabase getMongoDatabase() {
        return MongoConnection.getInstance().getDatabase();
    }
}
