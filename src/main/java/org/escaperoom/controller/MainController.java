package org.escaperoom.controller;

import org.escaperoom.controller.command.ExitCommand;
import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.controller.command.inventory.InventoryValueCommand;
import org.escaperoom.controller.command.inventory.ShowInventoryCommand;
import org.escaperoom.controller.menu.*;
import org.escaperoom.input.InputReader;
import org.escaperoom.input.ScannerInputReader;
import org.escaperoom.view.ConsoleView;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainController {

    private final Map<String, Command> commands = new LinkedHashMap<>();
    private final ConsoleView view;
    private final InputReader inputReader;

    public MainController() {
        this.inputReader = new ScannerInputReader();
        this.view = new ConsoleView(inputReader);
        initCommands();
    }

    private void initCommands() {
        commands.put("1", () -> new EscapeRoomMenuController(inputReader, view).start());
        commands.put("2", () -> new RoomMenuController(inputReader).start());

        commands.put("3", () -> new ClueMenuController(inputReader).start());
        commands.put("4", () -> new DecorationMenuController(inputReader).start());
        commands.put("5", new ShowInventoryCommand(inputReader));
        commands.put("6", new InventoryValueCommand(inputReader));
        // commands.put("7", () -> new SalesMenuController(inputReader).start());
        // commands.put("8", () -> new SubscriptionMenuController(inputReader).start());
        commands.put("0", new ExitCommand());
    }

    public void start() {
        String input;
        do {
            view.printWelcomeMessage();
            view.printMainMenu();
            input = view.readInput("Selecciona una opción: ");
            Command command = commands.get(input);
            if (command != null) {
                command.execute();
            } else {
                view.printError("❌ Comando no reconocido. Por favor, intenta de nuevo.");
            }
        } while (!"0".equals(input));
    }


}
