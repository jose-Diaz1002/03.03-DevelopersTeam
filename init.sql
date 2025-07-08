-- Base de datos
CREATE DATABASE IF NOT EXISTS virtual_escaperoom_db;
USE virtual_escaperoom_db;

-- EscapeRoom
CREATE TABLE EscapeRoom (
                            escape_room_id INT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255) NOT NULL
);

-- Room
CREATE TABLE Room (
                      room_id INT AUTO_INCREMENT PRIMARY KEY,
                      escape_room_id INT NOT NULL,
                      name VARCHAR(255) NOT NULL,
                      difficulty_level ENUM('Easy', 'Medium', 'Hard', 'Expert') NOT NULL,
                      price DECIMAL(8, 2) NOT NULL,
                      quantity_available INT DEFAULT 0,
                      FOREIGN KEY (escape_room_id) REFERENCES EscapeRoom(escape_room_id)
);

-- Clue
CREATE TABLE Clue (
                      clue_id INT AUTO_INCREMENT PRIMARY KEY,
                      room_id INT NOT NULL,
                      theme ENUM('Mystery', 'Horror', 'Fantasy', 'Sci-Fi', 'Historical', 'Adventure') NOT NULL,
                      price DECIMAL(8, 2) NOT NULL,
                      quantity_available INT DEFAULT 0,
                      FOREIGN KEY (room_id) REFERENCES Room(room_id)
);

-- DecorationObject
CREATE TABLE DecorationObject (
                                  decoration_object_id INT AUTO_INCREMENT PRIMARY KEY,
                                  room_id INT NOT NULL,
                                  name VARCHAR(255) NOT NULL,
                                  material_type VARCHAR(255),
                                  price DECIMAL(8, 2) NOT NULL,
                                  quantity_available INT DEFAULT 0,
                                  FOREIGN KEY (room_id) REFERENCES Room(room_id)
);

-- Player
CREATE TABLE Player (
                        player_id INT AUTO_INCREMENT PRIMARY KEY,
                        username VARCHAR(255) NOT NULL UNIQUE,
                        email VARCHAR(255) NOT NULL UNIQUE
);

-- Ticket
CREATE TABLE Ticket (
                        ticket_id INT AUTO_INCREMENT PRIMARY KEY,
                        player_id INT NOT NULL,
                        room_id INT NOT NULL,
                        purchase_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                        total_amount DECIMAL(10, 2) NOT NULL,
                        FOREIGN KEY (player_id) REFERENCES Player(player_id),
                        FOREIGN KEY (room_id) REFERENCES Room(room_id)
);

-- Achievement
CREATE TABLE Achievement (
                             achievement_id INT AUTO_INCREMENT PRIMARY KEY,
                             player_id INT NOT NULL,
                             room_id INT,
                             description TEXT NOT NULL,
                             achievement_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                             reward_given BOOLEAN DEFAULT FALSE,
                             FOREIGN KEY (player_id) REFERENCES Player(player_id),
                             FOREIGN KEY (room_id) REFERENCES Room(room_id)
);

-- Certificate
CREATE TABLE Certificate (
                             certificate_id INT AUTO_INCREMENT PRIMARY KEY,
                             player_id INT NOT NULL,
                             achievement_id INT NOT NULL,
                             certificate_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                             message TEXT,
                             FOREIGN KEY (player_id) REFERENCES Player(player_id),
                             FOREIGN KEY (achievement_id) REFERENCES Achievement(achievement_id)
);

-- Reward
CREATE TABLE Reward (
                        reward_id INT AUTO_INCREMENT PRIMARY KEY,
                        achievement_id INT NOT NULL,
                        reward_type VARCHAR(255) NOT NULL,
                        reward_description TEXT,
                        FOREIGN KEY (achievement_id) REFERENCES Achievement(achievement_id)
);

-- Event
CREATE TABLE Event (
                       event_id INT AUTO_INCREMENT PRIMARY KEY,
                       event_type VARCHAR(255) NOT NULL,
                       event_description TEXT NOT NULL,
                       event_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Subscription
CREATE TABLE Subscription (
                              subscription_id INT AUTO_INCREMENT PRIMARY KEY,
                              player_id INT NOT NULL,
                              event_type_subscribed VARCHAR(255) NOT NULL,
                              FOREIGN KEY (player_id) REFERENCES Player(player_id)
);
