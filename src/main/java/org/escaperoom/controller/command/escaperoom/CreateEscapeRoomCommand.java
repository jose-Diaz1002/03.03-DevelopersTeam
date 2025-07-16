package org.escaperoom.controller.command.escaperoom;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.controller.command.room.CreateRoomCommand;
import org.escaperoom.exception.EscapeRoomCreationException;
import org.escaperoom.factory.EscapeRoomServiceFactory;
import org.escaperoom.model.entity.EscapeRoom;
import org.escaperoom.service.EscapeRoomService;
import org.escaperoom.util.InputValidation;

public class CreateEscapeRoomCommand implements Command {

    private final EscapeRoomService escapeRoomService;

    public CreateEscapeRoomCommand() {
        this.escapeRoomService = EscapeRoomServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            String name = InputValidation.validateStringInput("Nombre del Escape Room: ");

            EscapeRoom escapeRoom = new EscapeRoom();
            escapeRoom.setName(name);

            escapeRoomService.createEscapeRoom(escapeRoom);
            System.out.println("✅ Escape Room creado con ID: " + escapeRoom.getId());

            boolean añadirSala = InputValidation.validateBooleanInput("¿Quieres añadir una sala ahora?");
            if (añadirSala) {
                new CreateRoomCommand(escapeRoom.getId()).execute();
            }

        } catch (EscapeRoomCreationException e) {
            System.out.println("❌ Error al crear el Escape Room: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
