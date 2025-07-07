package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.SubscriptionDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Subscription;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLSubscriptionDAO implements SubscriptionDAO {
    @Override
    public void create(Subscription subscription) {
        String sql = "INSERT INTO Subscription(player_id, event_type_subscribed) VALUES (?, ?)";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, subscription.getPlayerId());
            pstmt.setString(2, subscription.getEventTypeSubscribed());
            pstmt.executeUpdate();

            System.out.println("Subscription insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Subscription read(int id) throws SQLException {
        String sql = "SELECT * FROM Subscription WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Subscription(
                        rs.getInt("id"),
                        rs.getInt("player_id"),
                        rs.getString("event_type_subscribed")
                );
            }
        }
        return null;
    }

    @Override
    public List<Subscription> readAll() throws SQLException {
        List<Subscription> list = new ArrayList<>();
        String sql = "SELECT * FROM Subscription";
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Subscription(
                        rs.getInt("id"),
                        rs.getInt("player_id"),
                        rs.getString("event_type_subscribed")
                ));
            }
        }
        return list;
    }

    @Override
    public void update(Subscription subscription) throws SQLException {

        String sql = "UPDATE Subscription SET player_id = ?, event_type_subscribed = ? WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, subscription.getPlayerId());
            ps.setString(2, subscription.getEventTypeSubscribed());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM Subscription WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }

    }

}
