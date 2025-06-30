package org.escaperoom.model;

import org.escaperoom.model.enums.DifficultyLevel;

public class Room {

    private int id;
    private int scapeRoomId;
    private String name;
    private DifficultyLevel difficulty;
    private double price;
    private int quantity;

    public Room() {
    }

    public Room(int id, int scapeRoomId, String name, DifficultyLevel difficulty, double price, int quantity) {
        this.id = id;
        this.scapeRoomId = scapeRoomId;
        this.name = name;
        this.difficulty = difficulty;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScapeRoomId() {
        return scapeRoomId;
    }

    public void setScapeRoomId(int scapeRoomId) {
        this.scapeRoomId = scapeRoomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DifficultyLevel getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", scapeRoomId=" + scapeRoomId +
                ", name='" + name + '\'' +
                ", difficulty=" + difficulty +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
