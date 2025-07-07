package org.escaperoom.model.entity;

public class Decoration {
    private int id;
    private int roomId;
    private EscapeRoom escapeRoom_id;
    private String name;
    private String materialType;
    private double price;
    private int quantity;

    public Decoration() {
    }


    public Decoration(int id, int roomId, String name, String materialType, double price, int quantity) {
        this.id = id;
        this.roomId = roomId;
        this.name = name;
        this.materialType = materialType;
        this.price = price;
        this.quantity = quantity;
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
        return "Decoration{" +
                "id=" + id +
                ", room_id=" + roomId +
                ", name='" + name + '\'' +
                ", material_type='" + materialType + '\'' +
                ", price=" + price +
                ", quantity_available=" + quantity +
                '}';
    }
}
