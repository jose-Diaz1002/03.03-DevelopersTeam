package org.escaperoom.controller.command.clue;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.ClueServiceFactory;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.enums.ClueTheme;
import org.escaperoom.service.ClueService;
import org.escaperoom.util.InputValidation;

import java.math.BigDecimal;

public class CreateClueCommand implements Command {

    private final ClueService clueService;

    public CreateClueCommand() {
        this.clueService = ClueServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            int roomId = InputValidation.validateIdInput("ID de la sala a la que pertenece la pista: ");

            // Mejor usar validateEnumInput para seleccionar el tema directamente
            ClueTheme clueTheme = InputValidation.validateEnumInput(
                    "Selecciona el tema de la pista:", ClueTheme.class);

            BigDecimal price = InputValidation.validatePositiveBigDecimal("Precio de la pista (€): ");

            int quantity = InputValidation.validatePositiveIntInput("Cantidad disponible de pistas: ");

            Clue clue = new Clue();
            clue.setRoomId(roomId);
            clue.setTheme(clueTheme);
            clue.setPrice(price);
            clue.setQuantityAvailable(quantity);

            clueService.addClue(clue);
            System.out.println("✅ Pista creada correctamente.");
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
