package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.EscapeRoomDAO;
import org.escaperoom.exception.EscapeRoomCreationException;
import org.escaperoom.model.entity.EscapeRoom;

import java.sql.*;

public class MySQLEscapeRoomDAO implements EscapeRoomDAO {

    private final Connection connection;

    public MySQLEscapeRoomDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(EscapeRoom escapeRoom) throws EscapeRoomCreationException {
        if (escapeRoom.getName() == null || escapeRoom.getName().trim().isEmpty()) {
            throw new EscapeRoomCreationException("El nombre del EscapeRoom no puede estar vacío.");
        }

        String sql = "INSERT INTO EscapeRoom (name) VALUES (?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, escapeRoom.getName());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new EscapeRoomCreationException("No se pudo insertar el EscapeRoom, ninguna fila afectada.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    escapeRoom.setId(generatedKeys.getInt(1));
                } else {
                    throw new EscapeRoomCreationException("No se pudo obtener el ID generado del EscapeRoom.");
                }
            }

        } catch (SQLException e) {
            throw new EscapeRoomCreationException("Error al insertar el EscapeRoom en la base de datos.", e);
        }
    }
}
