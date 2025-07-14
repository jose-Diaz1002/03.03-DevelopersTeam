package org.escaperoom.model.entity;

import java.math.BigDecimal;

public class DecorationObject {

    private int id;
    private int roomId;
    private String name;
    private String materialType;
    private BigDecimal price;
    private int quantityAvailable;

    public DecorationObject() {
    }

    public DecorationObject(int roomId, String name, String materialType, BigDecimal price, int quantityAvailable) {
        this.roomId = roomId;
        this.name = name;
        this.materialType = materialType;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
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

        return String.format(
                "DecorationObject{id=%d, roomId=%d, name='%s', materialType='%s', price=%s, quantityAvailable=%d}",
                id, roomId, name, materialType, price.toPlainString(), quantityAvailable
        );
    }
}
