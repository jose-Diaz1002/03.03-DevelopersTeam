package org.escaperoom.database;


import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.Collections;

public class MongoConnectionTest {

    public static void main(String[] args) {
        String host = System.getenv().getOrDefault("MONGO_HOST", "localhost");
        int port = Integer.parseInt(System.getenv().getOrDefault("MONGO_PORT", "27017"));
        String dbName = System.getenv().getOrDefault("MONGO_DB", "virtual_escaperoom_logs");

        System.out.println("Testing MongoDB connection with:");
        System.out.println("HOST: " + host);
        System.out.println("PORT: " + port);
        System.out.println("DB NAME: " + dbName);

        try (MongoClient mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyToClusterSettings(builder ->
                                builder.hosts(Collections.singletonList(new ServerAddress(host, port))))
                        .build())) {

            MongoDatabase database = mongoClient.getDatabase(dbName);

            // Simple command to check connection, e.g., list collections
            System.out.println("Collections in database:");
            database.listCollectionNames().forEach(System.out::println);

            System.out.println("Connection successful!");

        } catch (Exception e) {
            System.err.println("Connection failed:");
            e.printStackTrace();
        }
    }
}
