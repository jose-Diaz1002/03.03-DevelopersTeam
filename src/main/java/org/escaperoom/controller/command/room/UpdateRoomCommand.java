package org.escaperoom.controller.command.room;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLRoomDAO;
import org.escaperoom.database.ConnectionFactory;
import org.escaperoom.exception.RoomUpdateException;
import org.escaperoom.input.InputReader;
import org.escaperoom.model.entity.Room;
import org.escaperoom.model.enums.DifficultyLevel;
import org.escaperoom.model.service.RoomService;

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
            int roomId = Integer.parseInt(inputReader.readLine("Introduce el ID de la sala a actualizar: "));

            Room existingRoom = roomService.findById(roomId);
            if (existingRoom == null) {
                System.out.println("❌ No se encontró ninguna sala con ese ID.");
                return;
            }

            System.out.println("➡ Sala actual: " + existingRoom);

            String name = inputReader.readLine("Nuevo nombre (deja en blanco para mantener): ");
            if (!name.trim().isEmpty()) {
                existingRoom.setName(name.trim());
            }

            String difficultyStr = inputReader.readLine("Nueva dificultad (Easy, Medium, Hard, Expert): ");
            if (!difficultyStr.trim().isEmpty()) {
                try {
                    existingRoom.setDifficultyLevel(DifficultyLevel.fromString(difficultyStr));
                } catch (IllegalArgumentException e) {
                    System.out.println("❌ Dificultad inválida. Se mantiene la actual.");
                }
            }

            String priceStr = inputReader.readLine("Nuevo precio (€): ");
            if (!priceStr.trim().isEmpty()) {
                try {
                    BigDecimal price = new BigDecimal(priceStr.trim());
                    existingRoom.setPrice(price);
                } catch (NumberFormatException e) {
                    System.out.println("❌ Precio inválido. Se mantiene el actual.");
                }
            }

            String quantityStr = inputReader.readLine("Nueva cantidad disponible: ");
            if (!quantityStr.trim().isEmpty()) {
                try {
                    int quantity = Integer.parseInt(quantityStr.trim());
                    existingRoom.setQuantityAvailable(quantity);
                } catch (NumberFormatException e) {
                    System.out.println("❌ Cantidad inválida. Se mantiene la actual.");
                }
            }

            roomService.updateRoom(existingRoom);
            System.out.println("✅ Sala actualizada con éxito.");

        } catch (RoomUpdateException e) {
            System.out.println("❌ Error al actualizar la sala: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
