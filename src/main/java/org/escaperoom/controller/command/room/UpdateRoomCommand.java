package org.escaperoom.controller.command.room;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLRoomDAO;
import org.escaperoom.database.ConnectionFactory;
import org.escaperoom.exception.RoomUpdateException;
import org.escaperoom.model.entity.Room;
import org.escaperoom.model.enums.DifficultyLevel;
import org.escaperoom.service.RoomService;
import org.escaperoom.util.ConsoleTablePrinter;
import org.escaperoom.util.InputReader;
import org.escaperoom.util.InputValidation;

import java.math.BigDecimal;
import java.sql.SQLException;

public class UpdateRoomCommand implements Command {

    private final InputReader inputReader;
    private final RoomService roomService;

    public UpdateRoomCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        try {
            this.roomService = new RoomService(new MySQLRoomDAO(ConnectionFactory.getMySQLConnection()));
        } catch (SQLException e) {
            throw new RuntimeException("❌ Error al conectar con la base de datos", e);
        }
    }

    @Override
    public void execute() {
        try {
            int roomId = inputReader.readInt("🔍 ID de la sala a actualizar: ");
            if (roomId <= 0) {
                System.out.println("❌ ID inválido. Debe ser un número entero positivo.");
                return;
            }

            Room existingRoom = roomService.findById(roomId);
            if (existingRoom == null) {
                System.out.println("❌ No se encontró ninguna sala con ese ID.");
                return;
            }

            ConsoleTablePrinter.printRoomTable(existingRoom);

            String name = inputReader.readLine("Nuevo nombre (deja en blanco para mantener): ");
            if (name != null && !name.trim().isEmpty()) {
                existingRoom.setName(name.trim());
            }

            String changeDifficulty = inputReader.readLine("¿Deseas cambiar la dificultad? (s/n): ");
            if (changeDifficulty.equalsIgnoreCase("s")) {
                DifficultyLevel difficulty = InputValidation.validateEnumInput("🎮 Nueva dificultad:", DifficultyLevel.class);
                existingRoom.setDifficultyLevel(difficulty);
            }

            String priceStr = inputReader.readLine("Nuevo precio (€) (deja en blanco para mantener): ");
            if (priceStr != null && !priceStr.trim().isEmpty()) {
                try {
                    BigDecimal price = new BigDecimal(priceStr.trim());
                    if (price.compareTo(BigDecimal.ZERO) >= 0) {
                        existingRoom.setPrice(price);
                    } else {
                        System.out.println("❌ El precio no puede ser negativo. Se mantiene el actual.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Precio inválido. Se mantiene el actual.");
                }
            }

            String quantityStr = inputReader.readLine("Nueva cantidad disponible (deja en blanco para mantener): ");
            if (quantityStr != null && !quantityStr.trim().isEmpty()) {
                try {
                    int quantity = Integer.parseInt(quantityStr.trim());
                    if (quantity >= 0) {
                        existingRoom.setQuantityAvailable(quantity);
                    } else {
                        System.out.println("❌ La cantidad no puede ser negativa. Se mantiene la actual.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Cantidad inválida. Se mantiene la actual.");
                }
            }

            roomService.updateRoom(existingRoom);
            System.out.println("✅ Sala actualizada con éxito.");

        } catch (RoomUpdateException e) {
            System.out.println("❌ Error al actualizar la sala: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Error al consultar la sala: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
