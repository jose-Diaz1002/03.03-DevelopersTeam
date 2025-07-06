-- db_init.sql

-- Crea la base de datos si no existe
CREATE DATABASE IF NOT EXISTS escaperoom_db;

-- Usa la base de datos
USE escaperoom_db;

-- Tabla EscapeRoom (La entidad principal del negocio)
CREATE TABLE IF NOT EXISTS EscapeRoom (
                                          id INT AUTO_INCREMENT PRIMARY KEY,
                                          name VARCHAR(255) NOT NULL UNIQUE,
                                          total_inventory_value DECIMAL(10, 2) DEFAULT 0.00,
                                          total_sales DECIMAL(10, 2) DEFAULT 0.00
);

-- Tabla Player
CREATE TABLE IF NOT EXISTS Player (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      username VARCHAR(50) NOT NULL UNIQUE,
                                      email VARCHAR(100) NOT NULL UNIQUE,
                                      registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
--             Nota: Estas son solo las tablas iniciales que Persona 1 necesita para su DAO core. Persona 2 se encargará de añadir el resto de las tablas aquí.

