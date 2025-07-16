package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.TicketDAO;
import org.escaperoom.model.entity.Ticket;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class MySQLTicketDAO implements TicketDAO {

    private final Connection connection;

    public MySQLTicketDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Ticket ticket) throws SQLException {
        String sql = "INSERT INTO Ticket (escape_room_id, room_id, player_name, price, purchase_date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, ticket.getEscapeRoomId());
            stmt.setInt(2, ticket.getRoomId());
            stmt.setString(3, ticket.getPlayerName());
            stmt.setBigDecimal(4, ticket.getPrice());
            stmt.setTimestamp(5, Timestamp.from(ticket.getPurchaseDate()));

            int affected = stmt.executeUpdate();
            if (affected == 0) throw new SQLException("❌ No se pudo crear el ticket");

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    ticket.setTicketId(keys.getInt(1));
                }
            }
        }
    }

    @Override
    public Ticket findById(int id) throws SQLException {
        String sql = "SELECT * FROM Ticket WHERE ticket_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) return mapResultSet(rs);
            }
        }
        return null;
    }

    @Override
    public List<Ticket> findAll() throws SQLException {
        String sql = "SELECT * FROM Ticket";
        List<Ticket> tickets = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) tickets.add(mapResultSet(rs));
        }
        return tickets;
    }

    @Override
    public void update(Ticket ticket) throws SQLException {
        String sql = "UPDATE Ticket SET escape_room_id = ?, room_id = ?, player_name = ?, price = ?, purchase_date = ? WHERE ticket_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, ticket.getEscapeRoomId());
            stmt.setInt(2, ticket.getRoomId());
            stmt.setString(3, ticket.getPlayerName());
            stmt.setBigDecimal(4, ticket.getPrice());
            stmt.setTimestamp(5, Timestamp.from(ticket.getPurchaseDate()));
            stmt.setInt(6, ticket.getTicketId());

            if (stmt.executeUpdate() == 0) throw new SQLException("❌ No se actualizó el ticket");
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Ticket WHERE ticket_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            if (stmt.executeUpdate() == 0) throw new SQLException("❌ No se eliminó el ticket");
        }
    }

    @Override
    public List<Ticket> findByPlayerId(int playerId) throws SQLException {
        String sql = "SELECT * FROM Ticket WHERE player_name = ?";
        List<Ticket> tickets = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, String.valueOf(playerId));
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) tickets.add(mapResultSet(rs));
            }
        }
        return tickets;
    }

    private Ticket mapResultSet(ResultSet rs) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setTicketId(rs.getInt("ticket_id"));
        ticket.setEscapeRoomId(rs.getInt("escape_room_id"));
        ticket.setRoomId(rs.getInt("room_id"));
        ticket.setPlayerName(rs.getString("player_name"));
        ticket.setPrice(rs.getBigDecimal("price"));
        ticket.setPurchaseDate(rs.getTimestamp("purchase_date").toInstant());
        return ticket;
    }
}
