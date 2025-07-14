package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.EscapeRoomDAO;
import org.escaperoom.exception.EscapeRoomCreationException;
import org.escaperoom.exception.EscapeRoomDeletionException;
import org.escaperoom.model.entity.EscapeRoom;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<EscapeRoom> findAll() throws EscapeRoomCreationException {
        String sql = "SELECT * FROM EscapeRoom";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            List<EscapeRoom> escapeRooms = new ArrayList<>();
            while (rs.next()) {
                EscapeRoom escapeRoom = new EscapeRoom();
                escapeRoom.setId(rs.getInt("escape_room_id"));
                escapeRoom.setName(rs.getString("name"));
                escapeRooms.add(escapeRoom);
            }
            return escapeRooms;

        } catch (SQLException e) {
            throw new EscapeRoomCreationException("Error al obtener los Escape Rooms de la base de datos.", e);
        }
    }

    @Override
    public void update(EscapeRoom escapeRoom) throws EscapeRoomCreationException {
        if (escapeRoom.getId() <= 0) {
            throw new EscapeRoomCreationException("El ID del EscapeRoom debe ser mayor que cero.");
        }
        if (escapeRoom.getName() == null || escapeRoom.getName().trim().isEmpty()) {
            throw new EscapeRoomCreationException("El nombre del EscapeRoom no puede estar vacío.");
        }

        String sql = "UPDATE EscapeRoom SET name = ? WHERE escape_room_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, escapeRoom.getName());
            stmt.setInt(2, escapeRoom.getId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new EscapeRoomCreationException("No se pudo actualizar el EscapeRoom, ninguna fila afectada.");
            }

        } catch (SQLException e) {
            throw new EscapeRoomCreationException("Error al actualizar el EscapeRoom en la base de datos.", e);
        }
    }

    @Override
    public void deleteById(int escapeRoomId) throws EscapeRoomCreationException {
        String sql = "DELETE FROM EscapeRoom WHERE escape_room_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, escapeRoomId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new EscapeRoomCreationException("No se encontró ningún EscapeRoom con el ID proporcionado.");
            }

        } catch (SQLException e) {
            throw new EscapeRoomCreationException("Error al eliminar el EscapeRoom en la base de datos.", e);
        }
    }


}
