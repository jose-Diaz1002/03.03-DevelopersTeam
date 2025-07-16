package org.escaperoom.service;

import org.escaperoom.dao.common.RoomDAO;
import org.escaperoom.exception.RoomCreationException;
import org.escaperoom.exception.RoomUpdateException;
import org.escaperoom.model.entity.Room;
import org.escaperoom.model.notification.Observable;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class RoomService extends Observable {

    private final RoomDAO roomDAO;

    public RoomService(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public void createRoom(Room room) throws RoomCreationException {
        if (room.getName() == null || room.getName().trim().isEmpty()) {
            throw new RoomCreationException("El nombre de la sala no puede estar vacío");
        }
        if (room.getEscapeRoomId() <= 0) {
            throw new RoomCreationException("Debe indicar un EscapeRoom válido");
        }
        if (room.getPrice() == null || room.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new RoomCreationException("El precio no puede ser negativo");
        }
        if (room.getQuantityAvailable() < 0) {
            throw new RoomCreationException("La cantidad no puede ser negativa");
        }

        roomDAO.create(room);
        notifyObservers("roomCreated", room);
    }

    public List<Room> getRoomsByEscapeRoomId(int escapeRoomId) throws SQLException {
        return roomDAO.findByEscapeRoomId(escapeRoomId);
    }

    public Room findById(int roomId) throws SQLException {
        return roomDAO.findById(roomId);
    }

    public void updateRoom(Room room) throws RoomUpdateException {
        if (room.getRoomId() <= 0) {
            throw new RoomUpdateException("ID de sala inválido para actualización.");
        }
        if (room.getName() == null || room.getName().trim().isEmpty()) {
            throw new RoomUpdateException("El nombre de la sala no puede estar vacío.");
        }
        if (room.getPrice() == null || room.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new RoomUpdateException("El precio no puede ser negativo.");
        }
        if (room.getQuantityAvailable() < 0) {
            throw new RoomUpdateException("La cantidad no puede ser negativa.");
        }

        roomDAO.update(room);
        notifyObservers("roomUpdated", room);
    }

    public void deleteRoom(int roomId) throws SQLException {
        roomDAO.delete(roomId);
        notifyObservers("roomDeleted", roomId);
    }

    public List<Room> getAllRooms() throws SQLException {
        return roomDAO.findAll();
    }
}
