/*use escaperoomDB;

if (!db.getCollectionNames().includes('subscriptions')) {
    db.createCollection('subscriptions');
    print("Collection 'subscriptions' created");
} else {
    print("Collection 'subscriptions' already exists");
}

db.subscriptions.createIndex(
    { clientEmail: 1 },
    { unique: true }
);
print("Unique index created on clientEmail");

try {
    db.subscriptions.insertOne({
        clientEmail: "cliente@example.com",
        name: "Juan",
        surnames: "Pérez Gómez"
    });
    print("Inserted example subscription document");
} catch(e) {
    print("Error inserting document (probably duplicate clientEmail): " + e);
}

print("Current documents in 'subscriptions':");
printjson(db.subscriptions.find().toArray());
*/