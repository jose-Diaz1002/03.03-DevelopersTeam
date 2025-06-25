package org.escaperoom.service.interfaces;

import org.escaperoom.model.User;

public interface NotificationService {
    void subscribe(User user);
    void unsubscribe(User user);
    void notifyAll(String message);
}
