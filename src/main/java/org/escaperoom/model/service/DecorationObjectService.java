package org.escaperoom.model.service;

import org.escaperoom.dao.common.DecorationObjectDAO;
import org.escaperoom.exception.DecorationObjectCreationException;
import org.escaperoom.model.entity.DecorationObject;

public class DecorationObjectService {

    private final DecorationObjectDAO decorationObjectDAO;

    public DecorationObjectService(DecorationObjectDAO decorationObjectDAO) {
        this.decorationObjectDAO = decorationObjectDAO;
    }

    public void createDecorationObject(DecorationObject decorationObject) throws DecorationObjectCreationException {
        decorationObjectDAO.create(decorationObject);
    }
}
