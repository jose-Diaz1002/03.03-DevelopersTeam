package org.escaperoom.controller.command.clue;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.ClueServiceFactory;
import org.escaperoom.util.InputReader;
import org.escaperoom.util.InputValidator;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.enums.ClueTheme;
import org.escaperoom.service.ClueService;

import java.math.BigDecimal;

public class CreateClueCommand implements Command {

    private final InputReader inputReader;
    private final ClueService clueService;
    public CreateClueCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        this.clueService = ClueServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            int roomId = InputValidator.readPositiveInt(inputReader, "ID de la sala a la que pertenece la pista: ");
            if (!clueService.isRoomIdValid(roomId)) {
                throw new IllegalArgumentException("❌ ID de sala no válido.");
            }

            ClueTheme clueTheme = InputValidator.readEnum(inputReader, "Tema: ", ClueTheme.class);

            BigDecimal price = InputValidator.readPositiveBigDecimal(inputReader, "Precio: ");
            int quantity = InputValidator.readPositiveInt(inputReader, "Cantidad disponible: ");

            Clue clue = new Clue();
            clue.setRoomId(roomId);
            clue.setTheme(clueTheme);
            clue.setPrice(price);
            clue.setQuantityAvailable(quantity);

            clueService.addClue(clue);
            System.out.println("✅ Pista creada correctamente.");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
