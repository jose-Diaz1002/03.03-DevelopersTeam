package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.EventDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLEventDAO implements EventDAO {
    @Override
    public void create(Event event) {
        String sql = "INSERT INTO Event(event_type, event_description, event_date) VALUES (?, ?, ?)";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, event.getEventType());
            pstmt.setString(2, event.getEventDescription());
            pstmt.setTimestamp(4, Timestamp.valueOf(event.getEventDate()));

            pstmt.executeUpdate();

            System.out.println("Event insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Event read(int id) throws SQLException {
        String sql = "SELECT * FROM Event WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Event(
                        rs.getInt("id"),
                        rs.getString("event_type"),
                        rs.getString("event_description"),
                        rs.getTimestamp("event_date").toLocalDateTime()
                );
            }
        }
        return null;
    }

    @Override
    public List<Event> readAll() throws SQLException {
        List<Event> list = new ArrayList<>();
        String sql = "SELECT * FROM Event";
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Event(
                        rs.getInt("id"),
                        rs.getString("event_type"),
                        rs.getString("event_description"),
                        rs.getTimestamp("event_date").toLocalDateTime()
                ));
            }
        }
        return list;
    }

    @Override
    public void update(Event event) throws SQLException {

        String sql = "UPDATE Event SET event_type = ?, event_description = ?, event_date = ? WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, event.getEventType());
            ps.setString(2, event.getEventDescription());
            ps.setTimestamp(4, Timestamp.valueOf(event.getEventDate()));
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM EscapeRoom WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }

    }
}
