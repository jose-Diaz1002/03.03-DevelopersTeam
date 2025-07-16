package org.escaperoom.controller.command.decoration;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.DecorationServiceFactory;
import org.escaperoom.model.entity.DecorationObject;
import org.escaperoom.service.DecorationService;
import org.escaperoom.util.InputValidation;

import java.math.BigDecimal;

public class UpdateDecorationCommand implements Command {

    private final DecorationService decorationService;

    public UpdateDecorationCommand() {
        this.decorationService = DecorationServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            System.out.println("\n--- Actualización de Objeto Decorativo ---");

            int decorationId = InputValidation.validateIdInput("ID del objeto decorativo a actualizar: ");
            String name = InputValidation.validateStringInput("Nuevo nombre: ");
            String materialType = InputValidation.validateStringInput("Nuevo tipo de material: ");
            double priceDouble = InputValidation.validatePriceInput("Nuevo precio: ");
            BigDecimal price = BigDecimal.valueOf(priceDouble);
            int quantity = InputValidation.validateIntInput("Nueva cantidad disponible: ");

            DecorationObject decoration = new DecorationObject();
            decoration.setId(decorationId);
            decoration.setName(name);
            decoration.setMaterialType(materialType);
            decoration.setPrice(price);
            decoration.setQuantityAvailable(quantity);

            decorationService.updateDecoration(decoration);
            System.out.println("✅ Objeto decorativo actualizado correctamente.");
            System.out.println("🆔 ID: " + decorationId);
            System.out.println("🖼️ Nombre: " + name);
            System.out.println("🪵 Material: " + materialType);
            System.out.println("💶 Precio: " + price + " €");
            System.out.println("📦 Cantidad: " + quantity);

        } catch (Exception e) {
            System.out.println("❌ Error inesperado al actualizar el objeto decorativo: " + e.getMessage());
        }
    }
}
