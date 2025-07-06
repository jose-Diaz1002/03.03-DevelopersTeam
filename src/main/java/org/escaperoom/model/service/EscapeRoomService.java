package org.escaperoom.model.service;


import org.escaperoom.dao.common.*;


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
}