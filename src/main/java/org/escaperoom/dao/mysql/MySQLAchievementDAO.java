package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.AchievementDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Achievement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAchievementDAO implements AchievementDAO {
    @Override
    public void create(Achievement achievement) {
        String sql = "INSERT INTO Achievement (player_id, room_id, description, achievement_date, reward_given) VALUES (?, ?, ?, ?)";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, achievement.getPlayerId());
            pstmt.setInt(2, achievement.getRoomId());
            pstmt.setString(3, achievement.getDescription());
            pstmt.setTimestamp(4, Timestamp.valueOf(achievement.getAchievementDate()));
            pstmt.setBoolean(5, achievement.isRewardGiven());

            System.out.println("Achievement insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Achievement read(int id) throws SQLException {
        String sql = "SELECT * FROM Achievement WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Achievement(
                        rs.getInt("id"),
                        rs.getInt("player_id"),
                        rs.getInt("room_id"),
                        rs.getString("description"),
                        rs.getTimestamp("achievement_date").toLocalDateTime(),
                        rs.getBoolean("reward_given")
                );
            }
        }
        return null;
    }

    @Override
    public List<Achievement> readAll() throws SQLException {
        List<Achievement> list = new ArrayList<>();
        String sql = "SELECT * FROM Achievement";
        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Achievement(
                        rs.getInt("id"),
                        rs.getInt("player_id"),
                        rs.getInt("room_id"),
                        rs.getString("description"),
                        rs.getTimestamp("achievement_date").toLocalDateTime(),
                        rs.getBoolean("reward_given")
                ));
            }
        }
        return list;
    }

    @Override
    public void update(Achievement achievement) throws SQLException {

        String sql = "UPDATE Achievement SET player_id= ?, room_id= ?, description= ?, achievement_date= ?, reward_given= ? WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, achievement.getPlayerId());
            ps.setInt(2, achievement.getRoomId());
            ps.setString(3, achievement.getDescription());
            ps.setTimestamp(4, Timestamp.valueOf(achievement.getAchievementDate()));
            ps.setBoolean(5, achievement.isRewardGiven());
        }
    }

    @Override
    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM Achievement WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }

    }
}
