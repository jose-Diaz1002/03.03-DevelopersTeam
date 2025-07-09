package org.escaperoom.model.entity;

import org.escaperoom.model.enums.ClueTheme;

import java.math.BigDecimal;

public class Clue {

    private int clueId;
    private int roomId;
    private ClueTheme theme;
    private BigDecimal price;
    private int  quantity;

    public Clue() {
    }

    public Clue(int roomId, ClueTheme theme, BigDecimal price, int quantity) {
        this.roomId = roomId;
        this.theme = theme;
        this.price = price;
        this.quantity = quantity;
    }

    public Clue(ClueTheme theme, BigDecimal price, int quantity) {
        this.theme = theme;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return clueId;
    }

    public void setId(int clueId) {
        this.clueId = clueId;
    }

    public ClueTheme getTheme() {
        return theme;
    }

    public void setTheme(ClueTheme theme) {
        this.theme = theme;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getRoomId() {
        return roomId;
    }

    public void setClueId(int clueId) {
        this.clueId = clueId;
    }

    @Override
    public String toString() {
        return String.format("Clue{clueId=%d, roomId=%d, theme='%s', price=%.2f, quantity=%d}",
                clueId, roomId, theme, price, quantity);
    }



}
