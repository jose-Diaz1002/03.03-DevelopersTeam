package org.escaperoom.controller.command.room;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLRoomDAO;
import org.escaperoom.database.ConnectionFactory;
import org.escaperoom.model.entity.Room;
import org.escaperoom.service.RoomService;
import org.escaperoom.util.ConsoleTablePrinter;
import org.escaperoom.util.InputValidation;

import java.sql.SQLException;
import java.util.List;

public class ListRoomsCommand implements Command {

    private final RoomService roomService;

    public ListRoomsCommand() {
        try {
            this.roomService = new RoomService(
                    new MySQLRoomDAO(ConnectionFactory.getMySQLConnection())
            );
        } catch (SQLException e) {
            throw new RuntimeException("❌ Error al conectar con la base de datos", e);
        }
    }

    @Override
    public void execute() {
        try {
            int escapeRoomId = InputValidation.validateIdInput("Ingrese el ID del EscapeRoom para listar sus salas: ");

            List<Room> rooms = roomService.getRoomsByEscapeRoomId(escapeRoomId);
            if (rooms.isEmpty()) {
                System.out.println("ℹ️ No se encontraron salas para el EscapeRoom con ID " + escapeRoomId);
            } else {
                System.out.println("➡️ Salas del EscapeRoom con ID " + escapeRoomId + ":");
                ConsoleTablePrinter.printRoomsTable(rooms);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al acceder a la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
}
