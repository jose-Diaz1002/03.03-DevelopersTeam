package org.escaperoom.controller.command.Subscription;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mongo.MongoSubscriptionDAO;
import org.escaperoom.input.InputReader;
import org.escaperoom.model.entity.Subscription;

public class SubscribeCommand implements Command {

    private final InputReader inputReader;
    private final MongoSubscriptionDAO subscriptionDAO;

    public SubscribeCommand(InputReader inputReader, MongoSubscriptionDAO subscriptionDAO) {
        this.inputReader = inputReader;
        this.subscriptionDAO = subscriptionDAO;
    }

    @Override
    public void execute() {
        System.out.println("\n--- New Subscription ---");
        String email = inputReader.readLine("Client Email: ");
        String name = inputReader.readLine("Name: ");
        String surnames = inputReader.readLine("Surnames: ");
        //int playerId = inputReader.readInt("Player ID: ");
       // String eventTypeSubscribed = inputReader.readLine("Event Type Subscribed: ");

        Subscription subscription = new Subscription();
        subscription.setClientEmail(email);
        subscription.setName(name);
        subscription.setSurnames(surnames);
        //subscription.setPlayerId(playerId);
        //subscription.setEventTypeSubscribed(eventTypeSubscribed);

        subscriptionDAO.create(subscription);
        System.out.println("Subscription created successfully.");
    }
}
