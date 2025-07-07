package org.escaperoom.model.entity;

import java.math.BigDecimal;

public class EscapeRoom {
    private int id;
    private String name;
    private BigDecimal totalInventoryValue;
    private BigDecimal totalTicketSales;

    // Constructor vacío (recomendado para frameworks o reflexión)
    public EscapeRoom() {
    }

    // Constructor sin id (para insertar nuevos registros)
    public EscapeRoom(String name, BigDecimal totalInventoryValue, BigDecimal totalTicketSales) {
        this.name = name;
        this.totalInventoryValue = totalInventoryValue;
        this.totalTicketSales = totalTicketSales;
    }

    // Constructor con id (para instancias ya existentes en BD)
    public EscapeRoom(int id, String name, BigDecimal totalInventoryValue, BigDecimal totalTicketSales) {
        this.id = id;
        this.name = name;
        this.totalInventoryValue = totalInventoryValue;
        this.totalTicketSales = totalTicketSales;
    }

    // Getters y Setters

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

    public BigDecimal getTotalInventoryValue() {
        return totalInventoryValue;
    }

    public void setTotalInventoryValue(BigDecimal totalInventoryValue) {
        this.totalInventoryValue = totalInventoryValue;
    }

    public BigDecimal getTotalTicketSales() {
        return totalTicketSales;
    }

    public void setTotalTicketSales(BigDecimal totalTicketSales) {
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
