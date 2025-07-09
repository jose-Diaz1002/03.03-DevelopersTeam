package org.escaperoom.dao.common;

import org.escaperoom.exception.RoomCreationException;
import org.escaperoom.model.entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO {
    void create(Room room) throws RoomCreationException;

    Room findById(int roomId);

    List<Room> findAll();

    void update(Room room);

    void delete(int roomId);
}

