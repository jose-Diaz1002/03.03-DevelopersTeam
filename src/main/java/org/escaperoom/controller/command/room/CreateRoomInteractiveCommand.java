package org.escaperoom.controller.command.room;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLRoomDAO;
import org.escaperoom.database.ConnectionFactory;
import org.escaperoom.exception.RoomCreationException;
import org.escaperoom.util.InputReader;
import org.escaperoom.model.entity.Room;
import org.escaperoom.model.enums.DifficultyLevel;
import org.escaperoom.service.RoomService;

import java.math.BigDecimal;
import java.sql.SQLException;

public class CreateRoomInteractiveCommand implements Command {

    private final InputReader inputReader;
    private final RoomService roomService;


    public CreateRoomInteractiveCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        try {
            this.roomService = new RoomService(new MySQLRoomDAO(ConnectionFactory.getMySQLConnection()));
        } catch (SQLException e) {
            throw new RuntimeException("❌ Error al obtener la conexión a la base de datos", e);
        }


    }

    @Override
    public void execute() {
        try {
            int escapeRoomId = inputReader.readInt("🔍 ID del EscapeRoom al que pertenece la sala: ");

            String name = inputReader.readLine("🏷️ Nombre de la sala: ").trim();
            if (name.isEmpty()) {
                System.out.println("❌ El nombre de la sala no puede estar vacío.");
                return;
            }

            String difficultyInput = inputReader.readLine("🎯 Dificultad (Easy, Medium, Hard, Expert): ").trim();
            DifficultyLevel difficulty;
            try {
                difficulty = DifficultyLevel.fromString(difficultyInput);
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Dificultad inválida. Debe ser: Easy, Medium, Hard o Expert.");
                return;
            }

            BigDecimal price;
            try {
                price = new BigDecimal(inputReader.readLine("💰 Precio: ").trim());
                if (price.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("❌ El precio no puede ser negativo.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Precio inválido. Debe ser un número decimal.");
                return;
            }

            int quantity;
            try {
                quantity = Integer.parseInt(inputReader.readLine("📦 Cantidad disponible: ").trim());
                if (quantity < 0) {
                    System.out.println("❌ La cantidad no puede ser negativa.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Cantidad inválida. Debe ser un número entero.");
                return;
            }

            Room room = new Room(escapeRoomId, name, difficulty, price, quantity);
            roomService.createRoom(room);
            System.out.println("✅ Sala creada con éxito.");

        } catch (RoomCreationException e) {
            System.out.println("❌ Error al crear la sala: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
