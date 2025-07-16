package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.EventDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLEventDAO implements EventDAO {


    @Override
    public void create(Event event) throws SQLException {

    }

    @Override
    public Event read(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Event> readAll() throws SQLException {
        return null;
    }

    @Override
    public void update(Event event) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
