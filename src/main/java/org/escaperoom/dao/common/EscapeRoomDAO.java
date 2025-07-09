package org.escaperoom.dao.common;


import org.escaperoom.exception.EscapeRoomCreationException;
import org.escaperoom.model.entity.EscapeRoom;

/**
 * Interfaz para la gestión de Escape Rooms.
 * Define los métodos necesarios para crear y leer Escape Rooms.
 */
public interface EscapeRoomDAO {
    void create(EscapeRoom escapeRoom) throws EscapeRoomCreationException;
  //  EscapeRoom read (int id) throws SQLException;
    // List<EscapeRoom> readAll() throws SQLException;
    // void update(EscapeRoom escapeRoom) throws SQLException;
    // void delete(int id) throws SQLException;
}