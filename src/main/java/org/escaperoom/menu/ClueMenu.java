package org.escaperoom.menu;


import org.escaperoom.dao.mysql.ClueMySQLDAO;
import org.escaperoom.model.Clue;

import java.util.List;
import java.util.Scanner;

public class ClueMenu {
    /*

    private final ClueMySQLDAO clueDAO = new ClueMySQLDAO();
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n--- MENÚ ESCAPE ROOM ---");
            System.out.println("1. Crear tabla");
            System.out.println("2. Insertar Clue");
            System.out.println("3. Listar Clues");
            System.out.println("4. Obtener Clue por ID");
            System.out.println("5. Actualizar Clue");
            System.out.println("6. Eliminar Clue");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar

            switch (opcion) {
                case 1 -> clueDAO.crearTablaSiNoExiste();
                case 2 -> insertarClue();
                case 3 -> listarClues();
                case 4 -> obtenerClue();
                case 5 -> actualizarClue();
                case 6 -> eliminarClue();
                case 0 -> System.out.println("¡Adiós!");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void insertarClue() {
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Tema: ");
        String theme = scanner.nextLine();
        System.out.print("Precio: ");
        double price = scanner.nextDouble();

        Clue clue = new Clue(0, name, theme, price);
        clueDAO.insertarClue(clue);
    }

    private void listarClues() {
        List<Clue> clues = clueDAO.listarClues();
        for (Clue c : clues) {
            System.out.println(c);
        }
    }

    private void obtenerClue() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        Clue c = clueDAO.obtenerCluePorId(id);
        System.out.println(c != null ? c : "No encontrado.");
    }

    private void actualizarClue() {
        System.out.print("ID a actualizar: ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Nuevo nombre: ");
        String name = scanner.nextLine();
        System.out.print("Nuevo tema: ");
        String theme = scanner.nextLine();
        System.out.print("Nuevo precio: ");
        double price = scanner.nextDouble();

        Clue c = new Clue(id, name, theme, price);
        clueDAO.actualizarClue(c);
    }

    private void eliminarClue() {
        System.out.print("ID a eliminar: ");
        int id = scanner.nextInt();
        clueDAO.eliminarClue(id);
    }

     */
}

