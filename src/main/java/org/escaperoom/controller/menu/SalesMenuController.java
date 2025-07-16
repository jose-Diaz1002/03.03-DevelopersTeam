package org.escaperoom.controller.menu;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.input.InputReader;
import org.escaperoom.view.ConsoleView;

import java.util.LinkedHashMap;
import java.util.Map;

public class SalesMenuController {

    private final Map<String, Command> commands = new LinkedHashMap<>();
    private final ConsoleView view;
    private final InputReader inputReader;

    public SalesMenuController(InputReader inputReader) {
        this.inputReader = inputReader;
        this.view = new ConsoleView(inputReader);
        initCommands();
    }

    private void initCommands() {
      /*  commands.put("1", new CreateSaleCommand(inputReader));
        commands.put("2", new ListSalesCommand(inputReader));
        commands.put("3", new UpdateSaleCommand(inputReader));
        commands.put("4", new DeleteSaleCommand(inputReader));*/
    }

    public void start() {
        String input;
        do {
            view.printSalesMenu();
            input = view.readInput("Selecciona una opción: ");
            Command command = commands.get(input);
            if (command != null) {
                command.execute();
            } else if (!"0".equals(input)) {
                view.printError("❌ Opción no reconocida.");
            }
        } while (!"0".equals(input));
    }
}
