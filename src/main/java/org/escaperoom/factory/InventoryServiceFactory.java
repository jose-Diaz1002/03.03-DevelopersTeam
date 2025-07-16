package org.escaperoom.factory;

import org.escaperoom.dao.mysql.MySQLClueDAO;
import org.escaperoom.dao.mysql.MySQLDecorationObjectDAO;
import org.escaperoom.dao.mysql.MySQLRoomDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.service.InventoryService;

import java.sql.SQLException;

public class InventoryServiceFactory {

    private InventoryServiceFactory() {}

    public static InventoryService create() {
        try {
            return new InventoryService(
                    new MySQLRoomDAO(MySQLConnection.getInstance().getConnection()),
                    new MySQLClueDAO(MySQLConnection.getInstance().getConnection()),
                    new MySQLDecorationObjectDAO(MySQLConnection.getInstance().getConnection())
            );
        } catch (SQLException e) {
            throw new RuntimeException("❌ Error al crear InventoryService: " + e.getMessage(), e);
        }
    }
}
