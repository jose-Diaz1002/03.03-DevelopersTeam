package org.escaperoom.util;

import org.escaperoom.model.entity.*;

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


    public static void printSubscriptionsTable(List<Subscription> subscriptions) {
        if (subscriptions == null || subscriptions.isEmpty()) {
            System.out.println("No hay tickets para mostrar.");
            return;
        }

        String format = "| %-30s | %-15s | %-20s |%n";
        String line = "+--------------------------------+-----------------+----------------------+";

        System.out.println(line);
        System.out.printf(format, "Email", "Name", "Surnames");
        System.out.println(line);

        for (Subscription sub : subscriptions) {
            System.out.printf(format,
                    sub.getClientEmail(),
                    sub.getName(),
                    sub.getSurnames());
        }

        System.out.println(line);
    }

    public static void printEscapeRoomsTable(List<EscapeRoom> escapeRooms) {
        if (escapeRooms == null || escapeRooms.isEmpty()) {
            System.out.println("No hay Escape Rooms registrados.");
            return;
        }

        String format = "| %-5s | %-25s |%n";
        String line = "+-------+---------------------------+";

        System.out.println(line);
        System.out.printf(format, "ID", "Nombre");
        System.out.println(line);

        for (EscapeRoom er : escapeRooms) {
            System.out.printf(format,
                    er.getId(),
                    er.getName()
            );
        }
        System.out.println(line);
    }


    public static void printEscapeRoomDetails(EscapeRoom escapeRoom) {
        String line = "+-------+---------------------------+---------------------------+-------------------+";
        String format = "| %-5s | %-25s | %-25s | %-17s |%n";

        System.out.println(line);
        System.out.printf(format, "ID", "Nombre", "Inventario Total (€)", "Ventas Total (€)");
        System.out.println(line);
        System.out.printf(format,
                escapeRoom.getId(),
                escapeRoom.getName(),
                String.format("%.2f", escapeRoom.getTotalInventoryValue()),
                String.format("%.2f", escapeRoom.getTotalTicketSales())
        );
        System.out.println(line);
    }


/*    public static void printCluesTable(List<Clue> clues) {
        if (clues == null || clues.isEmpty()) {
            System.out.println("No hay pistas para mostrar.");
            return;
        }

        String format = "| %-5s | %-15s | %-10s | %-8s |%n";
        String line = "+-------+-----------------+------------+----------+";

        System.out.println(line);
        System.out.printf(format, "ID", "Tema", "Precio (€)", "Cantidad");
        System.out.println(line);

        for (Clue clue : clues) {
            System.out.printf(format,
                    clue.getId(),
                    clue.getTheme().name(),
                    String.format("%.2f", clue.getPrice()),
                    clue.getQuantityAvailable()
            );
        }
        System.out.println(line);
    }*/

    public static void printCluesTable(List<Clue> clues) {
        System.out.printf("%-5s %-10s %-15s %-10s %-10s%n", "ID", "RoomID", "Theme", "Price (€)", "Quantity");
        System.out.println("--------------------------------------------------------");
        for (Clue clue : clues) {
            System.out.printf(
                    "%-5d %-10d %-15s %-10.2f %-10d%n",
                    clue.getId(),
                    clue.getRoomId(),
                    clue.getTheme().name(),
                    clue.getPrice(),
                    clue.getQuantityAvailable()
            );
        }
    }

    public static void printDecorationsTable(List<DecorationObject> decorations) {
        if (decorations == null || decorations.isEmpty()) {
            System.out.println("No hay objetos decorativos para mostrar.");
            return;
        }

        String format = "| %-5s | %-20s | %-15s | %-10s | %-8s |%n";
        String line = "+-------+----------------------+-----------------+------------+----------+";

        System.out.println(line);
        System.out.printf(format, "ID", "Nombre", "Material", "Precio (€)", "Cantidad");
        System.out.println(line);

        for (DecorationObject obj : decorations) {
            System.out.printf(format,
                    obj.getId(),
                    obj.getName(),
                    obj.getMaterialType(),
                    String.format("%.2f", obj.getPrice()),
                    obj.getQuantityAvailable()
            );
        }
        System.out.println(line);
    }

    public static void printRoomDetails(Room room) {
        System.out.println("\n✅ Sala creada con éxito. Detalles:");
        System.out.println("+----------------+---------------------------+");
        System.out.printf("| %-14s | %-25s |\n", "Campo", "Valor");
        System.out.println("+----------------+---------------------------+");
        System.out.printf("| %-14s | %-25d |\n", "ID Sala", room.getRoomId());
        System.out.printf("| %-14s | %-25d |\n", "ID EscapeRoom", room.getEscapeRoomId());
        System.out.printf("| %-14s | %-25s |\n", "Nombre", room.getName());
        System.out.printf("| %-14s | %-25s |\n", "Dificultad", room.getDifficultyLevel());
        System.out.printf("| %-14s | %-25.2f |\n", "Precio (€)", room.getPrice().doubleValue());
        System.out.printf("| %-14s | %-25d |\n", "Cantidad", room.getQuantityAvailable());
        System.out.println("+----------------+---------------------------+");
    }

    public static void printRoomTable(Room room) {
        System.out.println("\n+-----+----------------------+------------+----------+------------+");
        System.out.printf("| %-3s | %-20s | %-10s | %-8s | %-10s |\n", "ID", "Nombre", "Dificultad", "Precio", "Cantidad");
        System.out.println("+-----+----------------------+------------+----------+------------+");
        System.out.printf("| %-3d | %-20s | %-10s | %8.2f€ | %-10d |\n",
                room.getRoomId(),
                room.getName(),
                room.getDifficultyLevel().name(),
                room.getPrice().doubleValue(),
                room.getQuantityAvailable());
        System.out.println("+-----+----------------------+------------+----------+------------+\n");
    }

}


