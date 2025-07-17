package org.escaperoom.controller.command.clue;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.exception.ClueCreationException;
import org.escaperoom.factory.ClueServiceFactory;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.enums.ClueTheme;
import org.escaperoom.service.ClueService;
import org.escaperoom.util.InputValidation;

import java.math.BigDecimal;

public class UpdateClueCommand implements Command {

    private final ClueService clueService;

    public UpdateClueCommand() {
        this.clueService = ClueServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            int clueId = InputValidation.validateIdInput("🔧 Ingrese el ID de la pista a actualizar: ");

            Clue clue = clueService.findClueById(clueId);
            if (clue == null) {
                System.out.println("❌ No se encontró ninguna pista con ese ID.");
                return;
            }

            System.out.println("📝 Datos actuales: " + clue);

            ClueTheme[] themes = ClueTheme.values();
            System.out.println("Temas disponibles:");
            for (int i = 0; i < themes.length; i++) {
                System.out.printf("%d. %s%n", i + 1, themes[i]);
            }

            String inputTema = InputValidation.validateStringInput("Nuevo tema (" + clue.getTheme() + "): ");

            if (!inputTema.trim().isEmpty()) {
                try {
                    int opcionTema = Integer.parseInt(inputTema.trim());
                    if (opcionTema >= 1 && opcionTema <= themes.length) {
                        clue.setTheme(themes[opcionTema - 1]);
                    } else {
                        System.out.println("❌ Opción fuera de rango. Se mantiene el tema actual.");
                    }
                } catch (NumberFormatException e) {
                    ClueTheme nuevoTema = ClueTheme.fromString(inputTema.trim());
                    if (nuevoTema != null) {
                        clue.setTheme(nuevoTema);
                    } else {
                        System.out.println("❌ Tema inválido. Se mantiene el tema actual.");
                    }
                }
            }

            String priceStr = InputValidation.validateStringInput("Nuevo precio (" + clue.getPrice() + "): ");
            if (!priceStr.trim().isEmpty()) {
                try {
                    BigDecimal price = new BigDecimal(priceStr.trim());
                    if (price.compareTo(BigDecimal.ZERO) >= 0) {
                        clue.setPrice(price);
                    } else {
                        System.out.println("❌ El precio no puede ser negativo. Se mantiene el actual.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Precio inválido. Se mantiene el actual.");
                }
            }

            String cantidadStr = InputValidation.validateStringInput("Nueva cantidad disponible (" + clue.getQuantityAvailable() + "): ");
            if (!cantidadStr.trim().isEmpty()) {
                try {
                    int cantidad = Integer.parseInt(cantidadStr.trim());
                    if (cantidad >= 0) {
                        clue.setQuantityAvailable(cantidad);
                    } else {
                        System.out.println("❌ La cantidad no puede ser negativa. Se mantiene la actual.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Cantidad inválida. Se mantiene la actual.");
                }
            }

            clueService.updateClue(clue);
            System.out.println("✅ Pista actualizada correctamente.");

        } catch (ClueCreationException e) {
            System.out.println("❌ Error en la actualización de la pista: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
