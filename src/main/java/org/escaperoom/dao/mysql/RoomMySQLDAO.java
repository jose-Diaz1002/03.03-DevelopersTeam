package org.escaperoom.dao.mysql;

import org.escaperoom.dao.interfaces.RoomDAO;
import org.escaperoom.model.Room;
import org.escaperoom.model.enums.DifficultyLevel;
import org.escaperoom.util.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomMySQLDAO implements RoomDAO {


    @Override
    public void create(Room room) throws SQLException {
        String sql = "INSERT INTO room(scapeRoomId,name,difficulty,price,quantity)";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, room.getScapeRoomId());
            pstmt.setString(2, room.getName());
            pstmt.setString(3, room.getDifficulty().name());
            pstmt.setDouble(4, room.getPrice());
            pstmt.setInt(5, room.getQuantity());
            System.out.println("Room creado con exito");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Room read(int id) throws SQLException {
        String sql = "SELECT * FROM room WHERE ID = ?";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Room(
                        rs.getInt("id"),
                        rs.getInt("scapeRoomId"),
                        rs.getString("name"),
                        DifficultyLevel.valueOf(rs.getString("difficulty")),
                        rs.getInt("price"),
                        rs.getInt("quantity")
                );
            }
        }
        return null;
    }

    @Override
    public List<Room> readAll() throws SQLException {
        List<Room> list = new ArrayList<>();
        String sql = "SELECT * FROM room";
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Room(
                        rs.getInt("id"),
                        rs.getInt("scapeRoomId"),
                        rs.getString("name"),
                        DifficultyLevel.valueOf(rs.getString("difficulty")),
                        rs.getInt("price"),
                        rs.getInt("quantity")
                ));
            }
        }
        return list;
    }

    @Override
    public void update(Room room) throws SQLException {

        String sql = "UPDATE room SET scapeRoomId = ?, name = ?, difficulty, price = ?, " +
                "quantity = ? WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, room.getScapeRoomId());
            ps.setString(2, room.getName());
            ps.setString(3, room.getDifficulty().name());
            ps.setDouble(4, room.getPrice());
            ps.setInt(5, room.getQuantity());
            ps.setInt(6, room.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM room WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }

    }
}
