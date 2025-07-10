package org.escaperoom.dao.common;

import org.escaperoom.exception.ClueCreationException;
import org.escaperoom.exception.DecorationObjectCreationException;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.entity.DecorationObject;

import java.sql.SQLException;
import java.util.List;

public interface DecorationObjectDAO {
    void create(DecorationObject decorationObject) throws DecorationObjectCreationException;

    DecorationObject findById(int decorationObject);

    List<DecorationObject> findAll();

    void update(DecorationObject decorationObject);

    void delete(int decorationObjectId);

    List<DecorationObject> findByRoomId(int decorationObjectId) throws SQLException;

}


