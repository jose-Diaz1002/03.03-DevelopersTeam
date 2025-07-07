package org.escaperoom.model.entity;

import org.escaperoom.model.enums.ClueTheme;

public class Clue {

    private int id;
    private  room_id;
    private ClueTheme theme;
    private double price;
    private int  quantity_available;

    public Clue() {
    }

    public Clue(int id, int scapeRoomId, ClueTheme theme, double price, int quantity) {
        this.id = id;
        this.scapeRoomId = scapeRoomId;
        this.theme = theme;
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
                ", scapeRoomId=" + scapeRoomId +
                ", theme=" + theme +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
