package org.escaperoom.controller.menu;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.controller.command.room.*;
import org.escaperoom.util.InputReader;
import org.escaperoom.view.ConsoleView;

import java.util.LinkedHashMap;
import java.util.Map;

public class RoomMenuController implements Command {

    private final Map<String, Command> commands = new LinkedHashMap<>();
    private final ConsoleView view;
    private final InputReader inputReader;

    public RoomMenuController(InputReader inputReader, ConsoleView view) {
        this.inputReader = inputReader;
        this.view = view;
        initCommands();
    }

    private void initCommands() {
        commands.put("1", new CreateRoomInteractiveCommand(inputReader));
       commands.put("2", new ListRoomsCommand());
         commands.put("3", new UpdateRoomCommand(inputReader));
         commands.put("4", new DeleteRoomCommand(inputReader));
    }

    /**
     * Starts the Room menu loop, allowing the user to select options until they choose to exit.
     */

    @Override
    public void execute() {

        String input;
        do {
            view.printRoomMenu();
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
