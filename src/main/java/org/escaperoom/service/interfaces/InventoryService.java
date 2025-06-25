package org.escaperoom.service.interfaces;

public interface InventoryService {
    void listInventory();
    void removeItemById(int id);
    double calculateInventoryValue();
}
