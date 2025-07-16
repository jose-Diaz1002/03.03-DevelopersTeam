package org.escaperoom.controller.menu;

import org.escaperoom.controller.command.subscription.SubscribeCommand;
import org.escaperoom.controller.command.subscription.UnsubscribeCommand;
import org.escaperoom.controller.command.subscription.ViewSubscriptionsCommand;
import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mongo.MongoSubscriptionDAO;
import org.escaperoom.util.InputReader;
import org.escaperoom.view.ConsoleView;

import java.util.LinkedHashMap;
import java.util.Map;

public class SubscriptionMenuController implements Command {
    private final Map<String, Command> commands = new LinkedHashMap<>();
    private final ConsoleView view;
    private final InputReader inputReader;

    public SubscriptionMenuController(InputReader inputReader, MongoSubscriptionDAO subscriptionDAO) {
        this.inputReader = inputReader;
        this.view = new ConsoleView(inputReader);
        initCommands(subscriptionDAO);
    }

    private void initCommands(MongoSubscriptionDAO subscriptionDAO) {
        commands.put("1", new SubscribeCommand( subscriptionDAO));
        commands.put("2", new UnsubscribeCommand(inputReader, subscriptionDAO));
        commands.put("3", new ViewSubscriptionsCommand(subscriptionDAO));
    }

    @Override
    public void execute() {

        String input;
        do {
            view.printSubscriptionMenu();
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
