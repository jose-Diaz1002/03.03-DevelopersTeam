package org.escaperoom.model.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

public class Ticket {

    private int ticketId;
    private int escapeRoomId;
    private int roomId;
    private String playerName;
    private BigDecimal price;
    private Instant purchaseDate;

    public Ticket() {
    }

    public Ticket(int ticketId, int escapeRoomId, int roomId, String playerName, BigDecimal price, Instant purchaseDate) {
        this.ticketId = ticketId;
        this.escapeRoomId = escapeRoomId;
        this.roomId = roomId;
        this.playerName = playerName;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }


    public Ticket(int ticketId, int roomId, String playerName, BigDecimal price, Instant purchaseDate) {
        this.ticketId = ticketId;
        this.roomId = roomId;
        this.playerName = playerName;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }


    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getEscapeRoomId() {
        return escapeRoomId;
    }

    public void setEscapeRoomId(int escapeRoomId) {
        this.escapeRoomId = escapeRoomId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Instant getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Instant purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return  String.format(
                "Ticket ID: %d, Escape Room ID: %d, Room ID: %d, Player Name: %s, Price: %.2f, Purchase Date: %s",
                ticketId, escapeRoomId, roomId, playerName, price.doubleValue(),
                LocalDateTime.ofInstant(purchaseDate, java.time.ZoneId.systemDefault())
        );
    }
}
