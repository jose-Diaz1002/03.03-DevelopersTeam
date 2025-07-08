package org.escaperoom.model.entity;

import org.escaperoom.model.enums.ClueTheme;

public class Clue {

    private int id;
    private int roomId;
    private ClueTheme theme;
    private double price;
    private int  quantity;

    public Clue() {
    }

    public Clue( ClueTheme theme, double price, int roomId, int quantity) {
        this.theme = theme;
        this.price = price;
        this.roomId = roomId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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
                ", room_id=" + roomId +
                ", theme=" + theme +
                ", price=" + price +
                ", roomId=" + roomId +
                ", quantity=" + quantity +
                '}';
    }
}
