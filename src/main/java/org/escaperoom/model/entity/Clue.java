package org.escaperoom.model.entity;

import org.escaperoom.model.enums.ClueTheme;

public class Clue {

    private int id;
    private int room_id;
    private ClueTheme theme;
    private double price;
    private int quantity_available;

    public Clue() {
    }

    public Clue(int id, int room_id, ClueTheme theme, double price, int quantity_available) {
        this.id = id;
        this.room_id = room_id;
        this.theme = theme;
        this.price = price;
        this.quantity_available = quantity_available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
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

    public int getQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(int quantity_available) {
        this.quantity_available = quantity_available;
    }

    @Override
    public String toString() {
        return "Clue{" +
                "id=" + id +
                ", room_id=" + room_id +
                ", theme=" + theme +
                ", price=" + price +
                ", quantity_available=" + quantity_available +
                '}';
    }
}
