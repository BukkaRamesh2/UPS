package org.ups.service;

import org.ups.model.Inventory;
import org.ups.exception.InvalidInventoryException;
import org.ups.exception.InventoryNotFoundException;
import java.util.List;

public interface InventoryService {

    void addInventory(Inventory inventory) throws InvalidInventoryException;

    void updateInventory(Inventory inventory) throws InventoryNotFoundException;

    void deleteInventory(long inventoryId) throws InventoryNotFoundException;

    Inventory getInventory(long inventoryId);

    List<Inventory> getAllInventory();
}