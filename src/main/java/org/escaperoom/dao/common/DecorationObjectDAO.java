package org.escaperoom.dao.common;

import org.escaperoom.model.entity.DecorationObject;

import java.sql.SQLException;
import java.util.List;



public interface DecorationObjectDAO {

    void create(DecorationObject decorationObject) throws SQLException;

    DecorationObject findById(int id) throws SQLException;

    List<DecorationObject> findByRoomId(int roomId) throws SQLException;

    void update(DecorationObject decorationObject) throws SQLException;

    void delete(int id) throws SQLException;
}