package org.escaperoom.model.service;

import org.escaperoom.dao.common.ClueDAO;
import org.escaperoom.exception.ClueCreationException;
import org.escaperoom.model.entity.Clue;

public class ClueService {
    private final ClueDAO clueDAO;

    public ClueService(ClueDAO clueDAO) {
        this.clueDAO = clueDAO;
    }

    public void createClue(Clue clue) throws ClueCreationException {
        clueDAO.create(clue);
    }
}
