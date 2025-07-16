package org.escaperoom.model.entity;

import org.bson.types.ObjectId;

public class Subscription {
    private ObjectId _id;          // ID interno de MongoDB
    private String clientEmail;    // Identificador propio (clave natural)
    private String name;
    private String surnames;
    //private int playerId;
    //private String eventTypeSubscribed;

    public Subscription() {
    }

    public Subscription(String clientEmail, String name, String surnames) {
        this.clientEmail = clientEmail;
        this.name = name;
        this.surnames = surnames;
        //this.playerId = playerId;
        //this.eventTypeSubscribed = eventTypeSubscribed;
    }

    // Getters y Setters

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    /*public int getPlayerId() {
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
    }*/

    @Override
    public String toString() {
        return "Subscription{" +
                "_id=" + (_id != null ? _id.toHexString() : "null") +
                ", clientEmail='" + clientEmail + '\'' +
                ", name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
               '}';
    }
}
