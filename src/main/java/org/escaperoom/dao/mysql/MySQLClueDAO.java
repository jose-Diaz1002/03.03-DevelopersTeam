package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.ClueDAO;

import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.enums.ClueTheme;
import org.escaperoom.model.entity.Clue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLClueDAO implements ClueDAO {

    @Override
    public void create(Clue clue) throws SQLException {

    }

    @Override
    public Clue read(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Clue> readAll() throws SQLException {
        return null;
    }

    @Override
    public void update(Clue clue) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
