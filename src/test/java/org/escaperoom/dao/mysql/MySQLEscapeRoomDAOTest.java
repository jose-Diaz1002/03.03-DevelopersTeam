package org.escaperoom.dao.mysql;

import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.EscapeRoom;
import org.escaperoom.model.entity.Room;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class MySQLEscapeRoomAndRoomDAOTest {

    private static Connection connection;
    private static MySQLEscapeRoomDAO escapeRoomDAO;
    private static MySQLRoomDAO roomDAO;

    @BeforeAll
    static void setUp() throws Exception {
        connection = MySQLConnection.getInstance().getConnection();
        escapeRoomDAO = new MySQLEscapeRoomDAO(connection);
        roomDAO = new MySQLRoomDAO(connection);
    }

    @Test
    void testInsertEscapeRoomAndRoom() throws Exception {
        // Crear e insertar EscapeRoom
        EscapeRoom room1 = new EscapeRoom("Prueba DAO", new BigDecimal("500.00"), new BigDecimal("1000.00"));
        escapeRoomDAO.insert(room1);
        assertTrue(room1.getId() > 0, "EscapeRoom ID no fue generado correctamente");

        // Crear e insertar Room vinculada al EscapeRoom
        Room sala = new Room("Sala Fantasma", 6, room1.getId());
        roomDAO.insert(sala);
        assertTrue(sala.getId() > 0, "Room ID no fue generado correctamente");

        // Recuperar y verificar EscapeRoom
        EscapeRoom loadedEscapeRoom = escapeRoomDAO.findById(room1.getId());
        assertNotNull(loadedEscapeRoom);
        assertEquals("Prueba DAO", loadedEscapeRoom.getName());

        // Recuperar y verificar Room
        Room loadedRoom = roomDAO.findById(sala.getId());
        assertNotNull(loadedRoom);
        assertEquals("Sala Fantasma", loadedRoom.getName());
        assertEquals(room1.getId(), loadedRoom.getEscapeRoomId());
    }
}
