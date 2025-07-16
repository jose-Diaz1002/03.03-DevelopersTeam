package org.escaperoom.controller.menu;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.controller.command.decoration.CreateDecorationCommand;
import org.escaperoom.controller.command.decoration.DeleteDecorationCommand;
import org.escaperoom.controller.command.decoration.ListDecorationsCommand;
import org.escaperoom.controller.command.decoration.UpdateDecorationCommand;
import org.escaperoom.util.InputReader;
import org.escaperoom.view.ConsoleView;

import java.util.LinkedHashMap;
import java.util.Map;

public class DecorationMenuController implements Command {

    private final Map<String, Command> commands = new LinkedHashMap<>();
    private final ConsoleView view;
    private final InputReader inputReader;

    public DecorationMenuController(InputReader inputReader) {
        this.inputReader = inputReader;
        this.view = new ConsoleView(inputReader);
        initCommands();
    }

    private void initCommands() {
        commands.put("1", new CreateDecorationCommand(inputReader));
        commands.put("2", new ListDecorationsCommand(inputReader));
        commands.put("3", new UpdateDecorationCommand(inputReader));
        commands.put("4", new DeleteDecorationCommand(inputReader));
    }

    @Override
    public void execute() {
        start();
    }

    public void start() {

        String input;
        do {
            view.printDecorationMenu();  // Aquí asegúrate que ConsoleView lo tenga implementado correctamente
            input = view.readInput("Selecciona una opción (0 para volver): ");
            Command command = commands.get(input);
            if (command != null) {
                command.execute();
            } else if (!"0".equals(input)) {
                view.printError("❌ Opción no reconocida.");
            }
        } while (!"0".equals(input));
        System.out.println("🔙 Volviendo al menú principal...");
    }

}
