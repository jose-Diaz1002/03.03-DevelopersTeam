package org.escaperoom.dao.interfaces;

import org.escaperoom.model.Clue;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ClueDAO {

    void create(Clue clue) throws SQLException;
    Clue read(int id) throws SQLException;
    List<Clue> readAll() throws SQLException;
    void update(Clue clue) throws SQLException;
    void delete(int id) throws SQLException;
}
