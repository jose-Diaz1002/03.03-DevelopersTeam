package org.escaperoom.controller.command.subscription;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mongo.MongoSubscriptionDAO;
import org.escaperoom.model.entity.Subscription;
import org.escaperoom.util.ConsoleTablePrinter;

import java.util.List;

public class ViewSubscriptionsCommand implements Command {

    private final MongoSubscriptionDAO subscriptionDAO;

    public ViewSubscriptionsCommand(MongoSubscriptionDAO subscriptionDAO) {
        this.subscriptionDAO = subscriptionDAO;
    }

    @Override
    public void execute() {
        List<Subscription> subscriptions = subscriptionDAO.readAll();

        if (subscriptions.isEmpty()) {
            System.out.println("No subscriptions found.");
        } else {
            System.out.println("\n--- All Subscriptions ---");
            ConsoleTablePrinter.printSubscriptionsTable(subscriptions); // corregido el nombre del método
        }
    }
}
