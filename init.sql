-- Creación de la Base de Datos
CREATE DATABASE IF NOT EXISTS virtual_escaperoom_db;
USE virtual_escaperoom_db;

-- Tabla: EscapeRoom
CREATE TABLE EscapeRoom (
                            escape_room_id INT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            total_inventory_value DECIMAL(10, 2) DEFAULT 0.00,
                            total_ticket_sales DECIMAL(10, 2) DEFAULT 0.00
);

-- Tabla: Room
CREATE TABLE Room (
                      room_id INT AUTO_INCREMENT PRIMARY KEY,
                      escape_room_id INT NOT NULL,
                      name VARCHAR(255) NOT NULL,
                      difficulty_level ENUM('Easy', 'Medium', 'Hard', 'Expert') NOT NULL,
                      price DECIMAL(8, 2) NOT NULL,
                      quantity_available INT NOT NULL DEFAULT 0,
                      FOREIGN KEY (escape_room_id) REFERENCES EscapeRoom(escape_room_id) ON DELETE CASCADE
);

-- Tabla: Clue
CREATE TABLE Clue (
                      clue_id INT AUTO_INCREMENT PRIMARY KEY,
                      room_id INT NOT NULL,
                      theme ENUM('Mystery', 'Horror', 'Fantasy', 'Sci-Fi', 'Historical', 'Adventure') NOT NULL,
                      price DECIMAL(8, 2) NOT NULL,
                      quantity_available INT NOT NULL DEFAULT 0,
                      FOREIGN KEY (room_id) REFERENCES Room(room_id) ON DELETE CASCADE
);

-- Tabla: DecorationObject
CREATE TABLE DecorationObject (
                                  decoration_object_id INT AUTO_INCREMENT PRIMARY KEY,
                                  room_id INT NOT NULL,
                                  name VARCHAR(255) NOT NULL,
                                  material_type VARCHAR(255),
                                  price DECIMAL(8, 2) NOT NULL,
                                  quantity_available INT NOT NULL DEFAULT 0,
                                  FOREIGN KEY (room_id) REFERENCES Room(room_id) ON DELETE CASCADE
);

-- Tabla: Player
CREATE TABLE Player (
                        player_id INT AUTO_INCREMENT PRIMARY KEY,
                        username VARCHAR(255) NOT NULL UNIQUE,
                        email VARCHAR(255) NOT NULL UNIQUE
);

-- Tabla: Ticket
CREATE TABLE Ticket (
                        ticket_id INT AUTO_INCREMENT PRIMARY KEY,
                        player_id INT NOT NULL,
                        room_id INT NOT NULL,
                        purchase_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        total_amount DECIMAL(10, 2) NOT NULL,
                        FOREIGN KEY (player_id) REFERENCES Player(player_id) ON DELETE CASCADE,
                        FOREIGN KEY (room_id) REFERENCES Room(room_id) ON DELETE CASCADE
);

-- Tabla: Achievement
CREATE TABLE Achievement (
                             achievement_id INT AUTO_INCREMENT PRIMARY KEY,
                             player_id INT NOT NULL,
                             room_id INT,
                             description TEXT NOT NULL,
                             achievement_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             reward_given BOOLEAN DEFAULT FALSE,
                             FOREIGN KEY (player_id) REFERENCES Player(player_id) ON DELETE CASCADE,
                             FOREIGN KEY (room_id) REFERENCES Room(room_id) ON DELETE CASCADE
);

-- Tabla: Event
CREATE TABLE Event (
                       event_id INT AUTO_INCREMENT PRIMARY KEY,
                       event_type VARCHAR(255) NOT NULL,
                       event_description TEXT NOT NULL,
                       event_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Tabla: Subscription
CREATE TABLE Subscription (
                              subscription_id INT AUTO_INCREMENT PRIMARY KEY,
                              player_id INT NOT NULL,
                              event_type_subscribed VARCHAR(255) NOT NULL,
                              FOREIGN KEY (player_id) REFERENCES Player(player_id) ON DELETE CASCADE
);
