package org.escaperoom.model.notification;

public interface Observer {
    void update(String eventType, Object data);
}
