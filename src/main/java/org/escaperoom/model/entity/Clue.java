package org.escaperoom.model.entity;

import org.escaperoom.model.enums.ClueTheme;

import java.math.BigDecimal;

public class Clue {

    private int clueId;
    private int roomId;
    private ClueTheme theme;
    private BigDecimal price;
    private int quantityAvailable;

    public Clue() {
    }

    public Clue(int roomId, ClueTheme theme, BigDecimal price, int quantityAvailable) {
        this.roomId = roomId;
        this.theme = theme;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    public Clue(ClueTheme theme, BigDecimal price, int quantityAvailable) {
        this.theme = theme;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    public int getId() {
        return clueId;
    }

    public void setId(int clueId) {
        this.clueId = clueId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
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

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    @Override
    public String toString() {
        return String.format("Clue{id=%d, roomId=%d, theme=%s, price=%.2f€, quantityAvailable=%d}",
                clueId, roomId, theme, price, quantityAvailable);
    }
}
