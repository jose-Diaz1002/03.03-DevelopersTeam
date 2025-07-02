package org.escaperoom.model.entity;

import org.escaperoom.model.enums.DifficultyLevel;

public class Room {

    private int id;
    private int escape_room_id;
    private String name;
    private DifficultyLevel difficulty;
    private double price;
    private int quantity_available;

    public Room() {
    }

    public Room(int id, int escape_room_id, String name, DifficultyLevel difficulty, double price, int quantity_available) {
        this.id = id;
        this.escape_room_id = escape_room_id;
        this.name = name;
        this.difficulty = difficulty;
        this.price = price;
        this.quantity_available = quantity_available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEscape_room_id() {
        return escape_room_id;
    }

    public void setEscape_room_id(int escape_room_id) {
        this.escape_room_id = escape_room_id;
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

    public int getQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(int quantity_available) {
        this.quantity_available = quantity_available;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", escape_room_id=" + escape_room_id +
                ", name='" + name + '\'' +
                ", difficulty=" + difficulty +
                ", price=" + price +
                ", quantity_available=" + quantity_available +
                '}';
    }
}
