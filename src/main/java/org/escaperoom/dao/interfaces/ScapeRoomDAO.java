package org.escaperoom.dao.interfaces;

import org.escaperoom.model.ScapeRoom;

import java.sql.SQLException;
import java.util.List;

public interface ScapeRoomDAO {
    void create(ScapeRoom scapeRoom) throws SQLException;
    ScapeRoom read(int id) throws SQLException;
    List<ScapeRoom> readAll() throws SQLException;
    void update(ScapeRoom scapeRoom) throws SQLException;
    void delete(int id) throws SQLException;
}
