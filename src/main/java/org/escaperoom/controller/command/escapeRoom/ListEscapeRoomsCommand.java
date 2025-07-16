package org.escaperoom.controller.command.escapeRoom;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.EscapeRoomServiceFactory;
import org.escaperoom.input.InputReader;
import org.escaperoom.model.entity.EscapeRoom;
import org.escaperoom.model.service.EscapeRoomService;

import java.util.List;

public class ListEscapeRoomsCommand implements Command {
    private final EscapeRoomService escapeRoomService;
    private final InputReader inputReader;

    public ListEscapeRoomsCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        this.escapeRoomService = EscapeRoomServiceFactory.create();
    }
    @Override
    public void execute() {
        List<EscapeRoom> escapeRooms = escapeRoomService.getAllEscapeRooms();
        if (escapeRooms.isEmpty()) {
            System.out.println("No hay Escape Rooms registrados.");
        } else {
            System.out.println("Lista de Escape Rooms:");
            for (EscapeRoom er : escapeRooms) {
                System.out.println(" - " + er);
            }
        }

    }
}
