package org.escaperoom.dao.common;

import org.escaperoom.model.entity.Room;

import java.util.List;

public interface RoomDAO {
    void create(Room room) throws Exception;
    Room findById(int id) throws Exception;
    List<Room> findAll() throws Exception;
    void update(Room room) throws Exception;
    void delete(int id) throws Exception;
}
