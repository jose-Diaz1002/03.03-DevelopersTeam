package org.escaperoom.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
    private static MongoConnection instance;
    private MongoClient mongoClient;
    private MongoDatabase database;

    private final String CONNECTION_STRING = "mongodb://root:root_password@localhost:27018";
    private final String DB_NAME = "escaperoom_logs_db";

    private MongoConnection() {
        mongoClient = MongoClients.create(CONNECTION_STRING);
        database = mongoClient.getDatabase(DB_NAME);
    }

    public static MongoConnection getInstance() {
        if (instance == null) {
            instance = new MongoConnection();
        }
        return instance;
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}