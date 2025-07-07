package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.ClueDAO;
<<<<<<< HEAD
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.enums.ClueTheme;
import org.escaperoom.model.entity.Clue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLClueDAO implements ClueDAO {
    @Override
    public void create(Clue clue) {
        String sql = "INSERT INTO Clue(room_id, theme, price, quantity) VALUES (?, ?, ?, ?)";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, clue.getRoom_id());
            pstmt.setString(2, clue.getTheme().name());
            pstmt.setDouble(3, clue.getPrice());
            pstmt.setInt(4, clue.getQuantity_available());
            pstmt.executeUpdate();

            System.out.println("Clue insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Clue read(int id) throws SQLException {
        String sql = "SELECT * FROM clue WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Clue(
                        rs.getInt("id"),
                        rs.getInt("room_id"),
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
                        rs.getInt("room_id"),
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

        String sql = "UPDATE Clue SET room_id = ?, theme = ?, price = ?, quantity = ? WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, clue.getRoom_id());
            ps.setString(2, clue.getTheme().name());
            ps.setDouble(3, clue.getPrice());
            ps.setInt(4, clue.getQuantity_available());
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
=======

public class MySQLClueDAO  implements ClueDAO {


>>>>>>> origin/main
}
