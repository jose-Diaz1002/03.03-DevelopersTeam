package org.escaperoom.model.service;

import org.escaperoom.dao.common.ClueDAO;
import org.escaperoom.exception.ClueCreationException;
import org.escaperoom.model.entity.Clue;

import java.util.List;

public class ClueService {
    private final ClueDAO clueDAO;

    public ClueService(ClueDAO clueDAO) {
        this.clueDAO = clueDAO;
    }

    /**
     * Crea una pista y propaga la excepción si ocurre un error.
     * @param clue Pista a crear
     * @throws ClueCreationException Si hay error al crear la pista
     */
    public void createClue(Clue clue) throws ClueCreationException {
        clueDAO.create(clue);
    }

    /**
     * Crea una pista y maneja internamente la excepción, imprimiendo error.
     * Uso conveniente para llamadas sin manejo externo.
     * @param clue Pista a crear
     */
    public void addClue(Clue clue) {
        try {
            clueDAO.create(clue);
        } catch (ClueCreationException e) {
            System.out.println("❌ Error al crear la pista: " + e.getMessage());
        }
    }

    /**
     * Obtiene la lista de pistas por ID de sala.
     * Retorna lista vacía si hay error.
     * @param roomId ID de la sala
     * @return Lista de pistas asociadas a la sala
     */
    public List<Clue> getCluesByRoomId(int roomId) {
        try {
            return clueDAO.findByRoomId(roomId);
        } catch (ClueCreationException e) {
            System.out.println("❌ Error al obtener pistas por ID de sala: " + e.getMessage());
            return List.of(); // Retorna lista vacía en caso de error
        }
    }

    /**
     * Actualiza una pista existente.
     * @param clue Pista a actualizar
     * @throws ClueCreationException Si hay error al actualizar la pista
     */
    public void updateClue(Clue clue) throws ClueCreationException {
        clueDAO.update(clue);
    }
    /**
     * Elimina una pista por su ID.
     * @param clueId ID de la pista a eliminar
     * @throws ClueCreationException Si hay error al eliminar la pista
     */
    public void deleteClue(int clueId) throws ClueCreationException {
        clueDAO.delete(clueId);
    }
    /**
     * Obtiene una pista por su ID.
     * @param clueId ID de la pista
     * @return Pista encontrada o null si no existe
     * @throws ClueCreationException Si hay error al buscar la pista
     */

    public Clue getClueById(int clueId) throws ClueCreationException {
        return clueDAO.findById(clueId);
    }
}
