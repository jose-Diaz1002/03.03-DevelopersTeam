package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.ClueDAO;

import org.escaperoom.exception.ClueCreationException;
import org.escaperoom.model.entity.Clue;

import java.sql.*;
import java.util.List;

public class MySQLClueDAO implements ClueDAO {

    private final Connection connection;

    public MySQLClueDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Clue clue) throws ClueCreationException {
        if (clue.getTheme() == null) {
            throw new ClueCreationException("Debe indicar un tema.");
        }
        if (clue.getPrice() == null || clue.getPrice().doubleValue() < 0) {
            throw new ClueCreationException("El precio debe ser un valor positivo.");
        }
        if (clue.getQuantity() < 0) {
            throw new ClueCreationException("La cantidad disponible no puede ser negativa.");
        }

        String sql = "INSERT INTO Clue (room_id, theme, price, quantity_available) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, clue.getRoomId());
            stmt.setString(2, clue.getTheme().name());
            stmt.setBigDecimal(3, clue.getPrice());
            stmt.setInt(4, clue.getQuantity());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new ClueCreationException("No se pudo insertar la pista, ninguna fila afectada.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    clue.setClueId(generatedKeys.getInt(1));
                } else {
                    throw new ClueCreationException("No se pudo obtener el ID generado de la pista.");
                }
            }
        } catch (SQLException e) {
            throw new ClueCreationException("Error al insertar la pista en la base de datos.", e);
        }


    }

    @Override
    public Clue findById(int id) {
        // lógica para buscar una pista por id en MySQL
        return null; // cambiar por el Clue real encontrado
    }

    @Override
    public List<Clue> findAll() {
        return null;
    }

    @Override
    public void update(Clue clue) {

    }

    @Override
    public void delete(int id) {
        //
    }
    @Override
    public List<Clue> findByRoomId(int clueId){
        return null;
    }

    @Override
    public void add(Clue clue) {
        try {
            create(clue);
        } catch (ClueCreationException e) {
            System.err.println("Error al añadir la pista: " + e.getMessage());
        }
    }
}
