package org.ups.service;

import org.ups.model.Inventory;
import java.util.ArrayList;
import java.util.List;

public class InventoryServiceImpl implements InventoryService {

    // Using a List to act as a database
    private List<Inventory> inventoryList = new ArrayList<>();

    @Override
    public String addInventory(Inventory inventory) {
        // --- VALIDATION LOGIC (Requested by Ramesh) ---

        // 1. Validate Product Name
        if (inventory.getProductName() == null || inventory.getProductName().isEmpty()) {
            return "Error: Product Name cannot be empty.";
        }

        // 2. Validate Weight (Cannot be negative)
        if (inventory.getWeight() <= 0) {
            return "Error: Weight must be greater than 0.";
        }

        // 3. Check for Duplicates (Iterate through list)
        for (Inventory item : inventoryList) {
            if (item.getInventoryId() == inventory.getInventoryId()) {
                return "Error: Inventory ID " + inventory.getInventoryId() + " already exists.";
            }
        }

        // If all validations pass, add to the list
        inventoryList.add(inventory);
        return "Success: Item '" + inventory.getProductName() + "' added to Inventory.";
    }

    @Override
    public String updateInventory(Inventory inventory) {
        for (Inventory item : inventoryList) {
            if (item.getInventoryId() == inventory.getInventoryId()) {
                item.setProductName(inventory.getProductName());
                item.setWeight(inventory.getWeight());
                item.setQuantityOnHand(inventory.getQuantityOnHand());
                return "Inventory updated successfully.";
            }
        }
        return "Error: Item not found.";
    }

    @Override
    public String deleteInventory(long inventoryId) {
        // Using removeIf (Collection feature)
        boolean removed = inventoryList.removeIf(i -> i.getInventoryId() == inventoryId);

        if (removed) {
            return "Inventory item deleted.";
        } else {
            return "Error: Item ID " + inventoryId + " not found.";
        }
    }

    @Override
    public Inventory getInventory(long inventoryId) {
        for (Inventory item : inventoryList) {
            if (item.getInventoryId() == inventoryId) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryList;
    }
}