package org.escaperoom.controller.command.decoration;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.DecorationServiceFactory;
import org.escaperoom.input.InputReader;
import org.escaperoom.model.entity.DecorationObject;
import org.escaperoom.model.service.DecorationService;

import java.util.List;

public class ListDecorationsCommand implements Command {

    private final InputReader inputReader;
    private final DecorationService decorationService;

    public ListDecorationsCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        this.decorationService = DecorationServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            int roomId = inputReader.readInt("Introduce el ID de la sala para ver sus objetos decorativos: ");
            List<DecorationObject> decorations = decorationService.getDecorationsByRoomId(roomId);

            if (decorations.isEmpty()) {
                System.out.println("❌ No se encontraron objetos decorativos para esta sala.");
            } else {
                decorations.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("❌ Error al listar decoraciones: " + e.getMessage());
        }
    }
}
