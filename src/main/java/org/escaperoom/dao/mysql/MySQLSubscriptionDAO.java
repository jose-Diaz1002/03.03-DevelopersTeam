package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.SubscriptionDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Subscription;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLSubscriptionDAO implements SubscriptionDAO {

    @Override
    public void create(Subscription subscription) throws SQLException {

    }

    @Override
    public Subscription read(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Subscription> readAll() throws SQLException {
        return null;
    }

    @Override
    public void update(Subscription subscription) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
