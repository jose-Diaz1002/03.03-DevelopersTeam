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

    /**
     * Crea un nuevo objeto decorativo.
     * @param decoration Objeto decorativo a crear.
     * @throws DecorationCreationException si ocurre un error al crear.
     */
    public void createDecoration(DecorationObject decoration) throws DecorationCreationException {
        decorationDAO.create(decoration);
    }

    /**
     * Actualiza un objeto decorativo existente.
     * @param decoration Objeto decorativo con datos actualizados.
     * @throws DecorationCreationException si ocurre un error al actualizar.
     */
    public void updateDecoration(DecorationObject decoration) throws DecorationCreationException {
        decorationDAO.update(decoration);
    }

    /**
     * Elimina un objeto decorativo por su ID.
     * @param decorationId ID del objeto decorativo a eliminar.
     * @throws DecorationCreationException si ocurre un error al eliminar.
     */
    public void deleteDecoration(int decorationId) throws DecorationCreationException {
        decorationDAO.delete(decorationId);
    }

    /**
     * Obtiene la lista de objetos decorativos de una sala.
     * @param roomId ID de la sala.
     * @return Lista de objetos decorativos.
     * @throws DecorationCreationException si ocurre un error al obtener los datos.
     */
    public List<DecorationObject> getDecorationsByRoomId(int roomId) throws DecorationCreationException {
        return decorationDAO.findByRoomId(roomId);
    }

    /**
     * Obtiene un objeto decorativo por su ID.
     * @param decorationId ID del objeto decorativo.
     * @return El objeto decorativo o null si no existe.
     * @throws DecorationCreationException si ocurre un error al buscar.
     */
    public DecorationObject getDecorationById(int decorationId) throws DecorationCreationException {
        return decorationDAO.findById(decorationId);
    }
}
