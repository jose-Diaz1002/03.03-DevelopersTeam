package org.escaperoom.view;

import org.escaperoom.controller.command.room.AddClueCommand;
import org.escaperoom.controller.command.room.CreateRoomCommand;
import org.escaperoom.controller.command.ListRoomsCommand;
import org.escaperoom.controller.command.escapeRoom.CreateEscapeRoomCommand;
import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.controller.command.ExitCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView {

    private final Map<Integer, Command> commands = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);


    public ConsoleView() {
        commands.put(1, new CreateEscapeRoomCommand());
        commands.put(2, new CreateRoomCommand(scanner, 1)); // -1 porque aún no hay EscapeRoom creado
        commands.put(3, new ListRoomsCommand(new Scanner(System.in)));
        commands.put(0, new ExitCommand());
        commands.put(4, new AddClueCommand(scanner, 4));

    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear EscapeRoom");
            System.out.println("2. Crear Sala");
            System.out.println("3. Listar Salas de un EscapeRoom");
            System.out.println("0. Salir");
            System.out.println("4. Crear Clue");

            System.out.print("Elige una opción: ");

            int option;
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un número válido.");
                continue;
            }

            Command command = commands.get(option);
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }
}