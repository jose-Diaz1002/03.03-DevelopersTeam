package org.escaperoom.controller.menu;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.controller.command.room.*;
import org.escaperoom.input.InputReader;
import org.escaperoom.view.ConsoleView;

import java.util.LinkedHashMap;
import java.util.Map;

public class RoomMenuController implements Command {

    private final Map<String, Command> commands = new LinkedHashMap<>();
    private final ConsoleView view;
    private final InputReader inputReader;

    public RoomMenuController(InputReader inputReader) {
        this.inputReader = inputReader;
        this.view = new ConsoleView(inputReader);
        initCommands();
    }

    private void initCommands() {
        commands.put("1", new CreateRoomInteractiveCommand(inputReader));
        commands.put("2", new ListRoomsCommand(inputReader));
        commands.put("3", new UpdateRoomCommand(inputReader));
        commands.put("4", new DeleteRoomCommand(inputReader));
    }

    public void start() {
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

    @Override
    public void execute() {
        start();
    }
}
