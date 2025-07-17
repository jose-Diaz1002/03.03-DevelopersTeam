package org.escaperoom.controller.command.room;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.RoomServiceFactory;
import org.escaperoom.service.RoomService;
import org.escaperoom.util.InputReader;
import org.escaperoom.util.InputValidation;

public class DeleteRoomCommand implements Command {

    private final InputReader inputReader;
    private final RoomService roomService;

    public DeleteRoomCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        this.roomService = RoomServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            int roomId = InputValidation.validateIdInput("🗑️ Introduce el ID de la sala a eliminar: ");

            String confirm = inputReader.readLine("¿Estás seguro de eliminar la sala con ID " + roomId + "? (s/n): ");
            if (!confirm.equalsIgnoreCase("s")) {
                System.out.println("❌ Operación cancelada.");
                return;
            }

            roomService.deleteRoom(roomId);
            System.out.println("✅ Sala con ID " + roomId + " eliminada correctamente.");

        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
