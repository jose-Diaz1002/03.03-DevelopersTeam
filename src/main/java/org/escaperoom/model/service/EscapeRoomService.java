package org.escaperoom.model.service;
import com.escaperoom.model.dao.*;
import com.escaperoom.model.domain.*;
import java.util.List;

public class EscapeRoomService {

    private final EscapeRoomDAO escapeRoomDAO;
    private final RoomDAO roomDAO;
    private final ClueDAO clueDAO;
    private final DecorationObjectDAO decorationObjectDAO;
    private final TicketDAO ticketDAO;
    private final AchievementDAO achievementDAO;
    private final InventoryDAO inventoryDAO;

    public EscapeRoomService(
            EscapeRoomDAO escapeRoomDAO,
            RoomDAO roomDAO,
            ClueDAO clueDAO,
            DecorationObjectDAO decorationObjectDAO,
            TicketDAO ticketDAO,
            AchievementDAO achievementDAO,
            InventoryDAO inventoryDAO
    ) {
        this.escapeRoomDAO = escapeRoomDAO;
        this.roomDAO = roomDAO;
        this.clueDAO = clueDAO;
        this.decorationObjectDAO = decorationObjectDAO;
        this.ticketDAO = ticketDAO;
        this.achievementDAO = achievementDAO;
        this.inventoryDAO = inventoryDAO;
    }

    public void createEscapeRoom(EscapeRoom escapeRoom) {
        escapeRoomDAO.save(escapeRoom);
    }

    public void addRoom(int escapeRoomId, Room room) {
        EscapeRoom er = escapeRoomDAO.findById(escapeRoomId);
        if (er != null) {
            er.addRoom(room);
            roomDAO.save(room);
            escapeRoomDAO.update(er);
        }
    }

    public void addClue(int roomId, Clue clue) {
        Room room = roomDAO.findById(roomId);
        if (room != null) {
            room.addClue(clue);
            clueDAO.save(clue);
            roomDAO.update(room);
        }
    }

    public void addDecorationObject(int roomId, DecorationObject obj) {
        Room room = roomDAO.findById(roomId);
        if (room != null) {
            room.addDecorationObject(obj);
            decorationObjectDAO.save(obj);
            roomDAO.update(room);
        }
    }

    public void purchaseTicket(Ticket ticket) {
        ticketDAO.save(ticket);
    }

    public double calculateTotalRevenue() {
        List<Ticket> tickets = ticketDAO.findAll();
        return tickets.stream().mapToDouble(Ticket::getPrice).sum();
    }

    public void completeAchievement(int userId, Achievement achievement) {
        achievementDAO.saveForUser(userId, achievement);
    }

    public double getInventoryValue() {
        return inventoryDAO.findAll().stream()
                .mapToDouble(InventoryItem::getValue)
                .sum();
    }

    public void removeInventoryItem(int itemId) {
        inventoryDAO.delete(itemId);
    }


    /*package com.escaperoom.model.service;

import com.escaperoom.model.dao.*;
import com.escaperoom.model.domain.*;
import com.escaperoom.observer.Observable;

public class EscapeRoomService extends Observable {

    // DAOs como antes...

    public EscapeRoomService(
        EscapeRoomDAO escapeRoomDAO,
        RoomDAO roomDAO,
        ClueDAO clueDAO,
        DecorationObjectDAO decorationObjectDAO,
        TicketDAO ticketDAO,
        AchievementDAO achievementDAO,
        InventoryDAO inventoryDAO
    ) {
        // Asignación como antes
    }

    public void addDecorationObject(int roomId, DecorationObject obj) {
        Room room = roomDAO.findById(roomId);
        if (room != null) {
            room.addDecorationObject(obj);
            decorationObjectDAO.save(obj);
            roomDAO.update(room);
            notifyObservers("decorationAdded", obj);
        }
    }

    public void completeAchievement(int userId, Achievement achievement) {
        achievementDAO.saveForUser(userId, achievement);
        notifyObservers("achievementCompleted", achievement);
    }

    // otros métodos...
}
*/
}