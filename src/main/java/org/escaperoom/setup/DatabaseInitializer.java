package org.escaperoom.setup;

import org.escaperoom.util.MySQLConnection;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initializeDatabase() throws Exception {
        try (Connection conn = MySQLConnection.getRootConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS scape_room");
        }

        try (Connection conn = MySQLConnection.getConnection();
             Statement dbTables = conn.createStatement()) {

            dbTables.executeUpdate("""
                CREATE TABLE IF NOT EXISTS scape_room (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(100) NOT NULL
                )
            """);

            dbTables.executeUpdate("""
                CREATE TABLE IF NOT EXISTS room (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    scapeRoom_id INT NOT NULL,
                    name VARCHAR(100) NOT NULL,
                    difficulty ENUM('EASY', 'MEDIUM', 'HARD') NOT NULL,
                    price DECIMAL(10,2) NOT NULL,
                    quantity INT NOT NULL,
                    FOREIGN KEY (scapeRoom_id) REFERENCES scape_room(id)
                )
            """);

            dbTables.executeUpdate("""
                CREATE TABLE IF NOT EXISTS clue (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    scapeRoom_id INT NOT NULL,
                    theme ENUM('TERROR', 'ROMANTIC', 'ACTION', 'PSYCHOLOGICAL') NOT NULL,
                    price DECIMAL(10,2) NOT NULL,
                    quantity INT NOT NULL,
                    FOREIGN KEY (scapeRoom_id) REFERENCES scape_room(id)
                )
            """);

            System.out.println("Base de datos y tablas creadas correctamente.");
        }
    }
}
