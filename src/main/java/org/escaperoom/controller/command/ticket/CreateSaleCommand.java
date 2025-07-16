package org.escaperoom.controller.command.ticket;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLTicketDAO;
import org.escaperoom.database.ConnectionFactory;
import org.escaperoom.model.entity.Ticket;
import org.escaperoom.service.TicketService;
import org.escaperoom.util.InputReader;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.Instant;

public class CreateSaleCommand implements Command {

    private final InputReader inputReader;
    private final TicketService ticketService;

    public CreateSaleCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        try {
            this.ticketService = new TicketService(new MySQLTicketDAO(ConnectionFactory.getMySQLConnection()));
        } catch (SQLException e) {
            throw new RuntimeException("❌ Error al conectar con la base de datos de tickets", e);
        }
    }

    @Override
    public void execute() {
        try {
            int escapeRoomId = inputReader.readInt("🆔 ID del Escape Room: ");
            int roomId = inputReader.readInt("🆔 ID de la sala: ");
            String playerName = inputReader.readLine("👤 Nombre del jugador: ");
            BigDecimal price = inputReader.readBigDecimal("💶 Precio del ticket (€): ");
            Instant purchaseDate = Instant.now();

            Ticket ticket = new Ticket();
            ticket.setEscapeRoomId(escapeRoomId);
            ticket.setRoomId(roomId);
            ticket.setPlayerName(playerName);
            ticket.setPrice(price);
            ticket.setPurchaseDate(purchaseDate);

            ticketService.createTicket(ticket);

            System.out.println("✅ Ticket registrado correctamente:\n" + ticket);

        } catch (Exception e) {
            System.out.println("❌ Error al crear el ticket: " + e.getMessage());
        }
    }

}
