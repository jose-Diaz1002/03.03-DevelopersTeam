package org.escaperoom.controller.command.ticket;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLTicketDAO;
import org.escaperoom.database.ConnectionFactory;
import org.escaperoom.model.entity.Ticket;
import org.escaperoom.service.TicketService;
import org.escaperoom.util.ConsoleTablePrinter;
import org.escaperoom.util.InputReader;

import java.sql.SQLException;
import java.util.List;

public class ListTicketsByPlayerCommand implements Command {

    private final TicketService ticketService;
    private final InputReader inputReader;

    public ListTicketsByPlayerCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        try {
            this.ticketService = new TicketService(new MySQLTicketDAO(ConnectionFactory.getMySQLConnection()));
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }

    @Override
    public void execute() {
        try {
            int playerId = inputReader.readInt("Introduce ID del jugador: ");
            List<Ticket> tickets = ticketService.getTicketsByPlayerId(playerId);

            ConsoleTablePrinter.printTicketsTable(tickets);

        } catch (SQLException e) {
            System.out.println("❌ Error al consultar tickets: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}