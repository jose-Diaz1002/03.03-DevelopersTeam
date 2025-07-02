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


    public Ticket(Integer roomId, Integer playerId, Double totalAmount) {
        this.roomId = roomId;
        this.playerId = playerId;
        this.totalAmount = totalAmount;
        this.purchaseDate = LocalDateTime.now(); // Fecha y hora de la compra del ticket
    }

    public int getId() {
        return id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format( "Ticket ID: %d | Room ID: %s | Player ID: %s | Total Price: %.2f | Created At: %s",
                id, (roomId != null ? roomId : "Deleted"),
                (playerId != null ? playerId : "Deleted"),
                totalAmount, purchaseDate);
    }
}
