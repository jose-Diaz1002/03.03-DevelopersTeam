package org.escaperoom.model.entity;

import org.escaperoom.model.enums.ClueTheme;

public class Clue {

    private int id;
    private int room_id;
    private ClueTheme theme;
    private double price;
    private int quantity;

    public Clue() {
    }

    public Clue(int id, int room_id, ClueTheme theme, double price, int quantity) {
        this.id = id;
        this.theme = theme;
        this.price = price;
        this.quantity = quantity;
        this.room_id = room_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScapeRoomId() {
        return room_id;
    }

    public void setScapeRoomId(int scapeRoomId) {
        this.room_id = room_id;
    }

    public ClueTheme getTheme() {
        return theme;
    }

    public void setTheme(ClueTheme theme) {
        this.theme = theme;
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
        return "Clue{" +
                "id=" + id +
                ", scapeRoomId=" + room_id +
                ", theme=" + theme +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
