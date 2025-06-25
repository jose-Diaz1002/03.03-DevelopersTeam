package org.escaperoom.service.impl;

import org.escaperoom.model.User;
import org.escaperoom.service.interfaces.NotificationService;

import java.util.HashSet;
import java.util.Set;

public class NotificationServiceImpl implements NotificationService {

    private static NotificationServiceImpl instance;

    //TODO: Implement Singleton pattern, valorar si usar una lista en vez de un set.
    private Set<User> subscribers = new HashSet<>();

    private NotificationServiceImpl() {}

    public static NotificationServiceImpl getInstance() {
        if (instance == null) {
            instance = new NotificationServiceImpl();
        }
        return instance;
    }
    @Override
    public void subscribe(User user) {

    }

    @Override
    public void unsubscribe(User user) {

    }

    @Override
    public void notifyAll(String message) {
        for (User user : subscribers) {
           // user.update(message); // Método Observer
        }
    }
}
