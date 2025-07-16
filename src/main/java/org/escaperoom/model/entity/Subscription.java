package org.escaperoom.model.entity;

import org.bson.types.ObjectId;

public class Subscription {
    private ObjectId _id;
    private String clientEmail;  
    private String name;
    private String surnames;


    public Subscription() {
    }

    public Subscription(String clientEmail, String name, String surnames) {
        this.clientEmail = clientEmail;
        this.name = name;
        this.surnames = surnames;
    
    }

    public Subscription(ObjectId _id, String clientEmail, String name, String surnames) {
        this._id = _id;
        this.clientEmail = clientEmail;
        this.name = name;
        this.surnames = surnames;
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


    @Override
    public String toString() {
        return String.format(
                "Subscription{id=%s, clientEmail='%s', name='%s', surnames='%s'}",
                _id != null ? _id.toHexString() : "null",
                clientEmail, name, surnames);
    }
}
