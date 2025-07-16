package org.escaperoom.service;

import org.escaperoom.dao.common.ClueDAO;
import org.escaperoom.dao.common.RoomDAO;
import org.escaperoom.dao.mysql.MySQLRoomDAO;
import org.escaperoom.database.ConnectionFactory;
import org.escaperoom.exception.ClueCreationException;
import org.escaperoom.exception.ClueNotFoundException;
import org.escaperoom.model.entity.Clue;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ClueService {

    private final ClueDAO clueDAO;

    public ClueService(ClueDAO clueDAO) {
        this.clueDAO = clueDAO;
    }

    public void createClue(Clue clue) throws ClueCreationException {
        if(clue.getRoomId() <=0){
           throw new ClueCreationException("Debe indicar un IdRoom válido");
        }
        if(clue.getPrice() == null || clue.getPrice().compareTo(BigDecimal.ZERO) < 0){

            throw new ClueCreationException("El precio no puede ser negativo");
        }
        if(clue.getQuantityAvailable()<0){

            throw new ClueCreationException("La cantidad no puede ser negativa");

        }
        clueDAO.create(clue);

    }

    public List<Clue> getCluesByRoomId(int roomId) throws ClueCreationException {
        return clueDAO.findByRoomId(roomId);
    }

    public Clue findClueById(int clueId) throws SQLException, ClueCreationException {
        return clueDAO.findById(clueId);
    }

    public void updateClue(Clue clue) throws ClueCreationException {
        if (clue.getId() <= 0) {
            throw new ClueCreationException("ID de pista inválido para actualización.");
        }

        if (clue.getTheme() == null) {
            throw new ClueCreationException("Debe seleccionar un tema válido.");
        }
        if (clue.getPrice() == null || clue.getPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new ClueCreationException("El precio no puede ser negativo.");
        }
        if (clue.getQuantityAvailable() < 0) {
            throw new ClueCreationException("La cantidad no puede ser negativa.");
        }

        clueDAO.update(clue);

    }

    public void deleteClue(int clueId) throws ClueCreationException {
        clueDAO.delete(clueId);

    }

    public List<Clue> getAllClues() throws ClueCreationException {
        return clueDAO.findAll();
    }

    public boolean roomExists(int roomId) {
        try {
            return new MySQLRoomDAO(ConnectionFactory.getMySQLConnection()).existsById(roomId);
        } catch (SQLException e) {
            System.out.println("❌ Error al validar existencia de Room: " + e.getMessage());
            return false;
        }
    }



}
