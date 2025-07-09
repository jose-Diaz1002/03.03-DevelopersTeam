package org.escaperoom.controller.command;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLRoomDAO;
import org.escaperoom.database.MySQLConnection;
import org.escaperoom.model.entity.Room;
import org.escaperoom.model.service.RoomService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ListRoomsCommand implements Command {

    private final RoomService roomService;
    private final Scanner scanner;

    public ListRoomsCommand(Scanner scanner) {
        this.scanner = scanner;
        try {
            this.roomService = new RoomService(
                    new MySQLRoomDAO(MySQLConnection.getInstance().getConnection())
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }

    @Override
    public void execute() {
        try {
            System.out.print("Introduce el ID del EscapeRoom: ");
            int escapeRoomId = Integer.parseInt(scanner.nextLine());

            List<Room> rooms = roomService.getRoomsByEscapeRoomId(escapeRoomId);
            if (rooms.isEmpty()) {
                System.out.println("No se encontraron salas asociadas a este EscapeRoom.");
            } else {
                System.out.println("Salas encontradas:");
                for (Room room : rooms) {
                    System.out.println(" - " + room);
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("ID inválido. Debe ser un número entero.");
        } catch (SQLException e) {
            System.out.println("Error al acceder a la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
