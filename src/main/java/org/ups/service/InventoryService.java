package org.ups.service;

import org.ups.model.Inventory;
import java.util.List;

public interface InventoryService {

    void addInventory(Inventory inventory);

    void updateInventory(Inventory inventory);

    void deleteInventory(long inventoryId);

    Inventory getInventory(long inventoryId);

    List<Inventory> getAllInventory();
}