package org.escaperoom.controller.command.clue;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.ClueServiceFactory;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.service.ClueService;
import org.escaperoom.util.ConsoleTablePrinter;

import java.util.List;

public class ListCluesCommand implements Command {

    private final ClueService clueService;

    public ListCluesCommand() {
        this.clueService = ClueServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            List<Clue> clues = clueService.getAllClues();

            if (clues == null || clues.isEmpty()) {
                System.out.println("ℹ️ No hay pistas registradas.");
                return;
            }

            System.out.println("\n🔎 Lista de pistas:");
            ConsoleTablePrinter.printCluesTable(clues);

        } catch (Exception e) {
            System.out.println("❌ Error al obtener la lista de pistas: " + e.getMessage());
        }
    }
}
