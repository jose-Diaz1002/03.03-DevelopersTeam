package org.escaperoom.view;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.util.InputReader;

import java.util.Map;

import static java.lang.System.*;

public class ConsoleView {
    private final InputReader inputReader;

    public ConsoleView(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public void printWelcomeMessage() {
        out.println("¡Bienvenido a Escape Room Virtual! 🎉");
        out.println("Aquí podrás gestionar tus Escape Rooms, Salas, Pistas, Objetos Decorativos, Inventario, Ventas y Suscripciones.");
    }

    public void printMainMenu() {

        out.println("\n========= 🎮 ESCAPE ROOM VIRTUAL =========");
        out.println("1. Gestión de Escape Rooms       ➤ Crear, Ver, Editar, Eliminar");
        out.println("2. Gestión de Rooms              ➤ Crear, Ver, Editar, Eliminar");
        out.println("3. Gestión de Clues              ➤ Crear, Ver, Editar, Eliminar");
        out.println("4. Gestión de Objetos Decorativos ➤ Crear, Ver, Editar, Eliminar");
        out.println("5. 📦 Ver Inventario Actualizado");
        out.println("6. 💰 Ver Valor Total del Inventario (€)");
        out.println("7. 🎟️ Gestión de Tickets & Ventas");
        out.println("8. 📣 Gestión de Subscripciones y Notificaciones");
        out.println("0. ❌ Salir");
        out.println("=====================================");

    }

    public void printRoomMenu() {
        out.println("===== Menú de Salas =====");
        out.println("1. Crear Sala");
        out.println("2. Listar Salas");
        out.println("3. Actualizar Sala");
        out.println("4. Eliminar Sala");
        out.println("0. Volver");
    }

    public void printEscapeRoomMenu() {

        out.println("===== Menú de Escape Rooms =====");
        out.println("1. Crear Escape Room");
        out.println("2. Mostrar todos los Escape Rooms");
        out.println("3. Actualizar Escape Room");
        out.println("4. Eliminar Escape Room");
        out.println("0. Volver al menú principal");
    }



    public void printClueMenu() {
        out.println("\n===== MENÚ PISTAS =====");
        out.println("1. Crear Pista");
        out.println("2. Ver todas las Pistas");
        out.println("3. Actualizar Pista");
        out.println("4. Eliminar Pista");
        out.println("0. Volver");
    }



    public void printDecorationMenu() {
        out.println("\n========= 🎨 GESTIÓN DE OBJETOS DECORATIVOS =========");
        out.println("1. Crear objeto decorativo");
        out.println("2. Listar objetos decorativos");
        out.println("3. Actualizar objeto decorativo");
        out.println("4. Eliminar objeto decorativo");
        out.println("0. Volver al menú principal");
        out.println("======================================================");
    }

    public void printInventoryMenu() {
        out.println("===== Menú de Inventario =====");
        out.println("1. Ver Inventario Actualizado");
        out.println("2. Ver Valor Total del Inventario (€)");
        out.println("0. Volver al menú principal");
    }

    public void printTicketsMenu() {
        System.out.println("\n🎟️ MENÚ GESTIÓN DE TICKETS 🎟️");
        System.out.println("1️⃣ Crear Ticket");
        System.out.println("2️⃣ Listar Tickets");
        System.out.println("3️⃣ Actualizar Ticket");
        System.out.println("4️⃣ Eliminar Ticket");
        System.out.println("0️⃣ Volver al menú principal");
    }

    public void printSubscriptionMenu() {
        out.println("\n========= 📣 GESTIÓN DE SUBSCRIPCIONES Y NOTIFICACIONES =========");
        out.println("1. Suscribirse a Notificaciones");
        out.println("2. Cancelar Suscripción");
        out.println("3. Ver Subscripciones Actuales");
        out.println("0. Volver al menú principal");
    }
    public void printExitMessage() {
        out.println("Gracias por usar Escape Room Virtual. ¡Hasta luego!");
    }

    public void printHeader(String salesMenu) {
        out.println("\n========= " + salesMenu + " =========");
    }

    public void printError(String s) {
        out.println(s);
    }

    public String readInput(String s) {
        out.print(s);
        return inputReader.readLine(s);
    }

    public void printSuccess(String s) {
        out.println("✅ " + s);
    }
}
