package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.EscapeRoomDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.entity.EscapeRoom;
import org.escaperoom.model.enums.ClueTheme;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLEscapeRoomDAO implements EscapeRoomDAO {
    @Override
    public void create(EscapeRoom escapeRoom) {
        String sql = "INSERT INTO EscapeRoom(name, total_inventory_value, total_ticket_sales) VALUES (?, ?, ?)";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, escapeRoom.getName());
            pstmt.setDouble(2, escapeRoom.getTotal_inventory_value());
            pstmt.setDouble(3, escapeRoom.getTotal_ticket_sales());
            pstmt.executeUpdate();

            System.out.println("EscapeRoom insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public EscapeRoom read(int id) throws SQLException  {
        String sql = "SELECT * FROM EscapeRoom WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new EscapeRoom(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("total_inventory_value"),
                        rs.getDouble("total_ticket_sales")
                );
            }
        }
        return null;
    }

    @Override
    public List<EscapeRoom> readAll() throws SQLException {
        List<EscapeRoom> list = new ArrayList<>();
        String sql = "SELECT * FROM EscapeRoom";
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new EscapeRoom(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("total_inventory_value"),
                        rs.getDouble("total_ticket_sales")
                ));
            }
        }
        return list;
    }

    @Override
    public void update(EscapeRoom escapeRoom) throws SQLException {

        String sql = "UPDATE EscapeRoom SET name = ?, total_inventory_value = ?, total_ticket_sales = ? WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, escapeRoom.getName());
            ps.setDouble(2, escapeRoom.getTotal_inventory_value());
            ps.setDouble(3, escapeRoom.getTotal_ticket_sales());
            ps.setInt(4, escapeRoom.getId());
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
