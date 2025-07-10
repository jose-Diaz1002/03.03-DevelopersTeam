package org.escaperoom.controller.command.room;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLDecorationObjectDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.DecorationObject;
import org.escaperoom.model.service.DecorationObjectService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

public class AddDecorationObjectCommand implements Command {

    private final DecorationObjectService decorationService;
    private final Scanner scanner;
    private final int roomId;

    public AddDecorationObjectCommand(Scanner scanner, int roomId) {
        this.scanner = scanner;
        this.roomId = roomId;
        try {
            this.decorationService = new DecorationObjectService(
                    new MySQLDecorationObjectDAO(MySQLConnection.getInstance().getConnection())
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }

    @Override
    public void execute() {
        try {
            System.out.println("Creando objeto decorativo para Room ID: " + roomId);

            System.out.print("Nombre del objeto decorativo: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
                return;
            }

            System.out.print("Tipo de decoración: ");
            String decorationType = scanner.nextLine().trim();
            if (decorationType.isEmpty()) {
                System.out.println("El tipo de decoración no puede estar vacío.");
                return;
            }

            System.out.print("Precio del objeto: ");
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

            DecorationObject decoration = new DecorationObject(roomId, name, decorationType, price, quantity);
            decorationService.createDecorationObject(decoration);

            System.out.println("Objeto decorativo añadido con éxito.");

        } catch (Exception e) {
            System.out.println("Error inesperado al añadir el objeto decorativo: " + e.getMessage());
        }
    }
}
