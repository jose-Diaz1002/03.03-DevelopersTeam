package org.escaperoom.model.entity;

import java.math.BigDecimal;

public class DecorationObject {

    private int DecorationObjectId;
    private int roomId;
    private EscapeRoom escapeRoom_id;
    private String name;
    private String materialType;
    private BigDecimal price;
    private int quantity;

    public DecorationObject() {
    }

    public DecorationObject(int DecorationObjectId, int roomId, String name, String materialType, BigDecimal price, int quantity) {
        this.DecorationObjectId = DecorationObjectId;
        this.roomId = roomId;
        this.name = name;
        this.materialType = materialType;
        this.price = price;
        this.quantity = quantity;
    }

    public DecorationObject(int roomId, String name, String decorationType, BigDecimal price, int quantity) {
        this.roomId = roomId;
        this.name = name;
        this.materialType = decorationType;
        this.price = price;
        this.quantity = quantity;
    }

    public int getDecorationObjectId() {
        return DecorationObjectId;
    }

    public void setDecorationObjectId(int DecorationObjectId) {
        this.DecorationObjectId = DecorationObjectId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format(
                "Decoration { DecorationObjectId=%d, room_id=%d, name='%s', material_type='%s', price=%.2f, quantity_available=%d }",
                DecorationObjectId, roomId, name, materialType, price, quantity
        );
    }
}
