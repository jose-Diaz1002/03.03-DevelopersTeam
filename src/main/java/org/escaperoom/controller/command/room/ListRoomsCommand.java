package org.escaperoom.controller.command.room;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLRoomDAO;
import org.escaperoom.database.ConnectionFactory;
import org.escaperoom.input.InputReader;
import org.escaperoom.model.entity.Room;
import org.escaperoom.model.service.RoomService;

import java.sql.SQLException;
import java.util.List;

public class ListRoomsCommand implements Command {

    private final RoomService roomService;
    private final InputReader inputReader;

    public ListRoomsCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        try {
            this.roomService = new RoomService(
                    new MySQLRoomDAO(ConnectionFactory.getMySQLConnection())
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }

    @Override
    public void execute() {
        try {
            String input = inputReader.readLine("Introduce el ID del EscapeRoom: ").trim();
            int escapeRoomId = Integer.parseInt(input);

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
            System.out.println("❌ ID inválido. Debe ser un número entero.");
        } catch (SQLException e) {
            System.out.println("❌ Error al acceder a la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
