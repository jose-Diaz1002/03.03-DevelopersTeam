package org.escaperoom.dao.common;


import org.escaperoom.exception.EscapeRoomCreationException;
import org.escaperoom.model.entity.EscapeRoom;

import java.sql.SQLException;
import java.util.List;

public interface EscapeRoomDAO {
    void create(EscapeRoom escapeRoom) throws EscapeRoomCreationException;
}