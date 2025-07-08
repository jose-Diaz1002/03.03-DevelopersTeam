package org.escaperoom.dao.mysql;

import org.escaperoom.dao.common.InventoryDAO;

import java.sql.Connection;

public class MySQLInventoryDAO implements InventoryDAO {
    private final Connection connection;

    public MySQLInventoryDAO(Connection connection) {
        this.connection = connection;
    }

}
