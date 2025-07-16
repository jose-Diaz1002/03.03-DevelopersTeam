package org.escaperoom.model.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoClient;
import org.bson.Document;
import org.escaperoom.model.entity.Room;
import org.escaperoom.model.notification.NotificationObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class NotificationObserverTest {

    private MongoClient mockClient;
    private MongoDatabase mockDatabase;
    private MongoCollection<Document> mockCollection;
    private NotificationObserver observer;

    @BeforeEach
    void setUp() {
        mockClient = mock(MongoClient.class);
        mockDatabase = mock(MongoDatabase.class);
        mockCollection = mock(MongoCollection.class);

        when(mockClient.getDatabase("escaperoom")).thenReturn(mockDatabase);
        when(mockDatabase.getCollection("notifications")).thenReturn(mockCollection);

        observer = new NotificationObserver(mockClient);
    }

    @Test
    void whenRoomCreated_thenInsertNotificationInMongo() {
        Room room = new Room();
        room.setName("Sala Fantástica");
        room.setEscapeRoomId(1);
        room.setPrice(BigDecimal.valueOf(25.0));
        room.setQuantityAvailable(3);

        observer.update("roomCreated", room);

        verify(mockCollection, times(1)).insertOne(argThat(document ->
                document.getString("eventType").equals("roomCreated") &&
                        document.getString("roomName").equals("Sala Fantástica") &&
                        document.getString("timestamp") != null
        ));
    }
}
