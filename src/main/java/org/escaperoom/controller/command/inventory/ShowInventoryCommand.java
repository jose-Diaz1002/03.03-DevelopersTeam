package org.escaperoom.controller.command.inventory;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.input.InputReader;

public class ShowInventoryCommand implements Command {

    private final InputReader inputReader;

    public ShowInventoryCommand(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    @Override
    public void execute() {
        // Logic to show the inventory goes here
        // For example, you might retrieve the inventory from a service and print it to the console
        System.out.println("Showing inventory...");
        // This is a placeholder; actual implementation will depend on your application's structure
    }
}
