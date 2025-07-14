package org.escaperoom.model.service;

import org.escaperoom.dao.common.DecorationObjectDAO;
import org.escaperoom.exception.DecorationCreationException;
import org.escaperoom.exception.DecorationObjectCreationException;
import org.escaperoom.model.entity.DecorationObject;

import java.sql.SQLException;

public class DecorationObjectService {

    private final DecorationObjectDAO decorationObjectDAO;

    public DecorationObjectService(DecorationObjectDAO decorationObjectDAO) {
        this.decorationObjectDAO = decorationObjectDAO;
    }

    public void addDecorationObject(DecorationObject decorationObject) throws DecorationObjectCreationException {
        if (decorationObject.getName() == null || decorationObject.getName().trim().isEmpty()) {
            throw new DecorationObjectCreationException("El nombre del objeto decorativo no puede estar vacío.");
        }
        if (decorationObject.getPrice() == null || decorationObject.getPrice().doubleValue() < 0) {
            throw new DecorationObjectCreationException("El precio no puede ser negativo.");
        }
        if (decorationObject.getQuantityAvailable() < 0) {
            throw new DecorationObjectCreationException("La cantidad no puede ser negativa.");
        }

        try {
            decorationObjectDAO.create(decorationObject);
        } catch (DecorationCreationException e) {
            throw new RuntimeException(e);
        }
    }

    // Puedes añadir otros métodos, por ejemplo para listar, actualizar o eliminar objetos decorativos
}
