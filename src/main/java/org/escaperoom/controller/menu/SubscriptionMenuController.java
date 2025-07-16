package org.escaperoom.controller.menu;

import org.escaperoom.controller.command.Subscription.SubscribeCommand;
import org.escaperoom.controller.command.Subscription.UnsubscribeCommand;
import org.escaperoom.controller.command.Subscription.ViewSubscriptionsCommand;
import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mongo.MongoSubscriptionDAO;
import org.escaperoom.input.InputReader;
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
        commands.put("1", new SubscribeCommand(inputReader, subscriptionDAO));
        commands.put("2", new UnsubscribeCommand(inputReader, subscriptionDAO));
        commands.put("3", new ViewSubscriptionsCommand(subscriptionDAO));
    }

    public void start() {
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

    @Override
    public void execute() {
        start();
    }
}
