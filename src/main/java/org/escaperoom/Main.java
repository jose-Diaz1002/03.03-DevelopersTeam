package org.escaperoom;

import org.escaperoom.setup.DatabaseInitializer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            DatabaseInitializer.initializeDatabase();
        } catch (Exception e) {
            System.out.println("Error al inicializar la base de datos: " + e.getMessage());
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("===== MENU ESCAPE ROOM =====");
            System.out.println("1. Crear nuevo ScapeRoom");
            System.out.println("2. Crear nueva Room");
            System.out.println("3. Crear nueva Clue");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Función para crear ScapeRoom (a implementar)...");
                    break;
                case "2":
                    System.out.println("Función para crear Room (a implementar)...");
                    break;
                case "3":
                    System.out.println("Función para crear Clue (a implementar)...");
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        sc.close();

    }
}