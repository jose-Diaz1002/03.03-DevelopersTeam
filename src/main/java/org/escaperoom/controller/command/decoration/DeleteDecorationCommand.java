package org.escaperoom.controller.command.decoration;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.DecorationServiceFactory;
import org.escaperoom.input.InputReader;
import org.escaperoom.model.service.DecorationService;

public class DeleteDecorationCommand implements Command {

    private final InputReader inputReader;
    private final DecorationService decorationService;

    public DeleteDecorationCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        this.decorationService = DecorationServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            int decorationId = inputReader.readInt("ID del objeto decorativo a eliminar: ");
            decorationService.deleteDecoration(decorationId);
            System.out.println("✅ Objeto decorativo eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("❌ Error al eliminar: " + e.getMessage());
        }
    }
}
