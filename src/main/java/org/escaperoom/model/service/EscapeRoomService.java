package org.escaperoom.model.service;

import org.escaperoom.dao.common.*;
import org.escaperoom.exception.EscapeRoomCreationException;
import org.escaperoom.exception.EscapeRoomDeletionException;
import org.escaperoom.model.entity.EscapeRoom;

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

    public void createEscapeRoom(EscapeRoom escapeRoom) throws EscapeRoomCreationException {
        if (escapeRoom.getName() == null || escapeRoom.getName().trim().isEmpty()) {
            throw new EscapeRoomCreationException("El nombre del EscapeRoom no puede estar vacío");
        }

        try {
            escapeRoomDAO.create(escapeRoom);
        } catch (Exception e) {
            throw new EscapeRoomCreationException("Error al crear el EscapeRoom en la base de datos", e);
        }
    }

    public List<EscapeRoom> getAllEscapeRooms() {
        try {
            return escapeRoomDAO.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los Escape Rooms", e);
        }
    }

    public void updateEscapeRoom(EscapeRoom updatedEscapeRoom) throws EscapeRoomCreationException {
        if (updatedEscapeRoom.getId() <= 0) {
            throw new EscapeRoomCreationException("ID de Escape Room inválido para actualización.");
        }
        if (updatedEscapeRoom.getName() == null || updatedEscapeRoom.getName().trim().isEmpty()) {
            throw new EscapeRoomCreationException("El nombre no puede estar vacío.");
        }

        try {
            escapeRoomDAO.update(updatedEscapeRoom);
        } catch (Exception e) {
            throw new EscapeRoomCreationException("Error al actualizar el Escape Room.", e);
        }
    }

    public void deleteEscapeRoomById(int id) throws EscapeRoomDeletionException {
        if (id <= 0) {
            throw new EscapeRoomDeletionException("ID inválido para eliminación.");
        }

        try {
            escapeRoomDAO.deleteById(id);
        } catch (Exception e) {
            throw new EscapeRoomDeletionException("Error al eliminar el Escape Room.", e);
        }
    }
}
