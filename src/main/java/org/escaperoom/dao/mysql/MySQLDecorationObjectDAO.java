package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.DecorationObjectDAO;
import org.escaperoom.model.entity.DecorationObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLDecorationObjectDAO implements DecorationObjectDAO {

    private final Connection connection;

    public MySQLDecorationObjectDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(DecorationObject decorationObject) {
        String sql = "INSERT INTO DecorationObject (room_id, name, material_type, price, quantity_available) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, decorationObject.getRoomId());
            ps.setString(2, decorationObject.getName());
            ps.setString(3, decorationObject.getMaterialType());
            ps.setBigDecimal(4, decorationObject.getPrice());
            ps.setInt(5, decorationObject.getQuantityAvailable());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating DecorationObject failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    decorationObject.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating DecorationObject failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error creating DecorationObject: " + e.getMessage(), e);
        }
    }

    @Override
    public DecorationObject findById(int id) {
        String sql = "SELECT * FROM DecorationObject WHERE decoration_object_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToDecorationObject(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding DecorationObject by id: " + e.getMessage(), e);
        }
        return null;
    }



    @Override
    public List<DecorationObject> findByRoomId(int roomId) {
        String sql = "SELECT * FROM DecorationObject WHERE room_id = ?";
        List<DecorationObject> list = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, roomId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapResultSetToDecorationObject(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding DecorationObjects by roomId: " + e.getMessage(), e);
        }
        return list;
    }

    @Override
    public void update(DecorationObject decorationObject) {
        String sql = "UPDATE DecorationObject SET room_id=?, name=?, material_type=?, price=?, quantity_available=? WHERE decoration_object_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, decorationObject.getRoomId());
            ps.setString(2, decorationObject.getName());
            ps.setString(3, decorationObject.getMaterialType());
            ps.setBigDecimal(4, decorationObject.getPrice());
            ps.setInt(5, decorationObject.getQuantityAvailable());
            ps.setInt(6, decorationObject.getId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating DecorationObject failed, no rows affected.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error updating DecorationObject: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM DecorationObject WHERE decoration_object_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting DecorationObject: " + e.getMessage(), e);
        }
    }

    private DecorationObject mapResultSetToDecorationObject(ResultSet rs) throws SQLException {
        DecorationObject decorationObject = new DecorationObject();
        decorationObject.setId(rs.getInt("decoration_object_id"));
        decorationObject.setRoomId(rs.getInt("room_id"));
        decorationObject.setName(rs.getString("name"));
        decorationObject.setMaterialType(rs.getString("material_type"));
        decorationObject.setPrice(rs.getBigDecimal("price"));
        decorationObject.setQuantityAvailable(rs.getInt("quantity_available"));
        return decorationObject;
    }
}
