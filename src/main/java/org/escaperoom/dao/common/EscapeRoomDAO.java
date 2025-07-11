package org.escaperoom.dao.common;


import org.escaperoom.exception.EscapeRoomCreationException;
import org.escaperoom.model.entity.EscapeRoom;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz para la gestión de Escape Rooms.
 * Define los métodos necesarios para crear y leer Escape Rooms.
 */
public interface EscapeRoomDAO {
    void create(EscapeRoom escapeRoom) throws EscapeRoomCreationException;
    List<EscapeRoom> findAll() throws EscapeRoomCreationException;
    void update(EscapeRoom escapeRoom) throws EscapeRoomCreationException;
    void deleteById(int escapeRoomId) throws EscapeRoomCreationException;


    boolean delete(int id);
}