package org.escaperoom.model.service;

import org.escaperoom.dao.common.ClueDAO;
import org.escaperoom.dao.common.DecorationObjectDAO;
import org.escaperoom.dao.common.RoomDAO;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.entity.DecorationObject;
import org.escaperoom.model.entity.Room;

import java.util.Collections;
import java.util.List;

public class InventoryService {

    private final RoomDAO roomDAO;
    private final ClueDAO clueDAO;
    private final DecorationObjectDAO decorationDAO;

    public InventoryService(RoomDAO roomDAO, ClueDAO clueDAO, DecorationObjectDAO decorationDAO) {
        this.roomDAO = roomDAO;
        this.clueDAO = clueDAO;
        this.decorationDAO = decorationDAO;
    }

    public List<Room> getRoomsByEscapeRoom(int escapeRoomId) {
        try {
            return roomDAO.findByEscapeRoomId(escapeRoomId);
        } catch (Exception e) {
            System.out.println("❌ Error al obtener salas: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Clue> getCluesByRoom(int roomId) {
        try {
            return clueDAO.findByRoomId(roomId);
        } catch (Exception e) {
            System.out.println("❌ Error al obtener pistas: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<DecorationObject> getDecorationsByRoom(int roomId) {
        try {
            return decorationDAO.findByRoomId(roomId);
        } catch (Exception e) {
            System.out.println("❌ Error al obtener objetos decorativos: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
