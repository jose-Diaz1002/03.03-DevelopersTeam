package org.escaperoom.controller.command.clue;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.exception.ClueCreationException;
import org.escaperoom.factory.ClueServiceFactory;
import org.escaperoom.service.ClueService;
import org.escaperoom.util.InputValidation;

public class DeleteClueCommand implements Command {

    private final ClueService clueService;

    public DeleteClueCommand() {
        this.clueService = ClueServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            int clueId = InputValidation.validateIdInput("🗑️ Introduce el ID de la pista a eliminar: ");

            String confirm = InputValidation.validateStringInput("¿Estás seguro? (s/n): ");
            if (!confirm.equalsIgnoreCase("s")) {
                System.out.println("❌ Operación cancelada.");
                return;
            }

            clueService.deleteClue(clueId);
            System.out.println("✅ Pista eliminada correctamente.");

        } catch (ClueCreationException e) {
            System.out.println("❌ Error al eliminar la pista: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Entrada inválida. Detalles: " + e.getMessage());
        }
    }
}
