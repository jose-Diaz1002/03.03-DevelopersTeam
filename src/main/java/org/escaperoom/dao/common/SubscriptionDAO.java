package org.escaperoom.dao.common;

import org.escaperoom.model.entity.Subscription;

import java.sql.SQLException;
import java.util.List;

public interface SubscriptionDAO {

    void create(Subscription subscription) throws SQLException;

    Subscription read(int id) throws SQLException;

    List<Subscription> readAll() throws SQLException;

    void update(Subscription subscription) throws SQLException;

    void delete(int id) throws SQLException;


}
