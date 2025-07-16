package org.escaperoom.controller.command.escaperoom;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.exception.EscapeRoomDeletionException;
import org.escaperoom.factory.EscapeRoomServiceFactory;
import org.escaperoom.util.InputReader;
import org.escaperoom.service.EscapeRoomService;

public class DeleteEscapeRoomCommand implements Command {

    private final InputReader inputReader;
    private final EscapeRoomService escapeRoomService;

    public DeleteEscapeRoomCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        this.escapeRoomService = EscapeRoomServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            int id = inputReader.readInt("Introduce el ID del Escape Room a eliminar: ");

            // Confirmación opcional
            String confirm = inputReader.readLine("¿Seguro que quieres eliminar el Escape Room con ID " + id + "? (S/N): ");
            if (!confirm.equalsIgnoreCase("S")) {
                System.out.println("Operación cancelada.");
                return;
            }

            escapeRoomService.deleteEscapeRoomById(id);
            System.out.println("✅ Escape Room eliminado con éxito.");

        } catch (EscapeRoomDeletionException e) {
            System.out.println("❌ Error al eliminar el Escape Room: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado al eliminar el Escape Room: " + e.getMessage());
            e.printStackTrace();  // Para ver detalle en consola durante depuración
        }
    }
}
