package org.escaperoom.controller.command.decoration;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.DecorationServiceFactory;
import org.escaperoom.service.DecorationService;
import org.escaperoom.util.InputValidation;

public class DeleteDecorationCommand implements Command {
    private final DecorationService decorationService;

    public DeleteDecorationCommand() {
        this.decorationService = DecorationServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            System.out.println("\n--- Eliminación de Objeto Decorativo ---");
            int decorationId = InputValidation.validateIdInput("ID del objeto decorativo a eliminar: ");
            decorationService.deleteDecoration(decorationId);
            System.out.println("✅ Objeto decorativo con ID " + decorationId + " eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("❌ Error al eliminar el objeto decorativo: " + e.getMessage());
        }
    }
}
