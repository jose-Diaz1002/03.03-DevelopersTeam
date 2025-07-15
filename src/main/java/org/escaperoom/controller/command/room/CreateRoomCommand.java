package org.escaperoom.controller.command.room;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLRoomDAO;
import org.escaperoom.database.ConnectionFactory;
import org.escaperoom.exception.RoomCreationException;
import org.escaperoom.input.InputReader;
import org.escaperoom.model.entity.Room;
import org.escaperoom.model.enums.DifficultyLevel;
import org.escaperoom.model.service.RoomService;
import org.escaperoom.input.InputValidator;

import java.math.BigDecimal;
import java.sql.SQLException;

public class CreateRoomCommand implements Command {

    private final RoomService roomService;
    private final InputReader inputReader;
    private final int escapeRoomId;

    public CreateRoomCommand(InputReader inputReader, int escapeRoomId) {
        this.inputReader = inputReader;
        this.escapeRoomId = escapeRoomId;
        try {
            this.roomService = new RoomService(new MySQLRoomDAO(ConnectionFactory.getMySQLConnection()));
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a BD", e);
        }
    }

    @Override
    public void execute() {
        try {
            System.out.println("📦 Creando sala para EscapeRoom ID: " + escapeRoomId);

            String name = InputValidator.readNonEmptyString(inputReader, "Nombre de la sala: ");
            DifficultyLevel difficulty = InputValidator.readDifficultyLevel(inputReader, "Dificultad (Easy, Medium, Hard, Expert): ");
            BigDecimal price = InputValidator.readPositiveBigDecimal(inputReader, "Precio: ");
            int quantity = InputValidator.readPositiveInt(inputReader, "Cantidad disponible: ");

            Room room = new Room(escapeRoomId, name, difficulty, price, quantity);
            roomService.createRoom(room);
            System.out.println("✅ Sala creada con éxito.");

        } catch (IllegalArgumentException | RoomCreationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
