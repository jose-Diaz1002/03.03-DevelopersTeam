package org.escaperoom.model.notification;

public class LoggerObserver implements Observer {

    @Override
    public void update(String eventType, Object data) {
        System.out.println("[LOGGER] Event: " + eventType + ", Data: " + data);
    }
}

