package org.escaperoom.controller.menu;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.controller.command.ticket.CreateSaleCommand;
import org.escaperoom.controller.command.ticket.DeleteSaleCommand;
import org.escaperoom.controller.command.ticket.ListSalesCommand;
import org.escaperoom.controller.command.ticket.UpdateSaleCommand;
import org.escaperoom.util.InputReader;
import org.escaperoom.util.InputValidator;
import org.escaperoom.view.ConsoleView;

import java.util.LinkedHashMap;
import java.util.Map;

public class SalesMenuController implements Command {

    private final Map<String, Command> commands = new LinkedHashMap<>();
    private final ConsoleView view;
    private final InputReader inputReader;

    public SalesMenuController(InputReader inputReader) {
        this.inputReader = inputReader;
        this.view = new ConsoleView(inputReader);
        initCommands();
    }

    private void initCommands() {
          commands.put("1", new CreateSaleCommand(inputReader));
         commands.put("2", new ListSalesCommand(inputReader));
        commands.put("3", new UpdateSaleCommand(inputReader));
         commands.put("4", new DeleteSaleCommand(inputReader));
    }



    @Override
    public void execute() {
        boolean exit = false;
        while (!exit) {
            view.printTicketsMenu();
            String choice = inputReader.readLine("Selecciona una opción: ").trim();
            Command command = commands.get(choice);
            if (command != null) {
                command.execute();
            } else if ("0".equals(choice)) {
                exit = true; // Exit the menu
            } else {
                view.printError("❌ Comando no reconocido. Por favor, intenta de nuevo.");
            }
        }
    }
}
