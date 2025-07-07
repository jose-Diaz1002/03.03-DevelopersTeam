package org.escaperoom.model.entity;

public class Subscription {
    private int id;
    private int playerId;
    private String eventTypeSubscribed;

    public Subscription() {
    }

    public Subscription(int id, int playerId, String eventTypeSubscribed) {
        this.id = id;
        this.playerId = playerId;
        this.eventTypeSubscribed = eventTypeSubscribed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getEventTypeSubscribed() {
        return eventTypeSubscribed;
    }

    public void setEventTypeSubscribed(String eventTypeSubscribed) {
        this.eventTypeSubscribed = eventTypeSubscribed;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", player_id=" + playerId +
                ", event_type_subscribed='" + eventTypeSubscribed + '\'' +
                '}';
    }
}
