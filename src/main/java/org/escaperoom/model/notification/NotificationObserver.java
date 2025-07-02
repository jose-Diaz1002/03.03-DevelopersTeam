package org.escaperoom.model.notification;

public class NotificationObserver implements Observer {

    @Override
    public void update(String eventType, Object data) {
        if (eventType.equals("achievementCompleted")) {
            System.out.println("[NOTIFICATION] Congrats! Achievement unlocked: " + data);
        }
    }
}

