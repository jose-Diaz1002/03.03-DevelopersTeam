package org.escaperoom.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {

    private static MongoConnection instance;
    private final MongoClient mongoClient;
    private final MongoDatabase database;

    private static final String DEFAULT_URI = "mongodb://root:root_password@localhost:27018";
    private static final String DEFAULT_DB = "escaperoom_logs_db";

    private MongoConnection() {
        String uri = System.getenv().getOrDefault("MONGO_URI", DEFAULT_URI);
        String dbName = System.getenv().getOrDefault("MONGO_DB", DEFAULT_DB);

        this.mongoClient = MongoClients.create(uri);
        this.database = mongoClient.getDatabase(dbName);
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
}
