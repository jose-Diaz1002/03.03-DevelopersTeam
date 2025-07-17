package org.escaperoom.factory;

import org.escaperoom.dao.mysql.MySQLRoomDAO;
import org.escaperoom.database.ConnectionFactory;
import org.escaperoom.service.RoomService;

import java.sql.SQLException;

public class RoomServiceFactory {
    private static RoomService roomService;

    private RoomServiceFactory() { }

    public static synchronized RoomService create() {
        if (roomService == null) {
            try {
                roomService = new RoomService(new MySQLRoomDAO(ConnectionFactory.getMySQLConnection()));
            } catch (SQLException e) {
                throw new RuntimeException("❌ Error al crear RoomService: " + e.getMessage(), e);
            }
        }
        return roomService;
    }
}
