package org.escaperoom.dao.common;

import org.escaperoom.model.entity.Achievement;

import java.sql.SQLException;
import java.util.List;

public interface AchievementDAO {
    void create(Achievement achievement) throws SQLException;
    Achievement read(int id) throws SQLException;
    List<Achievement> readAll() throws SQLException;
    void update(Achievement achievement) throws SQLException;
    void delete(int id) throws SQLException;
}
