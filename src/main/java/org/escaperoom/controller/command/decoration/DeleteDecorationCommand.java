package org.escaperoom.controller.command.decoration;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.exception.DecorationCreationException;
import org.escaperoom.factory.DecorationServiceFactory;
import org.escaperoom.model.entity.DecorationObject;
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



            DecorationObject decoration = decorationService.getDecorationById(decorationId);
            if (decoration == null) {
                System.out.println("❌ No existe ningún objeto decorativo con ese ID.");
                return;
            }


            decorationService.deleteDecoration(decorationId);
            System.out.println("✅ Objeto decorativo con ID " + decorationId + " eliminado correctamente.");
        } catch (DecorationCreationException e) {
            System.out.println("❌ Error al eliminar el objeto decorativo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
