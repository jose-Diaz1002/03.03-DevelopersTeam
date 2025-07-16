package org.escaperoom.dao.mysql;

import org.escaperoom.model.entity.Ticket;
import org.escaperoom.database.MySQLConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class MySQLTicketDAOTest {

    private Connection connection;

    @BeforeEach
    void setUp() throws Exception {
        MySQLConnection mySQLConnection = new MySQLConnection();
        connection = mySQLConnection.getConnection();
    }

    @Test
    public void testCreateTicket() {
        try {
            MySQLTicketDAO dao = new MySQLTicketDAO(connection);

            Ticket ticket = new Ticket();
            ticket.setRoomId(1);  // Usa un ID válido existente en tu BD
            ticket.setPlayerName("Jugador 1");
            ticket.setPurchaseDate(Instant.now());
            ticket.setPrice(BigDecimal.valueOf(50.00));

            dao.create(ticket);

            assertNotNull(ticket.getTicketId());
            assertTrue(ticket.getTicketId() > 0);
            System.out.println("Ticket creado con ID: " + ticket.getTicketId());

        } catch (Exception e) {
            e.printStackTrace();
            fail("Falló al crear Ticket: " + e.getMessage());
        }
    }
}