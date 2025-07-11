package org.escaperoom.dao.common;

import org.escaperoom.exception.ClueCreationException;
import org.escaperoom.model.entity.Clue;

import java.sql.SQLException;
import java.util.List;

public interface ClueDAO {
    void create(Clue clue) throws ClueCreationException;

    Clue findById(int clueId);

    List<Clue> findAll();

    void update(Clue clue);

    void delete(int clueId);

    List<Clue> findByRoomId(int clueId) throws SQLException;

    void add(Clue clue);
}


