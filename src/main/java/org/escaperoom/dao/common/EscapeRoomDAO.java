package org.escaperoom.dao.common;

<<<<<<< HEAD
=======

>>>>>>> c3d6979 (feat: cambios en entity)
import org.escaperoom.model.entity.EscapeRoom;

import java.sql.SQLException;
import java.util.List;

public interface EscapeRoomDAO {

    void create(EscapeRoom escapeRoom) throws SQLException;

    EscapeRoom read(int id) throws SQLException;

    List<EscapeRoom> readAll() throws SQLException;

    void update(EscapeRoom escapeRoom) throws SQLException;

    void delete(int id) throws SQLException;
<<<<<<< HEAD
}
=======

}
>>>>>>> c3d6979 (feat: cambios en entity)
