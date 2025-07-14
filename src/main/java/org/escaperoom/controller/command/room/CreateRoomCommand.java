package org.escaperoom.controller.command.room;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLRoomDAO;
import org.escaperoom.database.ConnectionFactory;
import org.escaperoom.exception.RoomCreationException;
import org.escaperoom.input.InputReader;
import org.escaperoom.model.entity.Room;
import org.escaperoom.model.enums.DifficultyLevel;
import org.escaperoom.model.service.RoomService;

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

            String name = inputReader.readLine("Nombre de la sala: ").trim();
            if (name.isEmpty()) {
                System.out.println("❌ El nombre de la sala no puede estar vacío.");
                return;
            }

            String diffInput = inputReader.readLine("Dificultad (Easy, Medium, Hard, Expert): ").trim();
            DifficultyLevel difficulty;
            if (diffInput.isEmpty()) {
                System.out.println("❌ La dificultad no puede estar vacía.");
                return;
            }

            try {
                difficulty = DifficultyLevel.fromString(diffInput);
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Dificultad inválida. Debe ser: Easy, Medium, Hard o Expert.");
                return;
            }

            String priceInput = inputReader.readLine("Precio: ");
            BigDecimal price;
            try {
                price = new BigDecimal(priceInput.trim());
                if (price.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("❌ El precio no puede ser negativo.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Precio inválido. Debe ser un número decimal válido.");
                return;
            }

            String quantityInput = inputReader.readLine("Cantidad disponible: ");
            int quantity;
            try {
                quantity = Integer.parseInt(quantityInput.trim());
                if (quantity < 0) {
                    System.out.println("❌ La cantidad no puede ser negativa.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Cantidad inválida. Debe ser un número entero válido.");
                return;
            }

            Room room = new Room(escapeRoomId, name, difficulty, price, quantity);
            roomService.createRoom(room);
            System.out.println("✅ Sala creada con éxito.");

        } catch (RoomCreationException e) {
            System.out.println("❌ Error al crear sala: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
