package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.ClueDAO;

import org.escaperoom.exception.ClueCreationException;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.enums.ClueTheme;

import java.sql.*;
import java.util.ArrayList;
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
        if (clue.getQuantityAvailable() < 0) {
            throw new ClueCreationException("La cantidad disponible no puede ser negativa.");
        }

        String sql = "INSERT INTO Clue (room_id, theme, price, quantity_available) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, clue.getRoomId());
            stmt.setString(2, clue.getTheme().name());
            stmt.setBigDecimal(3, clue.getPrice());
            stmt.setInt(4, clue.getQuantityAvailable());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new ClueCreationException("No se pudo insertar la pista, ninguna fila afectada.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    clue.setId(generatedKeys.getInt(1));
                } else {
                    throw new ClueCreationException("No se pudo obtener el ID generado de la pista.");
                }
            }
        } catch (SQLException e) {
            throw new ClueCreationException("Error al insertar la pista en la base de datos.", e);
        }


    }

    @Override
    public Clue findById(int clueId) throws ClueCreationException {
        String sql = "SELECT * FROM Clue WHERE clue_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, clueId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToClue(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new ClueCreationException("Error al buscar la pista por ID.", e);
        }
    }

    @Override
    public List<Clue> findAll() throws ClueCreationException {
        List<Clue> clues = new ArrayList<>();
        String sql = "SELECT * FROM Clue";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clues.add(mapResultSetToClue(rs));
            }
            return clues;
        } catch (SQLException e) {
            throw new ClueCreationException("Error al obtener todas las pistas.", e);
        }
    }

    @Override
    public void update(Clue clue) throws ClueCreationException {
        String sql = "UPDATE Clue SET theme = ?, price = ?, quantity_available = ? WHERE clue_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, clue.getTheme().name());
            stmt.setBigDecimal(2, clue.getPrice());
            stmt.setInt(3, clue.getQuantityAvailable());
            stmt.setInt(4, clue.getId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new ClueCreationException("No se pudo actualizar la pista, ninguna fila afectada.");
            }
        } catch (SQLException e) {
            throw new ClueCreationException("Error al actualizar la pista.", e);
        }
    }

    @Override
    public void delete(int clueId) throws ClueCreationException {
        String sql = "DELETE FROM Clue WHERE clue_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, clueId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new ClueCreationException("No se encontró la pista para eliminar.");
            }
        } catch (SQLException e) {
            throw new ClueCreationException("Error al eliminar la pista.", e);
        }
    }

    @Override
    public List<Clue> findByRoomId(int roomId) throws ClueCreationException {
        List<Clue> clues = new ArrayList<>();
        String sql = "SELECT * FROM Clue WHERE room_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, roomId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                clues.add(mapResultSetToClue(rs));
            }
            return clues;
        } catch (SQLException e) {
            throw new ClueCreationException("Error al buscar pistas por sala.", e);
        }
    }

    @Override
    public Clue save(Clue clue) throws ClueCreationException {

        if (clue.getId() == 0) {
            create(clue);
        } else {
            update(clue);
        }
        return clue;
    }


    private Clue mapResultSetToClue(ResultSet rs) throws SQLException {
        Clue clue = new Clue();
        clue.setId(rs.getInt("clue_id"));
        clue.setRoomId(rs.getInt("room_id"));
        clue.setTheme(ClueTheme.fromString(rs.getString("theme")));
        clue.setPrice(rs.getBigDecimal("price"));
        clue.setQuantityAvailable(rs.getInt("quantity_available"));
        return clue;
    }


}
