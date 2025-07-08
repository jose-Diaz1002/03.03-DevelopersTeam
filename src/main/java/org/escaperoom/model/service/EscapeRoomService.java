package org.escaperoom.model.service;


import org.escaperoom.dao.common.*;
import org.escaperoom.exception.EscapeRoomCreationException;
import org.escaperoom.model.entity.EscapeRoom;

import java.sql.SQLException;


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

    public void createEscapeRoom(EscapeRoom escapeRoom) throws EscapeRoomCreationException {
        // Validaciones previas si quieres
        if (escapeRoom.getName() == null || escapeRoom.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del EscapeRoom no puede estar vacío");
        }

        escapeRoomDAO.create(escapeRoom);
    }

}