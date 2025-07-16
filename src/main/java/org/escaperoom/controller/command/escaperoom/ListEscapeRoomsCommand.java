package org.escaperoom.controller.command.escaperoom;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.EscapeRoomServiceFactory;
import org.escaperoom.model.entity.EscapeRoom;
import org.escaperoom.service.EscapeRoomService;
import org.escaperoom.util.ConsoleTablePrinter;
import org.escaperoom.util.InputReader;
import org.escaperoom.util.InputValidation;

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
            System.out.println("❌ No hay Escape Rooms registrados.");
            return;
        }

        ConsoleTablePrinter.printEscapeRoomsTable(escapeRooms);

        boolean verDetalles = InputValidation.validateBooleanInput("¿Quieres ver detalles de un Escape Room? (true/false): ");
        if (verDetalles) {
            int id = InputValidation.validateIdInput("Introduce el ID del Escape Room: ");
            escapeRooms.stream()
                    .filter(er -> er.getId() == id)
                    .findFirst()
                    .ifPresentOrElse(
                            er -> {
                                System.out.println("\n📄 Detalles del Escape Room:");
                                ConsoleTablePrinter.printEscapeRoomDetails(er);
                            },
                            () -> System.out.println("❌ No se encontró un Escape Room con ID: " + id)
                    );
        }
    }

}
