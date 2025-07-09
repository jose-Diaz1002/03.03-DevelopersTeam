package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.RoomDAO;
import org.escaperoom.exception.RoomCreationException;
import org.escaperoom.model.entity.Room;
import org.escaperoom.model.enums.DifficultyLevel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLRoomDAO implements RoomDAO {

  private final Connection connection;

  public MySQLRoomDAO(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void create(Room room) throws RoomCreationException {
    if (room.getName() == null || room.getName().trim().isEmpty()) {
      throw new RoomCreationException("El nombre de la sala no puede estar vacío.");
    }
    if (room.getDifficultyLevel() == null) {
      throw new RoomCreationException("Debe asignar un nivel de dificultad a la sala.");
    }
    if (room.getPrice() == null || room.getPrice().doubleValue() < 0) {
      throw new RoomCreationException("El precio debe ser un valor positivo.");
    }
    if (room.getQuantityAvailable() < 0) {
      throw new RoomCreationException("La cantidad disponible no puede ser negativa.");
    }

    String sql = "INSERT INTO Room (escape_room_id, name, difficulty_level, price, quantity_available) VALUES (?, ?, ?, ?, ?)";

    try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      stmt.setInt(1, room.getEscapeRoomId());
      stmt.setString(2, room.getName());
      stmt.setString(3, room.getDifficultyLevel().name());
      stmt.setBigDecimal(4, room.getPrice());
      stmt.setInt(5, room.getQuantityAvailable());

      int affectedRows = stmt.executeUpdate();

      if (affectedRows == 0) {
        throw new RoomCreationException("No se pudo insertar la sala, ninguna fila afectada.");
      }

      try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
        if (generatedKeys.next()) {
          room.setRoomId(generatedKeys.getInt(1));
        } else {
          throw new RoomCreationException("No se pudo obtener el ID generado de la sala.");
        }
      }
    } catch (SQLException e) {
      throw new RoomCreationException("Error al insertar la sala en la base de datos.", e);
    }
  }

  @Override
  public Room findById(int roomId) {
    // Implementar luego si quieres
    return null;
  }

  public List<Room> findByEscapeRoomId(int escapeRoomId) throws SQLException {
    List<Room> rooms = new ArrayList<>();
    String sql = "SELECT * FROM Room WHERE escape_room_id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
      stmt.setInt(1, escapeRoomId);
      try (ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          Room room = new Room(
                  rs.getInt("room_id"),
                  rs.getInt("escape_room_id"),
                  rs.getString("name"),
                  DifficultyLevel.fromString(rs.getString("difficulty_level")),
                  rs.getBigDecimal("price"),
                  rs.getInt("quantity_available")
          );
          rooms.add(room);
        }
      }
    }
    return rooms;
  }

  @Override
  public List<Room> findAll() {
    // Implementar luego si quieres
    return new ArrayList<>();
  }

  @Override
  public void update(Room room) {
    // Implementar luego si quieres
  }

  @Override
  public void delete(int roomId) {
    // Implementar luego si quieres
  }
}
