package org.escaperoom.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.controller.command.inventory.InventoryValueCommand;
import org.escaperoom.controller.command.inventory.ShowInventoryCommand;
import org.escaperoom.controller.command.system.ExitCommand;
import org.escaperoom.controller.menu.*;
import org.escaperoom.dao.mongo.MongoSubscriptionDAO;
import org.escaperoom.util.InputReader;
import org.escaperoom.util.ScannerInputReader;
import org.escaperoom.view.ConsoleView;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * MainController is the entry point for the Escape Room application.
 * It initializes the main menu and handles user input to navigate through different functionalities.
 */
public class MainController {

    private final Map<String, Command> commands = new LinkedHashMap<>();
    private final ConsoleView view;
    private final InputReader inputReader;

    private final MongoClient mongoClient;
    private final MongoSubscriptionDAO subscriptionDAO;

    public MainController() {
        this.inputReader = new ScannerInputReader();
        this.view = new ConsoleView(inputReader);
        this.mongoClient = MongoClients.create();
        this.subscriptionDAO = new MongoSubscriptionDAO(mongoClient);
        initCommands();
    }

    /**
     * Initializes the commands for the main menu.
     */
    private void initCommands() {
        commands.put("1", new EscapeRoomMenuController(inputReader, view));
        commands.put("2", new RoomMenuController(inputReader, view));
        commands.put("3", new ClueMenuController(inputReader));
        commands.put("4", new DecorationMenuController(inputReader));
        commands.put("5", new ShowInventoryCommand(inputReader));
        commands.put("6", new InventoryValueCommand(inputReader));
        commands.put("7", new SalesMenuController(inputReader));
        commands.put("8", () -> new SubscriptionMenuController(inputReader, subscriptionDAO).execute());
        commands.put("0", new ExitCommand());
    }

    /**
     * Starts the main menu loop, allowing the user to select options until they choose to exit.
     */
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
