package org.escaperoom.controller.command.decoration;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.DecorationServiceFactory;
import org.escaperoom.util.InputReader;
import org.escaperoom.util.InputValidator;
import org.escaperoom.model.entity.DecorationObject;
import org.escaperoom.service.DecorationService;

import java.math.BigDecimal;

public class CreateDecorationCommand implements Command {

    private final InputReader inputReader;
    private final DecorationService decorationService;

    public CreateDecorationCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        this.decorationService = DecorationServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            int roomId = InputValidator.readPositiveInt(inputReader, "ID de la sala a la que pertenece el objeto decorativo: ");
            String name = inputReader.readLine("Nombre del objeto decorativo: ").trim();
            String materialType = inputReader.readLine("Tipo de material: ").trim();
            BigDecimal price = new BigDecimal(inputReader.readLine("Precio: ").trim());
            int quantity = inputReader.readInt("Cantidad disponible: ");

            DecorationObject decoration = new DecorationObject(roomId, name, materialType, price, quantity);
            decorationService.createDecoration(decoration);

            System.out.println("✅ Objeto decorativo creado correctamente.");
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
