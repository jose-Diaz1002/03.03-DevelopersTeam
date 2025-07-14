package org.escaperoom.controller.command.clue;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.ClueServiceFactory;
import org.escaperoom.input.InputReader;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.enums.ClueTheme;
import org.escaperoom.model.service.ClueService;

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
            int roomId = inputReader.readInt("ID de la sala a la que pertenece la pista: ");
            String themeStr = inputReader.readLine("Tema (Mystery, Horror, Fantasy, Sci-Fi, Historical, Adventure): ");
            ClueTheme clueTheme = ClueTheme.fromString(themeStr);
            BigDecimal price = new BigDecimal(inputReader.readLine("Precio: "));
            int quantity = inputReader.readInt("Cantidad disponible: ");
            if (clueTheme == null) {
                System.out.println("❌ Tema no válido. Por favor, elige uno de los siguientes: Mystery, Horror, Fantasy, Sci-Fi, Historical, Adventure.");
                return;
            }
            Clue clue = new Clue();
            clue.setId(0); // Assuming ID is auto-generated, set to 0 or leave it unset
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
