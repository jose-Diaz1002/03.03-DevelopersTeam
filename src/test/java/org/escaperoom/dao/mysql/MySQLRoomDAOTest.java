package org.escaperoom.dao.mysql;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Room;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

public class MySQLRoomDAOTest {

    @Test
    public void testCreateRoom() {
        try {
            Connection connection = MySQLConnection.getInstance().getConnection();
            MySQLRoomDAO dao = new MySQLRoomDAO(connection);

            Room room = new Room();
            room.setName("Habitación del Pánico");

            dao.create(room);

            System.out.println("Habitación creada correctamente.");
            assertNotNull(room.getRoomId());
            assertTrue(room.getRoomId() > 0, "La habitación debe tener un ID asignado");

        } catch (Exception e) {
            e.printStackTrace();
            fail("Falló al crear Room: " + e.getMessage());
        }
    }
}