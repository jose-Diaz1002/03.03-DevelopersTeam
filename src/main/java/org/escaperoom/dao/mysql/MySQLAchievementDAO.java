package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.AchievementDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Achievement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAchievementDAO implements AchievementDAO {
    private final MySQLConnection mySQLConnection;
    public MySQLAchievementDAO(MySQLConnection mySQLConnection) {
        this.mySQLConnection = mySQLConnection;
    }
    @Override
    public void create(Achievement achievement) throws SQLException {

    }

    @Override
    public Achievement read(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Achievement> readAll() throws SQLException {
        return null;
    }

    @Override
    public void update(Achievement achievement) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
