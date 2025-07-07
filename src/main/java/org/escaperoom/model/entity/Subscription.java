package org.escaperoom.model.entity;

public class Subscription {
    private int id;
    private int player_id;
    private String event_type_subscribed;

    public Subscription() {
    }

    public Subscription(int id, int player_id, String event_type_subscribed) {
        this.id = id;
        this.player_id = player_id;
        this.event_type_subscribed = event_type_subscribed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public String getEvent_type_subscribed() {
        return event_type_subscribed;
    }

    public void setEvent_type_subscribed(String event_type_subscribed) {
        this.event_type_subscribed = event_type_subscribed;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", player_id=" + player_id +
                ", event_type_subscribed='" + event_type_subscribed + '\'' +
                '}';
    }
}
