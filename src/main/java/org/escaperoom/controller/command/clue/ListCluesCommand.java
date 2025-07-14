package org.escaperoom.controller.command.clue;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.ClueServiceFactory;
import org.escaperoom.input.InputReader;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.service.ClueService;

import java.util.List;

public class ListCluesCommand implements Command {

    private final InputReader inputReader;
    private final ClueService clueService;
    public ListCluesCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        this.clueService = ClueServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            System.out.println("Listando todas las pistas...");
            int roomId = inputReader.readInt("Introduce el ID de la sala para listar las pistas: ");

            List<Clue> clues = clueService.getCluesByRoomId(roomId);
            System.out.println("Se encontraron " + clues.size() + " pistas para la sala con ID " + roomId);

            if (clues.isEmpty()) {
                System.out.println("No se encontraron pistas para la sala con ID " + roomId);
            } else {
                System.out.println("Pistas encontradas:");
                for (Clue clue : clues) {
                    System.out.println("ID: " + clue.getId() + ", Tema: " + clue.getTheme() +
                            ", Precio: " + clue.getPrice() + ", Cantidad disponible: " + clue.getQuantityAvailable());
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }


}
