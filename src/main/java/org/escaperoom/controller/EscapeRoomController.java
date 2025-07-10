package org.escaperoom.controller;

import org.escaperoom.exception.EscapeRoomCreationException;
import org.escaperoom.input.InputReader;
import org.escaperoom.model.entity.EscapeRoom;
import org.escaperoom.model.service.EscapeRoomService;

import java.math.BigDecimal;
import java.sql.SQLException;

public class EscapeRoomController {

    private final EscapeRoomService escapeRoomService;
    private final InputReader inputReader;

    public EscapeRoomController(EscapeRoomService escapeRoomService, InputReader inputReader) {
        this.escapeRoomService = escapeRoomService;
        this.inputReader = inputReader;
    }
/*
    public void createEscapeRoomFlow() {
        System.out.println("Introduce el nombre del Escape Room:");
        String name = inputReader.readString();

        EscapeRoom escapeRoom = new EscapeRoom(name);
        try {
            escapeRoomService.createEscapeRoom(escapeRoom);

            // Inicializa valores a cero
            escapeRoomService.updateInventoryValue(escapeRoom.getId(), BigDecimal.ZERO);
            escapeRoomService.updateTicketSales(escapeRoom.getId(), BigDecimal.ZERO);

            System.out.println("Escape Room creado correctamente: " + escapeRoom);
        } catch (EscapeRoomCreationException e) {
            System.err.println("Error creando EscapeRoom: " + e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException("Error al inicializar valores del EscapeRoom", e);
        }
    }


    public void showEscapeRoomById() {
        System.out.println("Introduce el ID del Escape Room:");
        int id = Integer.parseInt(inputReader.readString());
        EscapeRoom escapeRoom = escapeRoomService.getEscapeRoomById(id);
        if (escapeRoom != null) {
            System.out.println(escapeRoom);
        } else {
            System.out.println("EscapeRoom no encontrado.");
        }
    }

    public int selectEscapeRoom() {
        System.out.println("Selecciona un Escape Room por ID:");
        int id = Integer.parseInt(inputReader.readString());
        try {
            EscapeRoom escapeRoom = escapeRoomService.getEscapeRoomById(id);
            if (escapeRoom != null) {
                System.out.println("Escape Room seleccionado: " + escapeRoom);
                return escapeRoom.getId();
            } else {
                System.out.println("Escape Room no encontrado.");
                return -1;
            }
        } catch (SQLException e) {
            System.err.println("Error al seleccionar EscapeRoom: " + e.getMessage());
            return -1;
        }
    }


 */
}
