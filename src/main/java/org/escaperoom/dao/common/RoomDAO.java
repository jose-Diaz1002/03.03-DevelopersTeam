package org.escaperoom.dao.common;

import org.escaperoom.exception.RoomCreationException;
import org.escaperoom.model.entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO {
    void create(Room room) throws RoomCreationException;

    Room findById(int roomId);

    List<Room> findAll();

    Room update(Room room);

    void delete(int roomId);

    List<Room> findByEscapeRoomId(int escapeRoomId) throws SQLException;

    boolean existsById(int id) throws SQLException;

}

