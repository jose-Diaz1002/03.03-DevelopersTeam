package org.escaperoom.model.entity;

public class Decoration {
    private int id;
<<<<<<< HEAD
    private int room_id;
=======
    private EscapeRoom escapeRoom_id;
>>>>>>> origin/main
    private String name;
    private String material_type;
    private double price;
    private int quantity_available;

    public Decoration() {
    }
<<<<<<< HEAD

    public Decoration(int id, int room_id, String name, String material_type, double price, int quantity_available) {
        this.id = id;
        this.room_id = room_id;
        this.name = name;
        this.material_type = material_type;
        this.price = price;
        this.quantity_available = quantity_available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial_type() {
        return material_type;
    }

    public void setMaterial_type(String material_type) {
        this.material_type = material_type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(int quantity_available) {
        this.quantity_available = quantity_available;
    }

    @Override
    public String toString() {
        return "Decoration{" +
                "id=" + id +
                ", room_id=" + room_id +
                ", name='" + name + '\'' +
                ", material_type='" + material_type + '\'' +
                ", price=" + price +
                ", quantity_available=" + quantity_available +
                '}';
    }
=======
>>>>>>> origin/main
}
