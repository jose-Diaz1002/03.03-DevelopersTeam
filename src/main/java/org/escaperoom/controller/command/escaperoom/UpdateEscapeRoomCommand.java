package org.escaperoom.controller.command.escaperoom;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.exception.EscapeRoomCreationException;
import org.escaperoom.factory.EscapeRoomServiceFactory;
import org.escaperoom.util.InputReader;
import org.escaperoom.model.entity.EscapeRoom;
import org.escaperoom.service.EscapeRoomService;

public class UpdateEscapeRoomCommand implements Command {

    private final EscapeRoomService escapeRoomService;
    private final InputReader inputReader;

    public UpdateEscapeRoomCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        this.escapeRoomService = EscapeRoomServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            int id = inputReader.readInt("🔢 Introduce el ID del Escape Room a actualizar: ");
            String newName = inputReader.readLine("✏️ Nuevo nombre del Escape Room: ").trim();

            if (newName.isEmpty()) {
                System.out.println("❌ El nombre no puede estar vacío.");
                return;
            }

            EscapeRoom updatedEscapeRoom = new EscapeRoom();
            updatedEscapeRoom.setId(id);
            updatedEscapeRoom.setName(newName);

            escapeRoomService.updateEscapeRoom(updatedEscapeRoom);
            System.out.println("✅ Escape Room actualizado con éxito.");

        } catch (EscapeRoomCreationException e) {
            System.out.println("❌ Error al actualizar el Escape Room: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
