package org.escaperoom.view;

import org.escaperoom.input.InputReader;

public class ConsoleView {
    private final InputReader inputReader;

    public ConsoleView(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public void printWelcomeMessage() {
        System.out.println("¡Bienvenido a Escape Room Virtual! 🎉");
        System.out.println("Aquí podrás gestionar tus Escape Rooms, Salas, Pistas, Objetos Decorativos, Inventario, Ventas y Suscripciones.");
    }

    public void printMainMenu() {
        System.out.println("\n========= 🎮 ESCAPE ROOM VIRTUAL =========");
        System.out.println("1. Gestión de Escape Rooms       ➤ Crear, Ver, Editar, Eliminar");
        System.out.println("2. Gestión de Rooms              ➤ Crear, Ver, Editar, Eliminar");
        System.out.println("3. Gestión de Clues              ➤ Crear, Ver, Editar, Eliminar");
        System.out.println("4. Gestión de Objetos Decorativos ➤ Crear, Ver, Editar, Eliminar");
        System.out.println("5. 📦 Ver Inventario Actualizado");
        System.out.println("6. 💰 Ver Valor Total del Inventario (€)");
        System.out.println("7. 🎟️ Gestión de Tickets & Ventas");
        System.out.println("8. 📣 Gestión de Subscripciones y Notificaciones");
        System.out.println("0. ❌ Salir");
        System.out.println("=====================================");
    }
    public String readInput(String prompt) {
        System.out.print(prompt);             // Imprime el prompt una vez
        return inputReader.readLine();        // Lee la línea sin imprimir nada más
    }

    public void printError(String message) {
        System.err.println("Error: " + message);
    }

    public void printInfo(String message) {
        System.out.println(message);
    }

    public void printSuccess(String message) {
        System.out.println("✅ " + message);
    }

    public void printRoomMenu() {
        System.out.println("===== Menú de Salas =====");
        System.out.println("1. Crear Sala");
        System.out.println("2. Listar Salas");
        System.out.println("3. Actualizar Sala");
        System.out.println("4. Eliminar Sala");
        System.out.println("0. Volver");
    }

    public void printEscapeRoomMenu() {

        System.out.println("===== Menú de Escape Rooms =====");
        System.out.println("1. Crear Escape Room");
        System.out.println("2. Mostrar todos los Escape Rooms");
        System.out.println("3. Actualizar Escape Room");
        System.out.println("4. Eliminar Escape Room");
        System.out.println("0. Volver al menú principal");
    }



    public void printClueMenu() {
        System.out.println("\n===== MENÚ PISTAS =====");
        System.out.println("1. Crear Pista");
        System.out.println("2. Ver todas las Pistas");
        System.out.println("3. Actualizar Pista");
        System.out.println("4. Eliminar Pista");
        System.out.println("0. Volver");
    }



    public void printDecorationMenu() {
        System.out.println("\n========= 🎨 GESTIÓN DE OBJETOS DECORATIVOS =========");
        System.out.println("1. Crear objeto decorativo");
        System.out.println("2. Listar objetos decorativos");
        System.out.println("3. Actualizar objeto decorativo");
        System.out.println("4. Eliminar objeto decorativo");
        System.out.println("0. Volver al menú principal");
        System.out.println("======================================================");
    }

    public void printInventoryMenu() {
        System.out.println("===== Menú de Inventario =====");
        System.out.println("1. Ver Inventario Actualizado");
        System.out.println("2. Ver Valor Total del Inventario (€)");
        System.out.println("0. Volver al menú principal");
    }

    public void printSalesMenu() {
        System.out.println("===== Menú de Ventas =====");
        System.out.println("1. Crear Venta");
        System.out.println("2. Listar Ventas");
        System.out.println("3. Actualizar Venta");
        System.out.println("4. Eliminar Venta");
        System.out.println("0. Volver al menú principal");
    }

    public void printSubscriptionMenu() {
        System.out.println("===== Menú de Suscripciones =====");
        System.out.println("1. Crear Suscripción");
        System.out.println("2. Listar Suscripciones");
        System.out.println("3. Actualizar Suscripción");
        System.out.println("4. Eliminar Suscripción");
        System.out.println("0. Volver al menú principal");
    }
    public void printExitMessage() {
        System.out.println("Gracias por usar Escape Room Virtual. ¡Hasta luego!");
    }
}
