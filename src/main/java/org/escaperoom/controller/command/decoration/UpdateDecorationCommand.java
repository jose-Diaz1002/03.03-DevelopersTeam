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

            DecorationObject existingDecoration = decorationService.getDecorationById(decorationId);
            if (existingDecoration == null) {
                System.out.println("❌ No se encontró el objeto decorativo con ID " + decorationId);
                return;
            }

            // Si no quieres permitir cambiar la sala, la mantenemos
            int roomId = existingDecoration.getRoomId();

            String name = InputValidation.validateStringInput("Nuevo nombre (" + existingDecoration.getName() + "): ");
            String materialType = InputValidation.validateStringInput("Nuevo tipo de material (" + existingDecoration.getMaterialType() + "): ");
            double priceDouble = InputValidation.validatePriceInput("Nuevo precio (" + existingDecoration.getPrice() + "): ");
            BigDecimal price = BigDecimal.valueOf(priceDouble);
            int quantity = InputValidation.validateIntInput("Nueva cantidad disponible (" + existingDecoration.getQuantityAvailable() + "): ");

            DecorationObject updatedDecoration = new DecorationObject();
            updatedDecoration.setId(decorationId);
            updatedDecoration.setRoomId(roomId);
            updatedDecoration.setName(name);
            updatedDecoration.setMaterialType(materialType);
            updatedDecoration.setPrice(price);
            updatedDecoration.setQuantityAvailable(quantity);

            decorationService.updateDecoration(updatedDecoration);

            System.out.println("✅ Objeto decorativo actualizado correctamente.");
            System.out.println("🆔 ID: " + decorationId);
            System.out.println("🛋 Sala ID: " + roomId);
            System.out.println("🖼️ Nombre: " + name);
            System.out.println("🪵 Material: " + materialType);
            System.out.println("💶 Precio: " + price + " €");
            System.out.println("📦 Cantidad: " + quantity);

        } catch (Exception e) {
            System.out.println("❌ Error inesperado al actualizar el objeto decorativo: " + e.getMessage());
        }
    }
}
