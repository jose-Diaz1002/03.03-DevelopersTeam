package org.escaperoom.model.notification;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    protected void notifyObservers(String eventType, Object data) {
        for (Observer o : observers) {
            o.update(eventType, data);
        }
    }
}

