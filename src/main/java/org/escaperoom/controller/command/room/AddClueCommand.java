package org.escaperoom.controller.command.room;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLClueDAO;
import org.escaperoom.database.ConnectionFactory;
import org.escaperoom.input.InputReader;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.enums.ClueTheme;
import org.escaperoom.model.service.ClueService;

import java.math.BigDecimal;
import java.sql.SQLException;

public class AddClueCommand implements Command {
    private final InputReader inputReader;
    private final ClueService clueService;

    public AddClueCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        try {
            this.clueService = new ClueService(new MySQLClueDAO(ConnectionFactory.getMySQLConnection()));
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }
    @Override
    public void execute() {
        try {
            int roomId = Integer.parseInt(inputReader.readLine("ID de la sala a la que quieres añadir la pista: ").trim());

            String themeStr = inputReader.readLine("Tema de la pista (Mystery, Horror, Fantasy, Sci-Fi, Historical, Adventure): ").trim();
            ClueTheme theme;
            try {
                theme = ClueTheme.valueOf(themeStr);
            } catch (IllegalArgumentException e) {
                System.out.println("Tema inválido. Debe ser uno de los indicados.");
                return;
            }

            BigDecimal price;
            try {
                price = new BigDecimal(inputReader.readLine("Precio de la pista: ").trim());
                if (price.compareTo(BigDecimal.ZERO) < 0) {
                    System.out.println("El precio no puede ser negativo.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Precio inválido.");
                return;
            }

            int quantity;
            try {
                quantity = Integer.parseInt(inputReader.readLine("Cantidad disponible: ").trim());
                if (quantity < 0) {
                    System.out.println("Cantidad no puede ser negativa.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Cantidad inválida.");
                return;
            }

            Clue clue = new Clue(roomId, theme, price, quantity);
            clueService.addClue(clue);


            System.out.println("Pista añadida correctamente.");

        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }


    // Additional methods for testing or other functionalities can be added here

}