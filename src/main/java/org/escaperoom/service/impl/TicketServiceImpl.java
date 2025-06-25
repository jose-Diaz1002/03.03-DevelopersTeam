package org.escaperoom.service.impl;

import org.escaperoom.model.User;
import org.escaperoom.service.interfaces.TicketService;

public class TicketServiceImpl implements TicketService {
    @Override
    public void sellTicket(User user, double price) {
        // Crear y registrar un ticket
    }

    @Override
    public double getTotalRevenue() {
        return 0;
    }
}
