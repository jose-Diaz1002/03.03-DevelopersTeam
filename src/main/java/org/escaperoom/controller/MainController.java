package org.escaperoom.controller;


import org.escaperoom.controller.command.escapeRoom.CreateEscapeRoomCommand;
import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.controller.command.room.CreateRoomCommand;
import org.escaperoom.controller.command.system.ExitCommand;
import org.escaperoom.dao.mysql.MySQLEscapeRoomDAO;
import org.escaperoom.dao.mysql.MySQLRoomDAO;
import org.escaperoom.database.ConnectionFactory;
import org.escaperoom.input.InputReader;
import org.escaperoom.model.service.EscapeRoomService;
import org.escaperoom.model.service.RoomService;

import java.sql.SQLException;

public class MainController {

    private final InputReader inputReader;
    private final EscapeRoomController escapeRoomController;
    private final RoomController roomController;
    private final RoomService roomService;
    private final EscapeRoomService escapeRoomService;

    private int currentEscapeRoomId = -1;

    public MainController(InputReader inputReader) {
        this.inputReader = inputReader;

        MySQLEscapeRoomDAO escapeRoomDAO;
        try {
            escapeRoomDAO = new MySQLEscapeRoomDAO(ConnectionFactory.getMySQLConnection());
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener conexión BD para EscapeRoomDAO", e);
        }
        this.escapeRoomService = new EscapeRoomService(escapeRoomDAO, inputReader);

        this.escapeRoomController = new EscapeRoomController(inputReader, escapeRoomService);

        try {
            this.roomService = new RoomService(new MySQLRoomDAO(ConnectionFactory.getMySQLConnection()));
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener conexión BD para RoomService", e);
        }
        this.roomController = new RoomController(inputReader, roomService);
    }

    public void start() {
        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Crear Escape Room");
            System.out.println("2. Seleccionar Escape Room existente");
            System.out.println("3. Crear Room (Sala)");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            String input = inputReader.readString().trim();
            Command command = null;

            switch (input) {
                case "1":
                    command = new CreateEscapeRoomCommand(inputReader, escapeRoomService);
                    break;
                case "2":
                    currentEscapeRoomId = escapeRoomController.selectEscapeRoom();
                    break;
                case "3":
                    if (currentEscapeRoomId == -1) {
                        System.out.println("Primero debes seleccionar o crear un EscapeRoom.");
                        break;
                    }
                    command = new CreateRoomCommand(inputReader, currentEscapeRoomId, roomService);
                    break;
                case "0":
                    command = new ExitCommand();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            if (command != null) {
                command.execute();
            }
        }
    }
}
