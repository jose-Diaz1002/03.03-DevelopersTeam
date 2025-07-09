package org.escaperoom.controller.command;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLRoomDAO;
import org.escaperoom.database.MySQLConnection;
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
            this.roomService = new RoomService(new MySQLRoomDAO(MySQLConnection.getInstance().getConnection()));
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar a BD", e);
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
                if (difficulty == null) {
                    throw new IllegalArgumentException("Dificultad inválida");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Dificultad inválida. Debe ser: Easy, Medium, Hard o Expert.");
                return;
            }

            System.out.print("Precio: ");
            String priceInput = scanner.nextLine().trim();
            BigDecimal price;
            try {
                price = new BigDecimal(priceInput);
                if (price.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("El precio no puede ser negativo.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Precio inválido. Debe ser un número decimal válido.");
                return;
            }

            System.out.print("Cantidad disponible: ");
            String quantityInput = scanner.nextLine().trim();
            int quantity;
            try {
                quantity = Integer.parseInt(quantityInput);
                if (quantity < 0) {
                    System.out.println("La cantidad no puede ser negativa.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Cantidad inválida. Debe ser un número entero válido.");
                return;
            }

            // Ahora sí creamos el objeto y persistimos sólo si todas las validaciones pasaron
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
