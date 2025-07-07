package org.escaperoom;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.sql.Connection;
import java.sql.DriverManager;


public class App {
    public static void main(String[] args) {
        System.out.println("=== Test de Conexión a MySQL y MongoDB ===");

        testMySQLConnection();
        //testMongoConnection();

        System.out.println("=== Fin de las pruebas ===");
    }


    private static void testMySQLConnection() {
        String host = System.getenv("MYSQL_HOST");
        String port = System.getenv("MYSQL_PORT");
        String db = System.getenv("MYSQL_DB");
        String user = System.getenv("MYSQL_USER");
        String pass = System.getenv("MYSQL_PASS");
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?useSSL=false&serverTimezone=UTC";

        int retries = 5;
        while (retries > 0) {
            try (Connection conn = DriverManager.getConnection(url, user, pass)) {
                System.out.println("Conexión MySQL exitosa!");
                // ... mostrar tablas ...
                break;
            } catch (Exception e) {
                System.err.println("Error conectando a MySQL. Reintentos restantes: " + (retries - 1));
                retries--;
                try {
                    Thread.sleep(5000); // Esperar 5 seg antes de reintentar
                } catch (InterruptedException ignored) {}
            }
        }
    }


    private static void testMongoConnection() {
        String host = System.getenv("MONGO_HOST");
        String port = System.getenv("MONGO_PORT");
        String db = System.getenv("MONGO_DB");
        String user = "root"; // fija para este ejemplo
        String pass = System.getenv("MONGO_INITDB_ROOT_PASSWORD");

        System.out.println("Probando conexión a MongoDB en " + host + ":" + port);

        String connectionString = "mongodb://" + user + ":" + pass + "@" + host + ":" + port + "/" + db + "?authSource=admin";

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase(db);
            System.out.println("Bases de datos disponibles:");
            for (String name : mongoClient.listDatabaseNames()) {
                System.out.println(" - " + name);
            }
            System.out.println("Conexión MongoDB exitosa!");
        } catch (MongoException e) {
            System.err.println("Error conectando a MongoDB:");
            e.printStackTrace();
        }
    }
}