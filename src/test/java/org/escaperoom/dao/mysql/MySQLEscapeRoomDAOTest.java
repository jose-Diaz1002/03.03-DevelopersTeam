package org.escaperoom.dao.mysql;

import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.EscapeRoom;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class MySQLEscapeRoomDAOTest {

    @Test
    public void testCreateEscapeRoom() {
        try {
            Connection connection = MySQLConnection.getInstance().getConnection();
            MySQLEscapeRoomDAO dao = new MySQLEscapeRoomDAO(connection);

            EscapeRoom escapeRoom = new EscapeRoom("Sala Egipcia", new BigDecimal("1200.00"), new BigDecimal("450.00"));
            dao.create(escapeRoom);

            assertTrue(escapeRoom.getId() > 0, "El EscapeRoom debe tener un ID asignado");
            System.out.println("EscapeRoom creado con ID: " + escapeRoom.getId());

        } catch (Exception e) {
            e.printStackTrace();
            fail("Fallo al crear EscapeRoom: " + e.getMessage());
        }
    }
}
