package org.escaperoom.controller.command.subscription;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mongo.MongoSubscriptionDAO;
import org.escaperoom.model.entity.Subscription;

import java.util.List;

public class ViewSubscriptionsCommand implements Command {

    private final MongoSubscriptionDAO subscriptionDAO;

    public ViewSubscriptionsCommand(MongoSubscriptionDAO subscriptionDAO) {
        this.subscriptionDAO = subscriptionDAO;
    }

    @Override
    public void execute() {
        System.out.println("\n--- All Subscriptions ---");
        List<Subscription> subscriptions = subscriptionDAO.readAll();
        if (subscriptions.isEmpty()) {
            System.out.println("No subscriptions found.");
        } else {
            for (Subscription sub : subscriptions) {
                System.out.printf("Email: %s, Name: %s, Surnames: %s%n",
                        sub.getClientEmail(),
                        sub.getName(),
                        sub.getSurnames());
            }
        }
    }
}
