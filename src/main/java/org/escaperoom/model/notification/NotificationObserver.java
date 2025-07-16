package org.escaperoom.model.notification;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.escaperoom.model.entity.Room;

import java.time.LocalDateTime;

public class NotificationObserver implements Observer {

    private final MongoCollection<Document> notificationCollection;

    public NotificationObserver(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("escaperoom");
        this.notificationCollection = database.getCollection("notifications");
    }

    @Override
    public void update(String eventType, Object data) {
        if ("roomCreated".equals(eventType) && data instanceof Room room) {
            String message = "New room created: " + room.getName();
            System.out.println("[NOTIFICATION] " + message);

            Document notification = new Document()
                    .append("eventType", eventType)
                    .append("roomName", room.getName())
                    .append("timestamp", LocalDateTime.now().toString());

            notificationCollection.insertOne(notification);
        }
    }
}
