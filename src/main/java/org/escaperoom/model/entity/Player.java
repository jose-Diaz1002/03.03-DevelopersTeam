package org.escaperoom.model.entity;

public class Player {
    private int id;
    private String username;
    private String email;

    public Player() {
    }

    public Player(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Player(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
       return String.format("Player{id=%d, username='%s', email='%s'}", id, username, email);
    }
}
