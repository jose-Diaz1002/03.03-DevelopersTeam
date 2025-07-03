package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.PlayerDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLPlayerDAO implements PlayerDAO {
    @Override
    public void create(Player player) {
        String sql = "INSERT INTO Player(username,email) VALUES (?, ?)";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, player.getUsername());
            pstmt.setString(2, player.getEmail());
            pstmt.executeUpdate();

            System.out.println("Player insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Player read(int id) throws SQLException {
        String sql = "SELECT * FROM Player WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Player(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("email")
                );
            }
        }
        return null;
    }

    @Override
    public List<Player> readAll() throws SQLException {
        List<Player> list = new ArrayList<>();
        String sql = "SELECT * FROM Player";
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Player(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("email")
                ));
            }
        }
        return list;
    }

    @Override
    public void update(Player player) throws SQLException {

        String sql = "UPDATE Player SET username = ?,email = ? WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, player.getUsername());
            ps.setString(2, player.getEmail());
            ps.setInt(3, player.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM Player WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }

    }
}
