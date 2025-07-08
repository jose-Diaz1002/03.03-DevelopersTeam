package org.escaperoom.controller;

import org.escaperoom.exception.EscapeRoomCreationException;
import org.escaperoom.factory.EscapeRoomServiceFactory;
import org.escaperoom.model.entity.EscapeRoom;
import org.escaperoom.model.service.EscapeRoomService;

import java.math.BigDecimal;
import java.sql.SQLException;

public class EscapeRoomController {

    private final EscapeRoomService escapeRoomService;

    public EscapeRoomController() {
        try {
            this.escapeRoomService = EscapeRoomServiceFactory.createService();
        } catch (SQLException e) {
            throw new RuntimeException("Error creando EscapeRoomService", e);
        }
    }

    public void createEscapeRoom(String name, BigDecimal totalInventoryValue, BigDecimal totalTicketSales) {
        EscapeRoom escapeRoom = new EscapeRoom(name, totalInventoryValue, totalTicketSales);
        try {
            escapeRoomService.createEscapeRoom(escapeRoom);
            System.out.println("EscapeRoom creado con ID: " + escapeRoom.getId());
        } catch (EscapeRoomCreationException e) {
            System.err.println("Error de creación del EscapeRoom: " + e.getMessage());
            // manejar error específico de creación, quizás feedback al usuario
        } catch (Exception e) {
            System.err.println("Error inesperado al crear EscapeRoom: " + e.getMessage());
            // manejar errores no esperados
        }
    }

    // Otros métodos...

}
