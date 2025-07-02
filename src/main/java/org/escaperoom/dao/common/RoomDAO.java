package org.escaperoom.dao.common;

import org.escaperoom.model.entity.Room;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO {
    void create(Room room) throws SQLException;
    Room read(int id) throws SQLException;
    List<Room> readAll() throws SQLException;
    void update(Room room) throws SQLException;
    void delete(int id) throws SQLException;
}
