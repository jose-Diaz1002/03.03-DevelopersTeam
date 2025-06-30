package org.escaperoom.model;

public class Decoration {
    private int id;
    private ScapeRoom scapeRoomId;
    private String name;
    private String typesMaterial;
    private double price;
    private int quantity;

    public Decoration() {
    }

    public Decoration(int id, ScapeRoom scapeRoomId, String name, String typesMaterial, double price, int quantity) {
        this.id = id;
        this.scapeRoomId = scapeRoomId;
        this.name = name;
        this.typesMaterial = typesMaterial;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ScapeRoom getScapeRoomId() {
        return scapeRoomId;
    }

    public void setScapeRoomId(ScapeRoom scapeRoomId) {
        this.scapeRoomId = scapeRoomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypesMaterial() {
        return typesMaterial;
    }

    public void setTypesMaterial(String typesMaterial) {
        this.typesMaterial = typesMaterial;
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
                ", scapeRoomId=" + scapeRoomId +
                ", name='" + name + '\'' +
                ", typesMaterial='" + typesMaterial + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
