package org.escaperoom.dao.mysql;

import org.escaperoom.model.entity.Room;

import java.sql.*;

public class MySQLRoomDAO {

    private final Connection connection;

    public MySQLRoomDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Room room) throws SQLException {
        String sql = "INSERT INTO Room (name, capacity, escape_room_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, room.getName());
            stmt.setInt(2, room.getCapacity());
            stmt.setInt(3, room.getEscapeRoomId());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    room.setId(rs.getInt(1));
                }
            }
        }
    }

    public Room findById(int id) throws SQLException {
        String sql = "SELECT * FROM Room WHERE room_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Room(
                            rs.getInt("room_id"),
                            rs.getString("name"),
                            rs.getInt("capacity"),
                            rs.getInt("escape_room_id")
                    );
                }
            }
        }
        return null;
    }
}
