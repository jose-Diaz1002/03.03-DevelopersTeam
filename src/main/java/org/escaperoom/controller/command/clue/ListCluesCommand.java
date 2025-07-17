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
            List<Clue> pistas = clueService.getAllClues();

            if (pistas.isEmpty()) {
                System.out.println("🔍 No se encontraron pistas.");
                return;
            }

            System.out.println("📜 Listado de pistas disponibles:");
            ConsoleTablePrinter.printCluesTable(pistas);

        } catch (Exception e) {
            System.out.println("❌ Error al listar pistas: " + e.getMessage());
        }
    }
}
