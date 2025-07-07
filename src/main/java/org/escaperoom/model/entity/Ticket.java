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
    private Integer room_id;
    private Integer player_id;
    private LocalDateTime purchase_date;
    private Double total_amount;

    public Ticket() {
    }

    public Ticket(int id, Integer room_id, Integer player_id, LocalDateTime purchase_date, Double total_amount) {
        this.id = id;
        this.room_id = room_id;
        this.player_id = player_id;
        this.purchase_date = purchase_date;
        this.total_amount = total_amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Integer getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Integer player_id) {
        this.player_id = player_id;
    }

    public LocalDateTime getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(LocalDateTime purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", room_id=" + room_id +
                ", player_id=" + player_id +
                ", purchase_date=" + purchase_date +
                ", total_amount=" + total_amount +
                '}';
    }
}
