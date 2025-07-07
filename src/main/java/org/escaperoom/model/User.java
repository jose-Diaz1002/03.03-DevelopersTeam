package org.escaperoom.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String email;
    private List<Reward> rewards; // lista de recompensas obtenidas por el usuario

    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.rewards = new ArrayList<>();
    }

    public User() {
        this.rewards = new ArrayList<>();
    }

    // Getters y setters
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

    public List<Reward> getRewards() {
        return rewards;
    }

    public void setRewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public void addReward(Reward reward) {
        this.rewards.add(reward);
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + ", rewards=" + rewards + "]";
    }
}