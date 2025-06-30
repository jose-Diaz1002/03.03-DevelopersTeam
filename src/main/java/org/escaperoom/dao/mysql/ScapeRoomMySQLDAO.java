package org.escaperoom.dao.mysql;


import org.escaperoom.dao.interfaces.ScapeRoomDAO;
import org.escaperoom.model.Room;
import org.escaperoom.model.ScapeRoom;
import org.escaperoom.model.enums.DifficultyLevel;
import org.escaperoom.util.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScapeRoomMySQLDAO implements ScapeRoomDAO {


    @Override
    public void create(ScapeRoom scapeRoom) throws SQLException {

        String sql = "INSERT INTO room(name)";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, scapeRoom.getName());
            System.out.println("Room creado con exito");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ScapeRoom read(int id) throws SQLException {
        String sql = "SELECT * FROM scape_room WHERE ID = ?";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ScapeRoom(
                        rs.getInt("id"),
                        rs.getString("name")
                );
            }
        }
        return null;
    }

    @Override
    public List<ScapeRoom> readAll() throws SQLException {

        List<ScapeRoom> list = new ArrayList<>();
        String sql = "SELECT * FROM scape_room";
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new ScapeRoom(
                        rs.getInt("id"),
                        rs.getString("name")
                ));
            }
        }
        return list;
    }

    @Override
    public void update(ScapeRoom scapeRoom) throws SQLException {

        String sql = "UPDATE scape_room SET Id = ?, name = ? WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, scapeRoom.getId());
            ps.setString(2, scapeRoom.getName());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM scape_room WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}














