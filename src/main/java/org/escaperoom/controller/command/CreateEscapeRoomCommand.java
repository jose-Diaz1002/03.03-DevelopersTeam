package org.escaperoom.controller.command;

import org.escaperoom.model.entity.EscapeRoom;
import org.escaperoom.model.service.EscapeRoomService;

import java.math.BigDecimal;

public class CreateEscapeRoomCommand implements Command {

    private final EscapeRoomService escapeRoomService;
    private final EscapeRoom escapeRoom;

    public CreateEscapeRoomCommand(EscapeRoomService service, EscapeRoom escapeRoom) {
        this.escapeRoomService = service;
        this.escapeRoom = escapeRoom;
    }

    @Override
    public void execute() {
        try {
            escapeRoomService.createEscapeRoom(escapeRoom);
            System.out.println("EscapeRoom creado con ID: " + escapeRoom.getId());
        } catch (Exception e) {
            System.err.println("Error creando EscapeRoom: " + e.getMessage());
        }
    }
}
