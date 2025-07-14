package org.escaperoom.controller.command.decoration;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.exception.DecorationCreationException;
import org.escaperoom.factory.DecorationServiceFactory;
import org.escaperoom.input.InputReader;
import org.escaperoom.model.entity.DecorationObject;
import org.escaperoom.model.service.DecorationService;

import java.math.BigDecimal;

public class UpdateDecorationCommand implements Command {

    private final InputReader inputReader;
    private final DecorationService decorationService;

    public UpdateDecorationCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        this.decorationService = DecorationServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            int decorationId = inputReader.readInt("ID del objeto decorativo a actualizar: ");
            String name = inputReader.readLine("Nuevo nombre: ").trim();
            String materialType = inputReader.readLine("Nuevo tipo de material: ").trim();
            BigDecimal price = new BigDecimal(inputReader.readLine("Nuevo precio: ").trim());
            int quantity = inputReader.readInt("Nueva cantidad disponible: ");

            DecorationObject decoration = new DecorationObject();
            decoration.setId(decorationId);
            decoration.setName(name);
            decoration.setMaterialType(materialType);
            decoration.setPrice(price);
            decoration.setQuantityAvailable(quantity);

            decorationService.updateDecoration(decoration);
            System.out.println("✅ Objeto decorativo actualizado correctamente.");
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
