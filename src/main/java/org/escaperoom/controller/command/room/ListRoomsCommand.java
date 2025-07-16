package org.escaperoom.controller.command.room;
import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.dao.mysql.MySQLRoomDAO;
import org.escaperoom.database.ConnectionFactory;
import org.escaperoom.util.ConsoleTablePrinter;
import org.escaperoom.util.InputReader;
import org.escaperoom.model.entity.Room;
import org.escaperoom.service.RoomService;
import org.escaperoom.util.InputValidator;

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
            String input = InputValidator.readString(inputReader, "Ingrese el ID del EscapeRoom para listar sus salas: ");
            int escapeRoomId = InputValidator.validatePositiveInt(input);
            while (escapeRoomId <= 0) {
                input = InputValidator.readString(inputReader, "Ingrese el ID del EscapeRoom para listar sus salas: ");
                escapeRoomId = InputValidator.validatePositiveInt(input);
            }

            List<Room> rooms = roomService.getRoomsByEscapeRoomId(escapeRoomId);
            if (rooms.isEmpty()) {
                System.out.println("ℹ️ No se encontraron salas para el EscapeRoom con ID " + escapeRoomId);
            } else {
                System.out.println(" ➡️ Salas del EscapeRoom con ID " + escapeRoomId + ":");
                ConsoleTablePrinter.printRoomsTable(rooms);

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
