package org.escaperoom.dao.common;

import org.escaperoom.model.entity.EscapeRoom;

import java.sql.SQLException;
import java.util.List;

public interface EscapeRoomDAO {
    void insert(EscapeRoom room) throws SQLException;
    EscapeRoom findById(int id) throws SQLException;
    List<EscapeRoom> findAll() throws SQLException;
    boolean update(EscapeRoom room) throws SQLException;
    boolean delete(int id) throws SQLException;
}
