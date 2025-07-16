package org.escaperoom.model.entity;

import org.escaperoom.model.enums.DifficultyLevel;

import java.math.BigDecimal;

public class Room {

    private int roomId;
    private int escapeRoomId;
    private String name;
    private DifficultyLevel difficultyLevel;
    private BigDecimal price;
    private int quantityAvailable;

    public Room() {}

    public Room(int escapeRoomId, String name, DifficultyLevel difficultyLevel, BigDecimal price, int quantityAvailable) {
        this.escapeRoomId = escapeRoomId;
        this.name = name;
        this.difficultyLevel = difficultyLevel;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    public Room(int roomId, int escapeRoomId, String name, DifficultyLevel difficultyLevel, BigDecimal price, int quantityAvailable) {
        this.roomId = roomId;
        this.escapeRoomId = escapeRoomId;
        this.name = name;
        this.difficultyLevel = difficultyLevel;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    // Getters y setters
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getEscapeRoomId() {
        return escapeRoomId;
    }

    public void setEscapeRoomId(int escapeRoomId) {
        this.escapeRoomId = escapeRoomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    // Devuelve BigDecimal para operaciones financieras precisas
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getPriceAsDouble() {
        return price != null ? price.doubleValue() : 0.0;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    @Override
    public String toString() {
        return String.format(
                "Room{roomId=%d, escapeRoomId=%d, name='%s', difficultyLevel=%s, price=%.2f, quantityAvailable=%d}",
                roomId, escapeRoomId, name, difficultyLevel, getPriceAsDouble(), quantityAvailable);
    }
}
