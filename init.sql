-- Creación de la Base de Datos
CREATE DATABASE IF NOT EXISTS escaperoom_db;
USE escaperoom_db;

-- Tabla: EscapeRoom
-- Representa la instancia principal del Escape Room virtual con sus valores globales.
CREATE TABLE EscapeRoom (
                            escape_room_id INT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            total_inventory_value DECIMAL(10, 2) DEFAULT 0.00, -- Valor total de salas, pistas y objetos en el inventario
                            total_ticket_sales DECIMAL(10, 2) DEFAULT 0.00 -- Ingresos totales generados por la venta de tickets
);

-- Tabla: Room (Sala)
-- Define las diferentes salas temáticas disponibles en el Escape Room.
-- Cada sala tiene un nivel de dificultad y un precio.
CREATE TABLE Room (
                      room_id INT AUTO_INCREMENT PRIMARY KEY,
                      escape_room_id INT NOT NULL,
                      name VARCHAR(255) NOT NULL,
                      difficulty_level ENUM('Easy', 'Medium', 'Hard', 'Expert') NOT NULL, -- Nivel de dificultad de la sala
                      price DECIMAL(8, 2) NOT NULL, -- Precio de acceso a esta sala
                      quantity_available INT NOT NULL DEFAULT 0, -- Cantidad disponible de esta sala (útil para inventario)
                      FOREIGN KEY (escape_room_id) REFERENCES EscapeRoom(escape_room_id)
);

-- Tabla: Clue (Pista)
-- Almacena las pistas diseñadas con temas específicos para cada sala.
CREATE TABLE Clue (
                      clue_id INT AUTO_INCREMENT PRIMARY KEY,
                      room_id INT NOT NULL, -- Cada pista pertenece a una sala específica
                      theme ENUM('Mystery', 'Horror', 'Fantasy', 'Sci-Fi', 'Historical', 'Adventure') NOT NULL, -- Tema descriptivo de la pista como ENUM
                      price DECIMAL(8, 2) NOT NULL, -- Precio asociado a la pista (si se venden individualmente o tienen valor en inventario)
                      quantity_available INT NOT NULL DEFAULT 0, -- Cantidad disponible (útil para inventario)
                      FOREIGN KEY (room_id) REFERENCES Room(room_id)
);

-- Tabla: DecorationObject (Objeto de Decoración)
-- Contiene objetos de decoración únicos que contribuyen a la atmósfera de cada sala.
CREATE TABLE DecorationObject (
                                  decoration_object_id INT AUTO_INCREMENT PRIMARY KEY,
                                  room_id INT NOT NULL, -- Cada objeto de decoración pertenece a una sala específica
                                  name VARCHAR(255) NOT NULL,
                                  material_type VARCHAR(255), -- Tipo de material del objeto
                                  price DECIMAL(8, 2) NOT NULL, -- Precio asociado al objeto (si se venden o tienen valor en inventario)
                                  quantity_available INT NOT NULL DEFAULT 0, -- Cantidad disponible (útil para inventario)
                                  FOREIGN KEY (room_id) REFERENCES Room(room_id)
);

-- Tabla: Player (Jugador)
-- Registra a los usuarios que interactúan con el Escape Room.
CREATE TABLE Player (
                        player_id INT AUTO_INCREMENT PRIMARY KEY,
                        username VARCHAR(255) NOT NULL UNIQUE,
                        email VARCHAR(255) NOT NULL UNIQUE
);

-- Tabla: Ticket
-- Registra los tiquets de venta, que otorgan acceso a una sala específica a un jugador.
CREATE TABLE Ticket (
                        ticket_id INT AUTO_INCREMENT PRIMARY KEY,
                        player_id INT NOT NULL,
                        room_id INT NOT NULL, -- Un ticket se compra para acceder a una sala específica (según el enunciado)
                        purchase_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Fecha y hora de la compra del ticket
                        total_amount DECIMAL(10, 2) NOT NULL, -- Valor total del ticket
                        FOREIGN KEY (player_id) REFERENCES Player(player_id),
                        FOREIGN KEY (room_id) REFERENCES Room(room_id)
);

-- Tabla: Achievement (Logro/Certificado)
-- Almacena los logros y certificados de superación de enigmas conseguidos por los jugadores.
CREATE TABLE Achievement (
                             achievement_id INT AUTO_INCREMENT PRIMARY KEY,
                             player_id INT NOT NULL,
                             room_id INT, -- Opcional: la sala en la que se consiguió el logro (si aplica)
                             description TEXT NOT NULL, -- Descripción del logro o enigma superado
                             achievement_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Fecha en que se logró
                             reward_given BOOLEAN DEFAULT FALSE, -- Indica si se otorgó un regalo o recompensa
                             FOREIGN KEY (player_id) REFERENCES Player(player_id),
                             FOREIGN KEY (room_id) REFERENCES Room(room_id)
);

-- Tabla: Event (Evento)
-- Registra los sucesos importantes del Escape Room (adición de pistas, finalización de salas, etc.).
-- Es la base para el sistema de notificaciones a los suscriptores.
CREATE TABLE Event (
                       event_id INT AUTO_INCREMENT PRIMARY KEY,
                       event_type VARCHAR(255) NOT NULL, -- Tipo de evento (ej. 'New Clue Added', 'Room Completed', 'New Room Available')
                       event_description TEXT NOT NULL, -- Descripción detallada del evento para las notificaciones
                       event_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP -- Fecha y hora en que ocurrió el evento
);

-- Tabla: Subscription (Suscripción)
-- Permite a los jugadores registrarse para recibir notificaciones sobre tipos específicos de eventos.
-- Implementa el patrón Observer: los jugadores (suscriptores) observan ciertos tipos de eventos.
CREATE TABLE Subscription (
                              subscription_id INT AUTO_INCREMENT PRIMARY KEY,
                              player_id INT NOT NULL,
                              event_type_subscribed VARCHAR(255) NOT NULL, -- El tipo de evento al que el jugador está suscrito
                              FOREIGN KEY (player_id) REFERENCES Player(player_id)
);