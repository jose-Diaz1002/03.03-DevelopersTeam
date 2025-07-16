package org.escaperoom.dao.common;

import org.escaperoom.model.entity.Subscription;

import java.util.List;

public interface SubscriptionDAO {
    void create(Subscription subscription);
    Subscription read(String clientEmail);
    List<Subscription> readAll();
    void update(Subscription subscription);
    void delete(String clientEmail);
}

