package org.escaperoom.controller.menu;

import org.escaperoom.controller.command.clue.CreateClueCommand;
import org.escaperoom.controller.command.clue.DeleteClueCommand;
import org.escaperoom.controller.command.clue.ListCluesCommand;
import org.escaperoom.controller.command.clue.UpdateClueCommand;
import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.util.InputReader;
import org.escaperoom.view.ConsoleView;

import java.util.LinkedHashMap;
import java.util.Map;

public class ClueMenuController implements Command {

    private final Map<String, Command> commands = new LinkedHashMap<>();
    private final ConsoleView view;
    private final InputReader inputReader;

    public ClueMenuController(InputReader inputReader) {
        this.inputReader = inputReader;
        this.view = new ConsoleView(inputReader);
        initCommands();
    }

    private void initCommands() {
        commands.put("1", new CreateClueCommand());
        commands.put("2", new ListCluesCommand());
        commands.put("3", new UpdateClueCommand());
      //  commands.put("4", new DeleteClueCommand());
    }


    // Este es el método requerido por el patrón Command,
    // que simplemente delega al método start().
    @Override
    public void execute() {
        start();
    }

    // Aquí está el ciclo interactivo real del menú,
    // separado para que sea más claro y reusable.
    public void start() {
        String input;
        do {
            view.printClueMenu();  // Muestra las opciones
            input = view.readInput("Selecciona una opción: ");
            Command command = commands.get(input);
            if (command != null) {
                command.execute();
            } else if (!"0".equals(input)) {
                view.printError("❌ Comando no reconocido.");
            }
        } while (!"0".equals(input));
    }
}
