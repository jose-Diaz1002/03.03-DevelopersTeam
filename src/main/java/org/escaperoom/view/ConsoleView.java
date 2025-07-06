package org.escaperoom.view;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Escape Room Application - Console Interface");
        boolean running = true;

        while (running) {
            printMenu();
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("Crear sala (pendiente implementar).");
                    break;
                case "2":
                    System.out.println("Mostrar todas las salas (pendiente implementar).");
                    break;
                case "0":
                    System.out.println("Saliendo...");
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Gracias por usar Escape Room App.");
    }

    private void printMenu() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Crear sala");
        System.out.println("2. Mostrar todas las salas");
        System.out.println("0. Salir");
        System.out.print("Ingresa tu opción: ");
    }


}
