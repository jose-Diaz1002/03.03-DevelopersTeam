package org.escaperoom.dao.common;

<<<<<<< HEAD
import org.escaperoom.model.entity.Decoration;

import java.sql.SQLException;
import java.util.List;

public interface DecorationObjectDAO {
    void create(Decoration decoration) throws SQLException;

    Decoration read(int id) throws SQLException;

    List<Decoration> readAll() throws SQLException;

    void update(Decoration decoration) throws SQLException;

    void delete(int id) throws SQLException;
}