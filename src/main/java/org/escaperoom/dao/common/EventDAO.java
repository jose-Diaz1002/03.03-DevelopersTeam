package org.escaperoom.dao.common;

import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.entity.Event;

import java.sql.SQLException;
import java.util.List;

public interface EventDAO {
    void create(Event event) throws SQLException;

    Event read(int id) throws SQLException;

    List<Event> readAll() throws SQLException;

    void update(Event event) throws SQLException;

    void delete(int id) throws SQLException;
}
