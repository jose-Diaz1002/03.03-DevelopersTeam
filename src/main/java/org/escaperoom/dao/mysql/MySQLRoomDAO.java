package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.RoomDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Room;
import org.escaperoom.model.enums.DifficultyLevel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLRoomDAO implements RoomDAO {
  @Override
  public void create(Room room) throws SQLException {


  }

  @Override
  public Room read(int id) throws SQLException {
    return null;
  }

  @Override
  public List<Room> readAll() throws SQLException {
    return null;
  }

  @Override
  public void update(Room room) throws SQLException {

  }

  @Override
  public void delete(int id) throws SQLException {

  }
}
