package org.escaperoom.controller.command.inventory;

import org.escaperoom.controller.command.interficie.Command;
import org.escaperoom.service.InventoryService;
import org.escaperoom.util.InputReader;
import org.escaperoom.factory.InventoryServiceFactory;

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
        int escapeRoomId = inputReader.readInt("🔎 Introduce el ID del EscapeRoom: ");

        BigDecimal totalValue = inventoryService.calculateInventoryValueByEscapeRoomId(escapeRoomId);

        System.out.printf("💰 Valor total del inventario del EscapeRoom %d: %.2f €\n",
                escapeRoomId, totalValue);
    }
}

