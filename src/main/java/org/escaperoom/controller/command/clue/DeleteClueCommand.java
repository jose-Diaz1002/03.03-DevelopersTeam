package org.escaperoom.controller.command.clue;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.util.InputReader;
import org.escaperoom.service.ClueService;

public class DeleteClueCommand implements Command {

    private final InputReader inputReader;
// Assuming you might want to use a service for clue operations, similar to CreateClueCommand
     private final ClueService clueService;
    public DeleteClueCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        this.clueService = null; // ClueServiceFactory.createClueService(); // Uncomment if you have a service to use
    }

    @Override
    public void execute() {
        // Aquí iría la lógica para eliminar una pista
        // Por ejemplo, podrías pedir al usuario el ID de la pista a eliminar
      //  String clueId = inputReader.readInput("Introduce el ID de la pista a eliminar: ");

        // Aquí llamarías al método del servicio para eliminar la pista
        // clueService.deleteClue(clueId); // Descomentar si tienes un servicio implementado

      //  System.out.println("Pista con ID " + clueId + " eliminada correctamente."); // Mensaje de confirmación

    }
}
