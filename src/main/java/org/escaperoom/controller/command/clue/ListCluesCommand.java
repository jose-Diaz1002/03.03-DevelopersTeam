package org.escaperoom.controller.command.clue;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.exception.ClueCreationException;
import org.escaperoom.factory.ClueServiceFactory;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.service.ClueService;

import java.util.List;

public class ListCluesCommand implements Command {

    private final ClueService clueService;

    public ListCluesCommand() {
        this.clueService = ClueServiceFactory.create();
    }

    @Override
    public void execute() {
        try {

            List<Clue> pistas = clueService.getAllClues();

            if (pistas == null || pistas.isEmpty()) {
                System.out.println("🔍 No se encontraron pistas.");
            } else {
                System.out.println("📜 Listado de pistas disponibles:");
                for (Clue pista : pistas) {
                    System.out.println(" - " + pista);
                }
            }
        } catch (ClueCreationException e) {
            System.out.println("❌ Error al obtener las pistas: " + e.getMessage());

        }
    }

}
