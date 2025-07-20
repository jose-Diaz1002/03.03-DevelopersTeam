package org.escaperoom.service;

import org.escaperoom.dao.common.DecorationObjectDAO;
import org.escaperoom.exception.DecorationCreationException;
import org.escaperoom.model.entity.DecorationObject;

import java.util.List;

public class DecorationService {
    private final DecorationObjectDAO decorationDAO;

    public DecorationService(DecorationObjectDAO decorationDAO) {
        this.decorationDAO = decorationDAO;
    }


    public void createDecoration(DecorationObject decoration) throws DecorationCreationException {
        decorationDAO.create(decoration);
    }


    public void updateDecoration(DecorationObject decoration) throws DecorationCreationException {
        decorationDAO.update(decoration);
    }


    public void deleteDecoration(int decorationId) throws DecorationCreationException {
        decorationDAO.delete(decorationId);
    }


    public List<DecorationObject> getDecorationsByRoomId(int roomId) throws DecorationCreationException {
        return decorationDAO.findByRoomId(roomId);
    }


    public DecorationObject getDecorationById(int decorationId) throws DecorationCreationException {
        return decorationDAO.findById(decorationId);
    }
}
