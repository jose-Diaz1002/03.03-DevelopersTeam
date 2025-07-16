package org.escaperoom.controller.command.subscription;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mongo.MongoSubscriptionDAO;
import org.escaperoom.model.entity.Subscription;
import org.escaperoom.util.InputValidation;

public class SubscribeCommand implements Command {

    private final MongoSubscriptionDAO subscriptionDAO;

    public SubscribeCommand(MongoSubscriptionDAO subscriptionDAO) {
        this.subscriptionDAO = subscriptionDAO;
    }

    @Override
    public void execute() {
        try {
            System.out.println("\n--- Nueva Suscripción ---");

            String email = InputValidation.validateEmailInput("Email: ");
            String name = InputValidation.validateStringInput("Nombre: ");
            String surnames = InputValidation.validateStringInput("Apellidos: ");

            Subscription subscription = new Subscription();
            subscription.setClientEmail(email);
            subscription.setName(name);
            subscription.setSurnames(surnames);

            subscriptionDAO.create(subscription);

            System.out.println("\n✅ Suscripción creada correctamente.");
            System.out.println("📧 Email: " + subscription.getClientEmail());
            System.out.println("👤 Nombre: " + subscription.getName() + " " + subscription.getSurnames());

        } catch (Exception e) {
            System.out.println("❌ Error inesperado al crear la suscripción: " + e.getMessage());
        }
    }
}
