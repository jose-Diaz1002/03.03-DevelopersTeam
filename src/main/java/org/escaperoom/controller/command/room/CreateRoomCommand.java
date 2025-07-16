package org.escaperoom.controller.command.room;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLRoomDAO;
import org.escaperoom.database.ConnectionFactory;
import org.escaperoom.exception.RoomCreationException;
import org.escaperoom.model.entity.Room;
import org.escaperoom.model.enums.DifficultyLevel;
import org.escaperoom.service.RoomService;
import org.escaperoom.util.InputValidation;

import java.math.BigDecimal;
import java.sql.SQLException;

public class CreateRoomCommand implements Command {

    private final RoomService roomService;
    private final boolean askEscapeRoomId;
    private final int escapeRoomId;

    // Constructor para modo interactivo (pregunta escapeRoomId)
    public CreateRoomCommand() {
        this.escapeRoomId = -1;
        this.askEscapeRoomId = true;
        this.roomService = createRoomService();
    }

    // Constructor cuando ya tienes escapeRoomId
    public CreateRoomCommand(int escapeRoomId) {
        this.escapeRoomId = escapeRoomId;
        this.askEscapeRoomId = false;
        this.roomService = createRoomService();
    }

    private RoomService createRoomService() {
        try {
            return new RoomService(new MySQLRoomDAO(ConnectionFactory.getMySQLConnection()));
        } catch (SQLException e) {
            throw new RuntimeException("❌ Error al obtener la conexión a la base de datos", e);
        }
    }

    @Override
    public void execute() {
        try {
            int finalEscapeRoomId = askEscapeRoomId
                    ? InputValidation.validateIdInput("🔍 ID del EscapeRoom al que pertenece la sala: ")
                    : escapeRoomId;

            System.out.println("📦 Creando sala para EscapeRoom ID: " + finalEscapeRoomId);

            String name = InputValidation.validateStringInput("Nombre de la sala: ");

            double priceValue = InputValidation.validatePriceInput("Precio de la sala: ");
            BigDecimal price = BigDecimal.valueOf(priceValue);

            int quantity = InputValidation.validateIntInput("Cantidad disponible: ");

            String difficultyName = InputValidation.validateEnumInput("Selecciona la dificultad:", DifficultyLevel.class);
            DifficultyLevel difficultyLevel = DifficultyLevel.valueOf(difficultyName);

            Room room = new Room();
            room.setName(name);
            room.setEscapeRoomId(finalEscapeRoomId);
            room.setPrice(price);
            room.setQuantityAvailable(quantity);
            room.setDifficultyLevel(difficultyLevel);

            roomService.createRoom(room);

            System.out.println("✅ Sala creada con éxito. ID: " + room.getRoomId());

        } catch (RoomCreationException e) {
            System.out.println("❌ Error al crear la sala: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
