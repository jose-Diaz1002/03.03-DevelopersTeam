package org.escaperoom.service.impl;

import org.escaperoom.service.interfaces.InventoryService;

public class InventoryServiceImpl implements InventoryService {
    @Override
    public void listInventory() {
        // Mostrar salas, pistas y decoraciones
    }

    @Override
    public void removeItemById(int id) {
        // Eliminar por tipo e ID
    }

    @Override
    public double calculateInventoryValue() {
        return 0; // Sumar precios de todos los elementos
    }
}
