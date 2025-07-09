package org.escaperoom.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

    // === MySQL ===
    public static Connection getMySQLConnection() throws SQLException {
        String host = System.getenv().getOrDefault("MYSQL_HOST", "localhost");
        String port = System.getenv().getOrDefault("MYSQL_PORT", "3306");
        String dbName = System.getenv().getOrDefault("MYSQL_DB", "virtual_escaperoom_db");
        String user = System.getenv().getOrDefault("MYSQL_USER", "root");
        String pass = System.getenv().getOrDefault("MYSQL_PASSWORD", "");

        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?useSSL=false&serverTimezone=UTC";

        return DriverManager.getConnection(url, user, pass);
    }

    // === MongoDB ===
    public static MongoDatabase getMongoDatabase() {
        String host = System.getenv().getOrDefault("MONGO_HOST", "localhost");
        String port = System.getenv().getOrDefault("MONGO_PORT", "27017");
        String dbName = System.getenv().getOrDefault("MONGO_DB", "virtual_escaperoom_logs");

        String uri = "mongodb://" + host + ":" + port;
        MongoClient mongoClient = MongoClients.create(uri);
        return mongoClient.getDatabase(dbName);
    }
}
