package org.escaperoom.controller.command.inventory;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.InventoryServiceFactory;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.entity.DecorationObject;
import org.escaperoom.model.entity.Room;
import org.escaperoom.service.InventoryService;
import org.escaperoom.util.ConsoleTablePrinter;
import org.escaperoom.util.InputReader;
import org.escaperoom.util.InputValidation;

import java.util.List;

public class ShowInventoryCommand implements Command {

    private final InputReader inputReader;
    private final InventoryService inventoryService;

    public ShowInventoryCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        this.inventoryService = InventoryServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            int escapeRoomId = InputValidation.validateIntInput( "🔍 Introduce el ID del Escape Room: ");

            List<Room> rooms = inventoryService.getRoomsByEscapeRoom(escapeRoomId);

            if (rooms == null || rooms.isEmpty()) {
                System.out.println("❌ No se encontraron salas para el Escape Room con ID " + escapeRoomId);
                return;
            }

            System.out.println("\n📦 Inventario del Escape Room con ID " + escapeRoomId + ":");

            for (Room room : rooms) {
                System.out.println("\n📌 Sala: " + room.getName() + " (ID: " + room.getRoomId() + ")");

                List<Clue> clues = inventoryService.getCluesByRoom(room.getRoomId());
                List<DecorationObject> decorations = inventoryService.getDecorationsByRoom(room.getRoomId());

                if (clues.isEmpty() && decorations.isEmpty()) {
                    System.out.println("ℹ️ No hay inventario registrado para esta sala.");
                    continue;
                }

                if (!clues.isEmpty()) {
                    System.out.println("\n🔎 Pistas registradas:");
                    ConsoleTablePrinter.printCluesTable(clues);
                } else {
                    System.out.println("\n🔎 Pistas: Ninguna");
                }

                if (!decorations.isEmpty()) {
                    System.out.println("\n🎨 Objetos decorativos registrados:");
                    ConsoleTablePrinter.printDecorationsTable(decorations);
                } else {
                    System.out.println("\n🎨 Objetos decorativos: Ninguno");
                }
            }

        } catch (Exception e) {
            System.out.println("❌ Error al mostrar el inventario: " + e.getMessage());
        }
    }
}
