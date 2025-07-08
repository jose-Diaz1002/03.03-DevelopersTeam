package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.PlayerDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLPlayerDAO implements PlayerDAO {
    @Override
    public void create(Player player) throws SQLException {

    }

    @Override
    public Player read(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Player> readAll() throws SQLException {
        return null;
    }

    @Override
    public void update(Player player) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
