package org.escaperoom.model.service;

import org.escaperoom.dao.common.RoomDAO;
import org.escaperoom.exception.RoomCreationException;
import org.escaperoom.model.entity.Room;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class RoomService {

    private final RoomDAO roomDAO;

    public RoomService(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public void createRoom(Room room) throws RoomCreationException {
        // Validaciones
        if (room.getName() == null || room.getName().trim().isEmpty()) {
            throw new RoomCreationException("El nombre de la sala no puede estar vacío");
        }
        if (room.getEscapeRoomId() <= 0) {
            throw new RoomCreationException("Debe indicar un EscapeRoom válido");
        }
        // Precio >= 0 BIGDECIMAL
        if (room.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new RoomCreationException("El precio no puede ser negativo");
        }
        if (room.getQuantityAvailable() < 0) {
            throw new RoomCreationException("La cantidad no puede ser negativa");
        }

        // Guardar usando DAO
        roomDAO.create(room);
    }

    public List<Room> getRoomsByEscapeRoomId(int escapeRoomId) throws SQLException {
        return roomDAO.findByEscapeRoomId(escapeRoomId);
    }
}
