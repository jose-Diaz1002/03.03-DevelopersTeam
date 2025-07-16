package org.escaperoom.controller.command.subscription;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mongo.MongoSubscriptionDAO;
import org.escaperoom.util.InputReader;

public class UnsubscribeCommand implements Command {

    private final InputReader inputReader;
    private final MongoSubscriptionDAO subscriptionDAO;

    public UnsubscribeCommand(InputReader inputReader, MongoSubscriptionDAO subscriptionDAO) {
        this.inputReader = inputReader;
        this.subscriptionDAO = subscriptionDAO;
    }

    @Override
    public void execute() {
        System.out.println("\n--- Unsubscribe ---");
        String email = inputReader.readLine("Client Email to unsubscribe: ");

        subscriptionDAO.delete(email);
        System.out.println("Subscription removed successfully (if it existed).");
    }
}
