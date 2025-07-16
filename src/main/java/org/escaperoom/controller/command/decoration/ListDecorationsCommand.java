package org.escaperoom.controller.command.decoration;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.DecorationServiceFactory;
import org.escaperoom.model.entity.DecorationObject;
import org.escaperoom.service.DecorationService;
import org.escaperoom.util.InputValidation;

import java.util.List;

public class ListDecorationsCommand implements Command {

    private final DecorationService decorationService;

    public ListDecorationsCommand() {
        this.decorationService = DecorationServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            System.out.println("\n--- Listado de Objetos Decorativos ---");
            int roomId = InputValidation.validateIdInput("Introduce el ID de la sala para ver sus objetos decorativos: ");
            List<DecorationObject> decorations = decorationService.getDecorationsByRoomId(roomId);

            if (decorations.isEmpty()) {
                System.out.println("❌ No se encontraron objetos decorativos para esta sala.");
            } else {
                System.out.println("📜 Objetos decorativos en la sala ID " + roomId + ":");
                decorations.forEach(decoration -> System.out.println(" - " + decoration));
            }

        } catch (Exception e) {
            System.out.println("❌ Error al listar decoraciones: " + e.getMessage());
        }
    }
}
