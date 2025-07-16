package org.escaperoom.controller.command.inventory;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.util.InputReader;
import org.escaperoom.model.entity.Clue;
import org.escaperoom.model.entity.DecorationObject;
import org.escaperoom.model.entity.Room;
import org.escaperoom.service.InventoryService;
import org.escaperoom.factory.InventoryServiceFactory;

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
            int escapeRoomId = inputReader.readInt("🔍 Introduce el ID del Escape Room: ");
            List<Room> rooms = inventoryService.getRoomsByEscapeRoom(escapeRoomId);
            if (rooms == null || rooms.isEmpty()) {
                System.out.println("❌ No se encontraron salas para el Escape Room con ID " + escapeRoomId);
                return;
            }
            System.out.println("========================================");
            System.out.println("📦 Inventario del Escape Room con ID " + escapeRoomId + ":");
            System.out.println("========================================");


            for (Room room : rooms) {
                System.out.println("\n📌 Sala: " + room.getName() + " (ID: " + room.getRoomId() + ")");

                List<Clue> clues = inventoryService.getCluesByRoom(room.getRoomId());
                System.out.println("----------------------------------------");
                if (!clues.isEmpty()) {
                    System.out.println("🔎 Pistas:");
                    for (Clue clue : clues) {
                        System.out.println("- " + clue.getTheme() + ", Cantidad: " + clue.getQuantityAvailable() + ", Precio: €" + clue.getPrice());
                    }
                } else {
                    System.out.println("🔎 Pistas: Ninguna");
                }

                System.out.println("----------------------------------------");
                List<DecorationObject> decorations = inventoryService.getDecorationsByRoom(room.getRoomId());
                if (!decorations.isEmpty()) {
                    System.out.println("🎨 Objetos decorativos:");
                    for (DecorationObject obj : decorations) {
                        System.out.println("- " + obj.getName() + " (" + obj.getMaterialType() + "), Cantidad: " + obj.getQuantityAvailable() + ", Precio: €" + obj.getPrice());
                    }

                    System.out.println("----------------------------------------");
                } else {
                    System.out.println("🎨 Objetos decorativos: Ninguno");
                }
            }

        } catch (Exception e) {
            System.out.println("❌ Error al mostrar el inventario: " + e.getMessage());
        }
    }
}
