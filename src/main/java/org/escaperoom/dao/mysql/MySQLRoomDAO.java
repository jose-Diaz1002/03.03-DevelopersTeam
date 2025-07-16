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
    String sql = "INSERT INTO Room (escape_room_id, name, difficulty_level, price, quantity_available) VALUES (?, ?, ?, ?, ?)";

    try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
      stmt.setInt(1, room.getEscapeRoomId());
      stmt.setString(2, room.getName());
      stmt.setString(3, room.getDifficultyLevel().name());
      stmt.setBigDecimal(4, room.getPrice());
      stmt.setInt(5, room.getQuantityAvailable());

      int affectedRows = stmt.executeUpdate();
      if (affectedRows == 0) throw new RoomCreationException("No se pudo insertar la sala.");

      try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
        if (generatedKeys.next()) {
          room.setRoomId(generatedKeys.getInt(1));
        } else {
          throw new RoomCreationException("No se pudo obtener el ID generado.");
        }
      }
    } catch (SQLException e) {
      throw new RoomCreationException("Error al insertar la sala.", e);
    }
  }

  @Override
  public Room findById(int roomId) {
    String sql = "SELECT * FROM Room WHERE room_id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
      stmt.setInt(1, roomId);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          return new Room(
                  rs.getInt("room_id"),
                  rs.getInt("escape_room_id"),
                  rs.getString("name"),
                  DifficultyLevel.fromString(rs.getString("difficulty_level")),
                  rs.getBigDecimal("price"),
                  rs.getInt("quantity_available")
          );
        }
      }
    } catch (SQLException e) {
      System.out.println("❌ Error al buscar sala por ID: " + e.getMessage());
    }
    return null;
  }

  @Override
  public List<Room> findAll() {
    List<Room> rooms = new ArrayList<>();
    String sql = "SELECT * FROM Room";
    try (PreparedStatement stmt = connection.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
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
    } catch (SQLException e) {
      System.out.println("❌ Error al listar salas: " + e.getMessage());
    }
    return rooms;
  }

  @Override
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
  public Room update(Room room) {
    String sql = "UPDATE Room SET name = ?, difficulty_level = ?, price = ?, quantity_available = ? WHERE room_id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
      stmt.setString(1, room.getName());
      stmt.setString(2, room.getDifficultyLevel().name());
      stmt.setBigDecimal(3, room.getPrice());
      stmt.setInt(4, room.getQuantityAvailable());
      stmt.setInt(5, room.getRoomId());

      int affectedRows = stmt.executeUpdate();
      if (affectedRows > 0) {
        return findById(room.getRoomId());
      }
    } catch (SQLException e) {
      System.out.println("❌ Error al actualizar sala: " + e.getMessage());
    }
    return null;
  }

  @Override
  public void delete(int roomId) {
    String sql = "DELETE FROM Room WHERE room_id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
      stmt.setInt(1, roomId);
      stmt.executeUpdate();
    } catch (SQLException e) {
      System.out.println("❌ Error al eliminar sala: " + e.getMessage());
    }
  }

  @Override
  public boolean existsById(int id) {
    String sql = "SELECT COUNT(*) FROM Room WHERE room_id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        return rs.getInt(1) > 0;
      }
    } catch (SQLException e) {
      System.out.println("❌ Error al verificar existencia de la sala: " + e.getMessage());
    }
    return false;
  }

}
