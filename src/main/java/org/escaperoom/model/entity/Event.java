package org.escaperoom.model.entity;

import java.time.LocalDateTime;

public class Event {
private int id;
private String event_type;
private String event_description;
private LocalDateTime event_date;

    public Event() {
    }

    public Event(int id, String event_type, String event_description, LocalDateTime event_date) {
        this.id = id;
        this.event_type = event_type;
        this.event_description = event_description;
        this.event_date = event_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public LocalDateTime getEvent_date() {
        return event_date;
    }

    public void setEvent_date(LocalDateTime event_date) {
        this.event_date = event_date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", event_type='" + event_type + '\'' +
                ", event_description='" + event_description + '\'' +
                ", event_date=" + event_date +
                '}';
    }
}
