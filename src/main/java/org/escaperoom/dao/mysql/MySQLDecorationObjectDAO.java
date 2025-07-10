package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.DecorationObjectDAO;
import org.escaperoom.exception.DecorationObjectCreationException;
import org.escaperoom.model.entity.DecorationObject;

import java.sql.*;
import java.util.List;

public class MySQLDecorationObjectDAO implements DecorationObjectDAO {

    private final Connection connection;

    public MySQLDecorationObjectDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(DecorationObject decoration) throws DecorationObjectCreationException {
        if (decoration.getName() == null || decoration.getName().trim().isEmpty()) {
            throw new DecorationObjectCreationException("Debe indicar un nombre.");
        }
        if (decoration.getMaterialType() == null || decoration.getMaterialType().trim().isEmpty()) {
            throw new DecorationObjectCreationException("Debe indicar un tipo de decoración.");
        }
        if (decoration.getPrice() == null || decoration.getPrice().doubleValue() < 0) {
            throw new DecorationObjectCreationException("El precio debe ser un valor positivo.");
        }
        if (decoration.getQuantity() < 0) {
            throw new DecorationObjectCreationException("La cantidad disponible no puede ser negativa.");
        }

        String sql = "INSERT INTO DecorationObject (room_id, name, material_type, price, quantity_available) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, decoration.getRoomId());
            stmt.setString(2, decoration.getName());
            stmt.setString(3, decoration.getMaterialType());
            stmt.setBigDecimal(4, decoration.getPrice());
            stmt.setInt(5, decoration.getQuantity());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new DecorationObjectCreationException("No se pudo insertar el objeto decorativo, ninguna fila afectada.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    decoration.setDecorationObjectId(generatedKeys.getInt(1));
                } else {
                    throw new DecorationObjectCreationException("No se pudo obtener el ID generado del objeto decorativo.");
                }
            }
        } catch (SQLException e) {
            throw new DecorationObjectCreationException("Error al insertar el objeto decorativo en la base de datos.", e);
        }
    }

    @Override
    public DecorationObject findById(int id) {
        return null;
    }

    @Override
    public List<DecorationObject> findAll() {
        return null;
    }

    @Override
    public void update(DecorationObject decoration) {
        // TODO: Implementar si es necesario
    }

    @Override
    public void delete(int id) {
        // TODO: Implementar si es necesario
    }

    @Override
    public List<DecorationObject> findByRoomId(int roomId) {
        return null;
    }
}
