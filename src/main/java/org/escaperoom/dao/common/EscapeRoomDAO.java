package org.escaperoom.dao.common;

import org.escaperoom.exception.EscapeRoomCreationException;
import org.escaperoom.model.entity.EscapeRoom;

import java.util.List;


public interface EscapeRoomDAO {
    void create(EscapeRoom escapeRoom) throws EscapeRoomCreationException;
    List<EscapeRoom> findAll() throws EscapeRoomCreationException;
    void update(EscapeRoom escapeRoom) throws EscapeRoomCreationException;
    void deleteById(int escapeRoomId) throws EscapeRoomCreationException;
}
