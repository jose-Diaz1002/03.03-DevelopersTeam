package org.escaperoom.service.interfaces;

import org.escaperoom.model.User;

public interface TicketService {

    void sellTicket(User user, double price);
    double getTotalRevenue();
}
