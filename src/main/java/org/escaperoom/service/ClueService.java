package org.escaperoom.service;

import org.escaperoom.dao.common.ClueDAO;
import org.escaperoom.exception.ClueCreationException;
import org.escaperoom.exception.ClueNotFoundException;
import org.escaperoom.model.entity.Clue;

import java.util.List;
import java.util.Optional;

public class ClueService {

    private final ClueDAO clueDAO;

    public ClueService(ClueDAO clueDAO) {
        this.clueDAO = clueDAO;
    }

    public Clue createClue(Clue clue) throws ClueCreationException {
        try {
            return clueDAO.save(clue);
        } catch (Exception e) {
            throw new ClueCreationException("Error creating clue: " + e.getMessage());
        }
    }



}
