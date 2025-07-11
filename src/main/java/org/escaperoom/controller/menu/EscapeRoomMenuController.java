package org.escaperoom.controller.menu;

import org.escaperoom.controller.command.escapeRoom.CreateEscapeRoomCommand;
import org.escaperoom.controller.command.escapeRoom.DeleteEscapeRoomCommand;
import org.escaperoom.controller.command.escapeRoom.ListEscapeRoomsCommand;
import org.escaperoom.controller.command.escapeRoom.UpdateEscapeRoomCommand;
import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.input.InputReader;
import org.escaperoom.view.ConsoleView;

import java.util.LinkedHashMap;
import java.util.Map;

public class EscapeRoomMenuController {

    private final Map<String, Command> commands = new LinkedHashMap<>();
    private final ConsoleView view;
    private final InputReader inputReader;

    public EscapeRoomMenuController(InputReader inputReader, ConsoleView view) {
        this.inputReader = inputReader;
        this.view = view;
        initCommands();
    }

    private void initCommands() {
        commands.put("1", new CreateEscapeRoomCommand(inputReader));
        commands.put("2", new ListEscapeRoomsCommand());
        commands.put("3",new UpdateEscapeRoomCommand(inputReader));
        commands.put("4", new DeleteEscapeRoomCommand(inputReader));
        commands.put("0", () -> System.out.println("Volviendo al menú principal..."));
    }

    public void start() {
        String input;
        do {
            view.printEscapeRoomMenu();
            input = inputReader.readLine("Selecciona una opción: ");
            Command command = commands.get(input);
            if (command != null) {
                command.execute();

            } else {
                view.printError("❌ Opción inválida.");
            }
        } while (!"0".equals(input));
    }



}
