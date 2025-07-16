package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.TicketDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLTicketDAO implements TicketDAO {
    public MySQLTicketDAO(Connection connection) {
    }

    @Override
    public void create(Ticket ticket) throws SQLException {

    }

    @Override
    public Ticket read(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Ticket> readAll() throws SQLException {
        return null;
    }

    @Override
    public void update(Ticket ticket) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
