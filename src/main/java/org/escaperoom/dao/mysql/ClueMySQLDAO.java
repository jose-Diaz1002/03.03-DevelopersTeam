package org.escaperoom.dao.mysql;

import org.escaperoom.dao.interfaces.ClueDAO;
import org.escaperoom.model.enums.ClueTheme;
import org.escaperoom.util.MySQLConnection;
import org.escaperoom.model.Clue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClueMySQLDAO implements ClueDAO {


    @Override
    public void create(Clue clue) {
        String sql = "INSERT INTO Clue(scapeRoom_id, theme, price, quantity) VALUES (?, ?, ?, ?)";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, clue.getScapeRoomId());
            pstmt.setString(3, clue.getTheme().name());
            pstmt.setDouble(4, clue.getPrice());
            pstmt.setDouble(5, clue.getQuantity());
            pstmt.executeUpdate();

            System.out.println("Clue insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Clue read(int id) throws SQLException  {
        String sql = "SELECT * FROM clue WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Clue(
                        rs.getInt("id"),
                        rs.getInt("scapeRoom_id"),
                        ClueTheme.valueOf(rs.getString("theme")),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );
            }
        }
        return null;
    }

    @Override
    public List<Clue> readAll() throws SQLException {
        List<Clue> list = new ArrayList<>();
        String sql = "SELECT * FROM Clue";
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Clue(
                        rs.getInt("id"),
                        rs.getInt("scapeRoom_id"),
                        ClueTheme.valueOf(rs.getString("theme")),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }
        }
        return list;
    }

    @Override
    public void update(Clue clue) throws SQLException {

        String sql = "UPDATE Clue SET scapeRoom_id = ?, theme = ?, price = ?, quantity = ? WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, clue.getScapeRoomId());
            ps.setString(2, clue.getTheme().name());
            ps.setDouble(3, clue.getPrice());
            ps.setInt(4, clue.getQuantity());
            ps.setInt(5, clue.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM clue WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }

    }
}
