package org.escaperoom.view;

import org.escaperoom.controller.command.Command;
import org.escaperoom.controller.command.CreateEscapeRoomCommand;
import org.escaperoom.controller.command.ExitCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView {

    private final Map<Integer, Command> commands = new HashMap<>();

    public ConsoleView() {
        commands.put(1, new CreateEscapeRoomCommand());
        commands.put(2, new ExitCommand());
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear EscapeRoom");
            System.out.println("2. Salir");
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