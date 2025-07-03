package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.DecorationObjectDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Decoration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLDecorationObjectDAO implements DecorationObjectDAO {

    @Override
    public void create(Decoration decoration) {
        String sql = "INSERT INTO decoration (room_id, name, material_type, price, quantity_available) VALUES (?, ?, ?, ?,?)";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, decoration.getRoom_id());
            pstmt.setString(2, decoration.getName());
            pstmt.setString(3, decoration.getMaterial_type());
            pstmt.setDouble(4, decoration.getPrice());
            pstmt.setInt(5, decoration.getQuantity_available());
            pstmt.executeUpdate();

            System.out.println("decoration insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Decoration read(int id) throws SQLException {
        String sql = "SELECT * FROM Decoration WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Decoration(
                        rs.getInt("id"),
                        rs.getInt("room_id"),
                        rs.getString("name"),
                        rs.getString("material_type"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                );
            }
        }
        return null;
    }

    @Override
    public List<Decoration> readAll() throws SQLException {
        List<Decoration> list = new ArrayList<>();
        String sql = "SELECT * FROM Decoration";
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Decoration(
                        rs.getInt("id"),
                        rs.getInt("room_id"),
                        rs.getString("name"),
                        rs.getString("material_type"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }
        }
        return list;
    }

    @Override
    public void update(Decoration decoration) throws SQLException {

        String sql = "UPDATE Decoration SET room_id= ?, name= ?, material_type= ?, price= ?, quantity_available= ? WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, decoration.getRoom_id());
            ps.setString(2, decoration.getName());
            ps.setString(3, decoration.getMaterial_type());
            ps.setDouble(4, decoration.getPrice());
            ps.setInt(5, decoration.getQuantity_available());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM decoration WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }

    }


}
