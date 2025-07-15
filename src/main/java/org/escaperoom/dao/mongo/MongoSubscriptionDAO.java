package org.escaperoom.dao.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.escaperoom.dao.common.SubscriptionDAO;
import org.escaperoom.model.entity.Subscription;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class MongoSubscriptionDAO implements SubscriptionDAO {

    private final MongoCollection<Document> collection;

    public MongoSubscriptionDAO(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("escaperoom");
        this.collection = database.getCollection("subscriptions");
    }

    @Override
    public void create(Subscription subscription) {
        Document doc = new Document()
                .append("clientEmail", subscription.getClientEmail())
                .append("name", subscription.getName())
                .append("surnames", subscription.getSurnames());
        collection.insertOne(doc);
    }

    @Override
    public Subscription read(String clientEmail) {
        Document doc = collection.find(eq("clientEmail", clientEmail)).first();
        return doc != null ? mapDocumentToSubscription(doc) : null;
    }

    @Override
    public List<Subscription> readAll() {
        List<Subscription> subscriptions = new ArrayList<>();
        for (Document doc : collection.find()) {
            subscriptions.add(mapDocumentToSubscription(doc));
        }
        return subscriptions;
    }

    private Subscription mapDocumentToSubscription(Document doc) {
        Subscription subscription = new Subscription();
        subscription.set_id(doc.getObjectId("_id"));
        subscription.setClientEmail(doc.getString("clientEmail"));
        subscription.setName(doc.getString("name"));
        subscription.setSurnames(doc.getString("surnames"));
        return subscription;
    }

    @Override
    public void update(Subscription subscription) {
        Bson filter = eq("clientEmail", subscription.getClientEmail());
        Document updated = new Document("$set", new Document()
                .append("name", subscription.getName())
                .append("surnames", subscription.getSurnames()));
            UpdateResult result = collection.updateOne(filter, updated);
        if (result.getMatchedCount() == 0) {
            throw new IllegalArgumentException("Subscription with clientEmail " + subscription.getClientEmail() + " not found");
        }
    }

    @Override
    public void delete(String clientEmail) {
        collection.deleteOne(eq("clientEmail", clientEmail));
    }
}
