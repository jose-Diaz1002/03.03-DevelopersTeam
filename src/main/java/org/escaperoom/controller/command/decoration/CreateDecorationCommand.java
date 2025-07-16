package org.escaperoom.controller.command.decoration;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.DecorationServiceFactory;
import org.escaperoom.model.entity.DecorationObject;
import org.escaperoom.service.DecorationService;
import org.escaperoom.util.InputValidation;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class CreateDecorationCommand implements Command {

    private final DecorationService decorationService;

    public CreateDecorationCommand() {
        this.decorationService = DecorationServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            System.out.println("\n--- Creación de Objeto Decorativo ---");

            int roomId = InputValidation.validateIdInput("ID de la sala a la que pertenece el objeto decorativo: ");
            String name = InputValidation.validateStringInput("Nombre del objeto decorativo: ");
            String materialType = InputValidation.validateStringInput("Tipo de material: ");
            double priceDouble = InputValidation.validatePriceInput("Precio (€): ");
            BigDecimal price = BigDecimal.valueOf(priceDouble);
            int quantity = InputValidation.validatePositiveIntInput("Cantidad disponible: ");

            DecorationObject decoration = new DecorationObject(roomId, name, materialType, price, quantity);
            decorationService.createDecoration(decoration);

            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));

            System.out.println("✅ Objeto decorativo creado correctamente.");
            System.out.println("Detalles:");
            System.out.println("🆔 Sala: " + roomId);
            System.out.println("🖼️ Nombre: " + name);
            System.out.println("🪵 Material: " + materialType);
            System.out.println("💶 Precio: " + currencyFormat.format(price));
            System.out.println("📦 Cantidad: " + quantity);

        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
