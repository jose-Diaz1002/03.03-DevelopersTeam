package org.escaperoom.controller.command.room;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLRoomDAO;
import org.escaperoom.database.ConnectionFactory;
import org.escaperoom.exception.RoomCreationException;
import org.escaperoom.model.entity.Room;
import org.escaperoom.model.enums.DifficultyLevel;
import org.escaperoom.model.service.RoomService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateRoomCommand implements Command {

    private final RoomService roomService;
    private final Scanner scanner;
    private final int escapeRoomId;

    public CreateRoomCommand(Scanner scanner, int escapeRoomId) {
        this.scanner = scanner;
        this.escapeRoomId = escapeRoomId;
        try {
            // Usamos ConnectionFactory en lugar de MySQLConnection directamente
            this.roomService = new RoomService(new MySQLRoomDAO(ConnectionFactory.getMySQLConnection()));
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a BD", e);
        }
    }

    @Override
    public void execute() {
        try {
            System.out.println("Creando sala para EscapeRoom ID: " + escapeRoomId);

            System.out.print("Nombre de la sala: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("El nombre de la sala no puede estar vacío.");
                return;
            }

            System.out.print("Dificultad (Easy, Medium, Hard, Expert): ");
            String diffInput = scanner.nextLine().trim();
            DifficultyLevel difficulty;
            try {
                difficulty = DifficultyLevel.fromString(diffInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Dificultad inválida. Debe ser: Easy, Medium, Hard o Expert.");
                return;
            }

            System.out.print("Precio: ");
            BigDecimal price;
            try {
                price = new BigDecimal(scanner.nextLine().trim());
                if (price.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("El precio no puede ser negativo.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Precio inválido. Debe ser un número decimal válido.");
                return;
            }

            System.out.print("Cantidad disponible: ");
            int quantity;
            try {
                quantity = Integer.parseInt(scanner.nextLine().trim());
                if (quantity < 0) {
                    System.out.println("La cantidad no puede ser negativa.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Cantidad inválida. Debe ser un número entero válido.");
                return;
            }

            // Creamos la sala
            Room room = new Room(escapeRoomId, name, difficulty, price, quantity);
            roomService.createRoom(room);
            System.out.println("Sala creada con éxito.");

        } catch (RoomCreationException e) {
            System.out.println("Error al crear sala: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
