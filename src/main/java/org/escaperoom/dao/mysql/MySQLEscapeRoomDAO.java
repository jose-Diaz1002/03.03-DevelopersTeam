package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.EscapeRoomDAO;
import org.escaperoom.model.entity.EscapeRoom;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLEscapeRoomDAO implements EscapeRoomDAO {

    private final Connection connection;

    public MySQLEscapeRoomDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(EscapeRoom room) throws SQLException {
        String sql = "INSERT INTO EscapeRoom (name, total_inventory_value, total_ticket_sales) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, room.getName());
            stmt.setBigDecimal(2, room.getTotalInventoryValue());
            stmt.setBigDecimal(3, room.getTotalTicketSales());
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    room.setId(keys.getInt(1));
                }
            }
        }
    }

    @Override
    public EscapeRoom findById(int id) throws SQLException {
        String sql = "SELECT * FROM EscapeRoom WHERE escape_room_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new EscapeRoom(
                            rs.getInt("escape_room_id"),
                            rs.getString("name"),
                            rs.getBigDecimal("total_inventory_value"),
                            rs.getBigDecimal("total_ticket_sales")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<EscapeRoom> findAll() throws SQLException {
        List<EscapeRoom> rooms = new ArrayList<>();
        String sql = "SELECT * FROM EscapeRoom";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                EscapeRoom room = new EscapeRoom(
                        rs.getInt("escape_room_id"),
                        rs.getString("name"),
                        rs.getBigDecimal("total_inventory_value"),
                        rs.getBigDecimal("total_ticket_sales")
                );
                rooms.add(room);
            }
        }
        return rooms;
    }

    @Override
    public boolean update(EscapeRoom room) throws SQLException {
        String sql = "UPDATE EscapeRoom SET name = ?, total_inventory_value = ?, total_ticket_sales = ? WHERE escape_room_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, room.getName());
            stmt.setBigDecimal(2, room.getTotalInventoryValue());
            stmt.setBigDecimal(3, room.getTotalTicketSales());
            stmt.setInt(4, room.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM EscapeRoom WHERE escape_room_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}
