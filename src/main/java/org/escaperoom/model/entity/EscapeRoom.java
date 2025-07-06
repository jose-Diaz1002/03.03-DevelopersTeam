package org.escaperoom.model.entity;

public class EscapeRoom {
    private int id;
    private String name;
    private double totalInventoryValue;
    private double totalTicketSales;

    // Constructor vacío (recomendado)
    public EscapeRoom() {
    }

    // Constructor para crear nuevos objetos (antes de insertar, sin id)
    public EscapeRoom(String name, double totalInventoryValue, double totalTicketSales) {
        this.name = name;
        this.totalInventoryValue = totalInventoryValue;
        this.totalTicketSales = totalTicketSales;
    }

    // Constructor para objetos ya existentes (con id)
    public EscapeRoom(int id, String name, double totalInventoryValue, double totalTicketSales) {
        this.id = id;
        this.name = name;
        this.totalInventoryValue = totalInventoryValue;
        this.totalTicketSales = totalTicketSales;
    }

    // Getters y setters

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

    public double getTotalInventoryValue() {
        return totalInventoryValue;
    }

    public void setTotalInventoryValue(double totalInventoryValue) {
        this.totalInventoryValue = totalInventoryValue;
    }

    public double getTotalTicketSales() {
        return totalTicketSales;
    }

    public void setTotalTicketSales(double totalTicketSales) {
        this.totalTicketSales = totalTicketSales;
    }

    @Override
    public String toString() {
        return "EscapeRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalInventoryValue=" + totalInventoryValue +
                ", totalTicketSales=" + totalTicketSales +
                '}';
    }
}
