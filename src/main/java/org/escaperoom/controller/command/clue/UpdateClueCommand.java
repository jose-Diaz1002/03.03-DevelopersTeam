package org.escaperoom.controller.command.clue;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.exception.ClueCreationException;
import org.escaperoom.factory.ClueServiceFactory;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.enums.ClueTheme;
import org.escaperoom.service.ClueService;
import org.escaperoom.util.InputReader;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;

public class UpdateClueCommand implements Command {

    private final ClueService clueService;
    private final InputReader inputReader;

    public UpdateClueCommand(InputReader inputReader) {
        this.clueService = ClueServiceFactory.create();
        this.inputReader = inputReader;
    }

    @Override
    public void execute() {
        try {
            int clueId = inputReader.readInt("🔧 Ingrese el ID de la pista a actualizar: ");

            Clue clue = clueService.findClueById(clueId);
            if (clue == null) {
                System.out.println("❌ No se encontró ninguna pista con ese ID.");
                return;
            }

            System.out.println("📝 Datos actuales: " + clue);

            // Mostrar opciones
            System.out.println("Temas disponibles: " + Arrays.toString(ClueTheme.values()));

            String nuevoTema = inputReader.readLine("Nuevo tema (" + clue.getTheme() + ") [ENTER para no cambiar]: ");
            if (!nuevoTema.trim().isEmpty()) {
                clue.setTheme(ClueTheme.fromString(nuevoTema));
            }

            // Leer precio
            String priceStr = inputReader.readLine("Nuevo precio (" + clue.getPrice() + "€) [ENTER para no cambiar]: ");
            if (priceStr != null && !priceStr.trim().isEmpty()) {
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


            // Leer cantidad disponible
            String nuevaCantidad = inputReader.readLine("Nueva cantidad disponible (" + clue.getQuantityAvailable() + ") [ENTER para no cambiar]: ");
            if (!nuevaCantidad.trim().isEmpty()) {
                clue.setQuantityAvailable(Integer.parseInt(nuevaCantidad));
            }

            // Actualizar pista
            clueService.updateClue(clue);
            System.out.println("✅ Pista actualizada correctamente.");

        } catch (ClueCreationException e) {
            System.out.println("⚠️ Tema inválido. Debe ser uno de: " + Arrays.toString(ClueTheme.values()));
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Formato numérico inválido.");
        } catch (SQLException e) {
            System.out.println("❌ Error de base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error al actualizar la pista: " + e.getMessage());
        }
    }
}
