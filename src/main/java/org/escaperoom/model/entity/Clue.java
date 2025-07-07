package org.escaperoom.model.entity;

import org.escaperoom.model.enums.ClueTheme;

import java.math.BigDecimal;

public class Clue {

    private int id;
<<<<<<< HEAD
    private int room_id;
    private ClueTheme theme;
    private double price;
=======
    private int roomId;
    private ClueTheme theme;
    private BigDecimal price;
>>>>>>> c3d6979 (feat: cambios en entity)
    private int  quantity;

    public Clue() {
    }

    public Clue(int roomId, ClueTheme theme, BigDecimal price, int quantity) {
        this.roomId = roomId;
        this.theme = theme;
        this.price = price;
        this.quantity = quantity;
    }

    public Clue(int id, int roomId, ClueTheme theme, double price, int quantity) {
        this.id = id;
        this.theme = theme;
        this.price = price;
        this.quantity = quantity;
        this.roomId = roomId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int scapeRoomId) {
        this.roomId = roomId;
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
                ", scapeRoomId=" + roomId +
                ", theme=" + theme +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
