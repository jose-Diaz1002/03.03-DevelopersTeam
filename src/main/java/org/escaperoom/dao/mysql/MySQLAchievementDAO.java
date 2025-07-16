package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.AchievementDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Achievement;

import java.sql.*;
import java.util.List;

public class MySQLAchievementDAO implements AchievementDAO {

    private final Connection connection;
    public MySQLAchievementDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Achievement achievement) throws SQLException {
        String sql = "INSERT INTO Achievement (player_id, room_id, description, achievement_date, reward_given) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, achievement.getPlayerId());
            stmt.setInt(2, achievement.getRoomId());
            stmt.setString(3, achievement.getDescription());
            stmt.setObject(4, achievement.getAchievementDate()); // LocalDateTime soportado en JDBC 4.2+
            stmt.setBoolean(5, achievement.isRewardGiven());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No se pudo insertar el Achievement, ninguna fila afectada.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    achievement.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("No se pudo obtener el ID generado del Achievement.");
                }
            }
        }
    }


    @Override
    public Achievement read(int id) throws SQLException {
        // Implementar método read si quieres
        return null;
    }

    @Override
    public List<Achievement> readAll() throws SQLException {
        // Implementar método readAll si quieres
        return null;
    }

    @Override
    public void update(Achievement achievement) throws SQLException {
        // Implementar método update si quieres
    }

    @Override
    public void delete(int id) throws SQLException {
        // Implementar método delete si quieres
    }
}
