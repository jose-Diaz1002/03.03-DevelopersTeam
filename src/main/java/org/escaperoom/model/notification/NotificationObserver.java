package org.escaperoom.model.notification;

public class qNotificationObserver implements Observer {

    @Override
    public void update(String eventType, Object data) {
        if ("roomCreated".equals(eventType) && data instanceof Room room) {
            System.out.println("[NOTIFICATION] New room created: " + room.getName());
        }
    }
}

