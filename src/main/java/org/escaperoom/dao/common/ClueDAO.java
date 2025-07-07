package org.escaperoom.dao.common;

import org.escaperoom.model.entity.Clue;

import java.sql.SQLException;
import java.util.List;

public interface ClueDAO {
    void create(Clue clue) throws SQLException;

    Clue read(int id) throws SQLException;

    List<Clue> readAll() throws SQLException;

    void update(Clue clue) throws SQLException;

    void delete(int id) throws SQLException;
}
