package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.DecorationObjectDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Decoration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLDecorationObjectDAO implements DecorationObjectDAO {

    private final Connection connection;
    public MySQLDecorationObjectDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Decoration decoration) throws SQLException {

    }

    @Override
    public Decoration read(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Decoration> readAll() throws SQLException {
        return null;
    }

    @Override
    public void update(Decoration decoration) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
