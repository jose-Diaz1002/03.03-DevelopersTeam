package org.escaperoom.model.entity;

public class EscapeRoom {
    private int id;
    private String name;
    private double total_inventory_value;
    private double total_ticket_sales;

    public EscapeRoom() {
    }

    public EscapeRoom(int id, String name, double total_inventory_value, double total_ticket_sales) {
        this.id = id;
        this.name = name;
        this.total_inventory_value = total_inventory_value;
        this.total_ticket_sales = total_ticket_sales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal_inventory_value() {
        return total_inventory_value;
    }

    public void setTotal_inventory_value(double total_inventory_value) {
        this.total_inventory_value = total_inventory_value;
    }

    public double getTotal_ticket_sales() {
        return total_ticket_sales;
    }

    public void setTotal_ticket_sales(double total_ticket_sales) {
        this.total_ticket_sales = total_ticket_sales;
    }

    @Override
    public String toString() {
        return "EscapeRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", total_inventory_value=" + total_inventory_value +
                ", total_ticket_sales=" + total_ticket_sales +
                '}';
    }
}
