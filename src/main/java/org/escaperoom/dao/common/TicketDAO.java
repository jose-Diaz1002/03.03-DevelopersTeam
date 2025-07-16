package org.escaperoom.dao.common;

import org.escaperoom.model.entity.Ticket;

import java.sql.SQLException;
import java.util.List;

public interface TicketDAO {
    void create(Ticket ticket) throws SQLException;

    Ticket findById(int id) throws SQLException;

    List<Ticket> findAll() throws SQLException;

    void update(Ticket ticket) throws SQLException;

    void delete(int id) throws SQLException;

    List<Ticket> findByPlayerId(int playerId) throws SQLException;
}
