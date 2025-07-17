package org.escaperoom.controller.command.inventory;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.factory.InventoryServiceFactory;
import org.escaperoom.service.InventoryService;
import org.escaperoom.util.InputReader;

import java.math.BigDecimal;

public class InventoryValueCommand implements Command {

    private final InputReader inputReader;
    private final InventoryService inventoryService;

    public InventoryValueCommand(InputReader inputReader) {
        this.inputReader = inputReader;
        this.inventoryService = InventoryServiceFactory.create();
    }

    @Override
    public void execute() {
        try {
            int escapeRoomId = inputReader.readInt("🔎 Introduce el ID del EscapeRoom: ");
            if (escapeRoomId <= 0) {
                System.out.println("❌ El ID debe ser un número entero positivo.");
                return;
            }

            BigDecimal totalValue = inventoryService.calculateInventoryValueByEscapeRoomId(escapeRoomId);

            if (totalValue == null) {
                System.out.println("❌ No se pudo calcular el valor del inventario. Verifica si el EscapeRoom existe.");
                return;
            }

            System.out.printf("💰 Valor total del inventario del EscapeRoom %d: %.2f €\n",
                    escapeRoomId, totalValue);

        } catch (Exception e) {
            System.out.println("❌ Error al calcular el valor del inventario: " + e.getMessage());
        }
    }
}
