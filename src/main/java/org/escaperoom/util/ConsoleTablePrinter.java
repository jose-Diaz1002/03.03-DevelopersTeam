package org.escaperoom.util;

import org.escaperoom.model.entity.Room;
import org.escaperoom.model.entity.Ticket;

import java.text.SimpleDateFormat;
import java.util.List;

public class ConsoleTablePrinter {

    // Imprime una lista de Rooms en formato tabla bonita
    public static void printRoomsTable(List<Room> rooms) {
        if (rooms == null || rooms.isEmpty()) {
            System.out.println("No hay salas para mostrar.");
            return;
        }

        String format = "| %-5s | %-25s | %-10s | %-10s | %-10s |%n";
        String line = "+-------+---------------------------+------------+------------+------------+";

        System.out.println(line);
        System.out.printf(format, "ID", "Nombre", "Dificultad", "Precio (€)", "Cantidad");
        System.out.println(line);

        for (Room room : rooms) {
            System.out.printf(format,
                    room.getRoomId(),
                    room.getName(),
                    room.getDifficultyLevel().name(),
                    String.format("%.2f", room.getPrice()),
                    room.getQuantityAvailable()
            );
        }
        System.out.println(line);
    }

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    // Ya tienes printRoomsTable (del ejemplo anterior), ahora agrego para tickets:

    public static void printTicketsTable(List<Ticket> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            System.out.println("No hay tickets para mostrar.");
            return;
        }

        String format = "| %-5s | %-10s | %-15s | %-10s |%n";
        String line = "+-------+------------+-----------------+------------+";

        System.out.println(line);
        System.out.printf(format, "ID", "Player ID", "Fecha", "Precio (€)");
        System.out.println(line);

        for (Ticket ticket : tickets) {
            System.out.printf(format,
                    ticket.getTicketId(),
                    ticket.getPlayerName(),
                    DATE_FORMAT.format(ticket.getPurchaseDate()),
                    String.format("%.2f", ticket.getPrice())
            );
        }
        System.out.println(line);
    }
}
