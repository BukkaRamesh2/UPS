package org.ups.service;

import org.ups.model.Inventory;
import java.util.List;

public interface InventoryService {
    // Abstract methods to manage Inventory
    String addInventory(Inventory inventory);
    String updateInventory(Inventory inventory);
    String deleteInventory(long inventoryId);
    Inventory getInventory(long inventoryId);
    List<Inventory> getAllInventory();
}

