package org.escaperoom.factory;

import org.escaperoom.dao.common.*;
import org.escaperoom.dao.mysql.*;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.service.EscapeRoomService;

import java.sql.Connection;
import java.sql.SQLException;

public class EscapeRoomServiceFactory {

    public static EscapeRoomService create() {
        try {
            Connection connection = MySQLConnection.getInstance().getConnection();

            EscapeRoomDAO escapeRoomDAO = new MySQLEscapeRoomDAO(connection);
            RoomDAO roomDAO = new MySQLRoomDAO(connection);
            ClueDAO clueDAO = new MySQLClueDAO(connection);
            DecorationObjectDAO decorationObjectDAO = new MySQLDecorationObjectDAO(connection);
            TicketDAO ticketDAO = new MySQLTicketDAO(connection);
            AchievementDAO achievementDAO = new MySQLAchievementDAO(connection);
            InventoryDAO inventoryDAO = new MySQLInventoryDAO(connection);

            return new EscapeRoomService(
                    escapeRoomDAO,
                    roomDAO,
                    clueDAO,
                    decorationObjectDAO,
                    ticketDAO,
                    achievementDAO,
                    inventoryDAO
            );

        } catch (SQLException e) {
            throw new RuntimeException("❌ Error al crear EscapeRoomService: " + e.getMessage(), e);
        }
    }
}
