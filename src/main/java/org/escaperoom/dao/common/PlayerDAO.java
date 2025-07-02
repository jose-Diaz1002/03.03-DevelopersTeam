package org.escaperoom.dao.common;

import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.entity.Player;

import java.sql.SQLException;
import java.util.List;

public interface PlayerDAO {
    void create(Player player) throws SQLException;
    Player read(int id) throws SQLException;
    List<Player> readAll() throws SQLException;
    void update(Player player) throws SQLException;
    void delete(int id) throws SQLException;
}
