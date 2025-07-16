package org.escaperoom.service;

import org.escaperoom.dao.common.TicketDAO;
import org.escaperoom.model.entity.Ticket;

import java.sql.SQLException;
import java.util.List;

public class TicketService {

    private final TicketDAO ticketDAO;

    public TicketService(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public void createTicket(Ticket ticket) throws SQLException {
        validateTicket(ticket);
        ticketDAO.create(ticket);
    }

    public Ticket getTicketById(int ticketId) throws SQLException {
        return ticketDAO.findById(ticketId);
    }

    public List<Ticket> getAllTickets() throws SQLException {
        return ticketDAO.findAll();
    }

    public List<Ticket> getTicketsByPlayerId(int playerId) throws SQLException {
        if (playerId <= 0) throw new IllegalArgumentException("ID de jugador inválido.");
        return ticketDAO.findByPlayerId(playerId);
    }

    public void updateTicket(Ticket ticket) throws SQLException {
        if (ticket.getTicketId() <= 0) throw new IllegalArgumentException("Ticket ID inválido.");
        validateTicket(ticket);
        ticketDAO.update(ticket);
    }

    public void deleteTicket(int ticketId) throws SQLException {
        if (ticketId <= 0) throw new IllegalArgumentException("Ticket ID inválido.");
        ticketDAO.delete(ticketId);
    }

    private void validateTicket(Ticket ticket) {
        if (ticket.getPlayerName() == null || ticket.getPlayerName().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del jugador no puede estar vacío.");
        }
        if (ticket.getPrice() == null || ticket.getPrice().signum() < 0) {
            throw new IllegalArgumentException("El precio debe ser positivo.");
        }
        if (ticket.getPurchaseDate() == null) {
            throw new IllegalArgumentException("La fecha de compra no puede ser nula.");
        }
    }
}
