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

    /**
     * Constructor principal con inyección de dependencias.
     */
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

    /**
     * Crea un nuevo EscapeRoom después de validar los datos.
     * @param escapeRoom Objeto EscapeRoom a crear.
     * @throws EscapeRoomCreationException si hay errores durante la creación.
     */
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

    // Aquí puedes añadir más métodos de negocio



    public void deleteEscapeRoomById(int id) throws EscapeRoomDeletionException {

    }
}
