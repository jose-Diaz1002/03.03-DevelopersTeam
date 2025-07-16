package org.escaperoom.model.entity;

import java.time.LocalDateTime;

public class Ticket {


    /*
     ticket_id INT AUTO_INCREMENT PRIMARY KEY,
    player_id INT NOT NULL,
    room_id INT NOT NULL, -- Un ticket se compra para acceder a una sala específica (según el enunciado)
    purchase_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Fecha y hora de la compra del ticket
    total_amount DECIMAL(10, 2) NOT NULL, -- Valor total del ticket
     */

    private int id;
    private Integer roomId;
    private Integer playerId;
    private LocalDateTime purchaseDate;
    private Double totalAmount;

    public Ticket() {
    }

    public Ticket(int id, Integer roomId, Integer playerId, LocalDateTime purchaseDate, Double totalAmount) {
        this.id = id;
        this.roomId = roomId;
        this.playerId = playerId;
        this.purchaseDate = purchaseDate;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", room_id=" + roomId +
                ", player_id=" + playerId +
                ", purchase_date=" + purchaseDate +
                ", total_amount=" + totalAmount +
                '}';
    }
}
