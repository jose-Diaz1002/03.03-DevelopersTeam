package org.escaperoom.controller.command.clue;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLClueDAO;
import org.escaperoom.database.ConnectionFactory;
import org.escaperoom.factory.ClueServiceFactory;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.enums.ClueTheme;
import org.escaperoom.service.ClueService;
import org.escaperoom.util.InputValidation;

import java.math.BigDecimal;
import java.sql.SQLException;

public class CreateClueCommand implements Command {

    private final ClueService clueService;
    private final boolean askRoomId;
    private final int roomId;

    public CreateClueCommand(int roomId) {
        this.clueService = createClueService();
        this.askRoomId = false;
        this.roomId = roomId;
    }

    public CreateClueCommand() {
        this.clueService = createClueService();
        this.askRoomId = true;
        this.roomId = -1;
    }


    private ClueService createClueService() {
        try {
            return new ClueService(new MySQLClueDAO(ConnectionFactory.getMySQLConnection()));
        } catch (SQLException e) {
            throw new RuntimeException("❌ Error al obtener la conexión a la base de datos", e);
        }
    }

    @Override
    public void execute() {
        try {
            int finalRoomId = askRoomId
                    ? InputValidation.validateIdInput("🔍 ID de la sala a la que pertenece la pista: ")
                    : roomId;

            // 🔍 Validamos que la Room exista
            if (!clueService.roomExists(finalRoomId)) {
                System.out.println("❌ La sala con ID " + finalRoomId + " no existe.");
                return;
            }

            System.out.println("🧩 Creando pista para Room ID: " + finalRoomId);

            double priceValue = InputValidation.validatePriceInput("💰 Precio de la pista: ");
            BigDecimal price = BigDecimal.valueOf(priceValue);

            int quantity = InputValidation.validateIntInput("📦 Cantidad disponible: ");

            String themeName = InputValidation.validateEnumInput("🎭 Selecciona la temática:", ClueTheme.class);
            ClueTheme theme = ClueTheme.fromString(themeName);

            Clue clue = new Clue();
            clue.setRoomId(finalRoomId);
            clue.setPrice(price);
            clue.setQuantityAvailable(quantity);
            clue.setTheme(theme);

            clueService.createClue(clue);

            System.out.println("✅ Pista creada con éxito. ID: " + clue.getId());

        } catch (Exception e) {
            System.out.println("❌ Error al crear la pista: " + e.getMessage());
        }
    }



}
