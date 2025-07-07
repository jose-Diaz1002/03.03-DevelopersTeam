package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.TicketDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLTicketDAO implements TicketDAO {
    @Override
    public void create(Ticket ticket) {
        String sql = "INSERT INTO Ticket(room_id, player_id, purchase_date, total_amount) VALUES (?, ?, ?, ?)";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ticket.getRoomId());
            pstmt.setInt(2, ticket.getPlayerId());
            pstmt.setTimestamp(3, Timestamp.valueOf(ticket.getPurchaseDate()));
            pstmt.setDouble(4, ticket.getTotalAmount());

            System.out.println("Ticket insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Ticket read(int id) throws SQLException {
        String sql = "SELECT * FROM Ticket WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Ticket(
                        rs.getInt("id"),
                        rs.getInt("room_id"),
                        rs.getInt("player_id"),
                        rs.getTimestamp("purchase_date").toLocalDateTime(),
                        rs.getDouble("reward_given")
                );
            }
        }
        return null;
    }

    @Override
    public List<Ticket> readAll() throws SQLException {
        List<Ticket> list = new ArrayList<>();
        String sql = "SELECT * FROM Achievement";
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Ticket(
                        rs.getInt("id"),
                        rs.getInt("room_id"),
                        rs.getInt("player_id"),
                        rs.getTimestamp("purchase_date").toLocalDateTime(),
                        rs.getDouble("reward_given")
                ));
            }
        }
        return list;
    }

    @Override
    public void update(Ticket ticket) throws SQLException {

        String sql = "UPDATE Ticket SET room_id = ?, player_id = ?, purchase_date = ?, total_amount = ? WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ticket.getRoomId());
            ps.setInt(2, ticket.getPlayerId());
            ps.setTimestamp(3, Timestamp.valueOf(ticket.getPurchaseDate()));
            ps.setDouble(4, ticket.getTotalAmount());
        }
    }

    @Override
    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM Ticket WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }

    }
}
