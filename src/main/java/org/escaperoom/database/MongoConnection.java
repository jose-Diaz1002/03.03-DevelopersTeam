package org.escaperoom.database;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.Collections;

public class MongoConnection {
    private static MongoConnection instance;
    private MongoClient mongoClient;
    private MongoDatabase database;

    private static final String HOST = System.getenv().getOrDefault("MONGO_HOST", "localhost");
    private static final int PORT = Integer.parseInt(System.getenv().getOrDefault("MONGO_PORT", "27017"));
    private static final String DB_NAME = System.getenv().getOrDefault("MONGO_DB", "escaperoom_logs_db");
    private static final String USERNAME = System.getenv().getOrDefault("MONGO_USER", "appuser");
    private static final String PASSWORD = System.getenv().getOrDefault("MONGO_PASSWORD", "app_pass");

    private MongoConnection() {
        MongoCredential credential = MongoCredential.createCredential(USERNAME, DB_NAME, PASSWORD.toCharArray());

        mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .credential(credential)
                        .applyToClusterSettings(builder ->
                                builder.hosts(Collections.singletonList(new ServerAddress(HOST, PORT))))
                        .build()
        );

        database = mongoClient.getDatabase(DB_NAME);
    }

    public static synchronized MongoConnection getInstance() {
        if (instance == null) {
            instance = new MongoConnection();
        }
        return instance;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
