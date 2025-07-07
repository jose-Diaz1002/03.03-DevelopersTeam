package org.escaperoom.model.entity;

import java.time.LocalDateTime;

public class Event {
    private int id;
    private String eventType;
    private String eventDescription;
    private LocalDateTime eventDate;

    public Event() {
    }

    public Event(int id, String eventType, String eventDescription, LocalDateTime eventDate) {
        this.id = id;
        this.eventType = eventType;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", event_type='" + eventType + '\'' +
                ", event_description='" + eventDescription + '\'' +
                ", event_date=" + eventDate +
                '}';
    }
}
