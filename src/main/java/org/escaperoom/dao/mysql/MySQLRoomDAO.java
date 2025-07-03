package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.RoomDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Room;
import org.escaperoom.model.enums.DifficultyLevel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLRoomDAO implements RoomDAO {
    @Override
    public void create(Room room) {
        String sql = "INSERT INTO room(escape_room_id, name, difficulty, price, quantity_available) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, room.getEscape_room_id());
            pstmt.setString(2, room.getName());
            pstmt.setString(3, room.getDifficulty().name());
            pstmt.setDouble(4, room.getPrice());
            pstmt.setInt(5, room.getQuantity_available());
            pstmt.executeUpdate();

            System.out.println("Room insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Room read(int id) throws SQLException {
        String sql = "SELECT * FROM Room WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Room(
                        rs.getInt("id"),
                        rs.getInt("escape_room_id"),
                        rs.getString("name"),
                        DifficultyLevel.valueOf(rs.getString("difficulty")),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );
            }
        }
        return null;
    }

    @Override
    public List<Room> readAll() throws SQLException {
        List<Room> list = new ArrayList<>();
        String sql = "SELECT * FROM Room";
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Room(
                        rs.getInt("id"),
                        rs.getInt("escape_room_id"),
                        rs.getString("name"),
                        DifficultyLevel.valueOf(rs.getString("difficulty")),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }
        }
        return list;
    }

    @Override
    public void update(Room room) throws SQLException {

        String sql = "UPDATE Room SET escape_room_id = ?, name = ?, difficulty = ?, price = ?, quantity_available = ? WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, room.getEscape_room_id());
            ps.setString(2, room.getName());
            ps.setString(3, room.getDifficulty().name());
            ps.setDouble(4, room.getPrice());
            ps.setInt(5, room.getQuantity_available());
            ps.setInt(6, room.getId());
        }
    }

    @Override
    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM Room WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }

    }
}
