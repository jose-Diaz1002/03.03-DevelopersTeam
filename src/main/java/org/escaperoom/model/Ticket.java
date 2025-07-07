package org.escaperoom.model;

import java.time.LocalDateTime;

public class Ticket {
    private User user;
    private ScapeRoom scapeRoom;
    private double price;
    private LocalDateTime dateTime;

    public Ticket(User user, ScapeRoom scapeRoom, double price, LocalDateTime dateTime) {
        this.user = user;
        this.scapeRoom = scapeRoom;
        this.price = price;
        this.dateTime = dateTime;
    }

    public User getUser() {
        return user;
    }

    public ScapeRoom getScapeRoom() {
        return scapeRoom;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "user=" + user.getUsername() +
                ", scapeRoom=" + scapeRoom.getName() +
                ", price=" + price +
                ", dateTime=" + dateTime +
                '}';
    }
}
