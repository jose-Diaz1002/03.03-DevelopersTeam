package org.escaperoom.controller.command.room;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLClueDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.enums.ClueTheme;
import org.escaperoom.model.service.ClueService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class AddClueCommand implements Command {

    private final ClueService clueService;
    private final Scanner scanner;
    private final int roomId;

    public AddClueCommand(Scanner scanner, int roomId) {

        this.scanner = scanner;
        this.roomId = roomId;
        try {
            this.clueService = new ClueService(new MySQLClueDAO(MySQLConnection.getInstance().getConnection()));
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }

    @Override
    public void execute() {
        try {
            System.out.println("Creando pista para Room ID: " + roomId);

            System.out.print("Tema de la pista (Mystery, Horror, Fantasy, Sci-Fi, Historical, Adventure): ");

            String themeInput = scanner.nextLine().trim();
            ClueTheme theme;
            try {
                theme = ClueTheme.fromString(themeInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Tema inválido. Debe ser: Mystery, Horror, Fantasy, Sci-Fi, Historical, Adventure).");
                return;
            }

            System.out.print("Precio de la pista: ");
            String priceInput = scanner.nextLine().trim();
            BigDecimal price;
            try {
                price = new BigDecimal(priceInput);
                if (price.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("El precio no puede ser negativo.");
                    return;
                }
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("Precio inválido. Debe ser un número decimal.");
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
                System.out.println("Cantidad inválida. Debe ser un número entero.");
                return;
            }

            Clue clue = new Clue(roomId, theme, price, quantity);
            clueService.createClue(clue);

            System.out.println("Pista añadida con éxito.");
            System.out.println(clue.toString());

        } catch (Exception e) {
            System.out.println("Error inesperado al añadir la pista: " + e.getMessage());
        }
    }
}

