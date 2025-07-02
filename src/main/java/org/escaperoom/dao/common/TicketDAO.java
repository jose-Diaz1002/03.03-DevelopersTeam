package org.escaperoom.dao.common;

import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.entity.Ticket;

import java.sql.SQLException;
import java.util.List;

public interface TicketDAO {
    void create(Ticket ticket) throws SQLException;
    Ticket read(int id) throws SQLException;
    List<Ticket> readAll() throws SQLException;
    void update(Ticket ticket) throws SQLException;
    void delete(int id) throws SQLException;
}
