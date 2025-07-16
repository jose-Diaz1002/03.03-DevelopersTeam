package org.escaperoom.dao.common;

import org.escaperoom.exception.DecorationCreationException;
import org.escaperoom.model.entity.DecorationObject;

import java.util.List;



public interface DecorationObjectDAO {
    void create(DecorationObject decorationObject) throws DecorationCreationException;

    DecorationObject findById(int decorationId) throws DecorationCreationException;

    List<DecorationObject> findByRoomId(int roomId) throws DecorationCreationException;

    void update(DecorationObject decorationObject) throws DecorationCreationException;

    void delete(int decorationId) throws DecorationCreationException;
}