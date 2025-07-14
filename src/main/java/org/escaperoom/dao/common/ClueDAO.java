package org.escaperoom.dao.common;

import org.escaperoom.exception.ClueCreationException;
import org.escaperoom.model.entity.Clue;

import java.util.List;

public interface ClueDAO {
    void create(Clue clue) throws ClueCreationException;

    Clue findById(int clueId) throws ClueCreationException;

    List<Clue> findAll() throws ClueCreationException;

    void update(Clue clue) throws ClueCreationException;

    void delete(int clueId) throws ClueCreationException;

    List<Clue> findByRoomId(int roomId) throws ClueCreationException;
}
