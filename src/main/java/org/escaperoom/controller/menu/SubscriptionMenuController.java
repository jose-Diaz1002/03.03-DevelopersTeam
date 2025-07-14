package org.escaperoom.controller.menu;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.input.InputReader;

public class SubscriptionMenuController implements Command {

    private final InputReader inputReader;
    public SubscriptionMenuController(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    @Override
    public void execute() {
        String input;
        do {
            System.out.println("Subscription Menu:");
            System.out.println("1. Subscribe to a plan");
            System.out.println("2. Unsubscribe from a plan");
            System.out.println("3. View subscription details");
            System.out.println("0. Exit");

            input = inputReader.readLine("Select an option: ");
            switch (input) {
                case "1":
                    // Call method to subscribe to a plan
                    break;
                case "2":
                    // Call method to unsubscribe from a plan
                    break;
                case "3":
                    // Call method to view subscription details
                    break;
                case "0":
                    System.out.println("Exiting Subscription Menu.");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (!"0".equals(input));
    }
}
