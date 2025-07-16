package org.escaperoom.factory;

import org.escaperoom.dao.mysql.MySQLDecorationObjectDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.service.DecorationService;

import java.sql.SQLException;

public class DecorationServiceFactory {

    private DecorationServiceFactory() {}

    public static DecorationService create() {
        try {
            return new DecorationService(
                    new MySQLDecorationObjectDAO(MySQLConnection.getInstance().getConnection())
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear DecorationService: " + e.getMessage(), e);
        }
    }
}
