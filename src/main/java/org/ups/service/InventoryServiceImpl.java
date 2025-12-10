package org.ups.service;

import org.ups.model.Inventory;
import java.util.*;

public class InventoryServiceImpl implements InventoryService {

    private final List<Inventory> inventoryList = new ArrayList<>();
    private final Set<Long> inventoryIdSet = new HashSet<>();
    private final Map<Long, Inventory> inventoryMap = new HashMap<>();

    @Override
    public void addInventory(Inventory inventory) {

        // 1. Validate Product Name
        if (inventory.getProductName() == null || inventory.getProductName().isEmpty()) {
            System.out.println("Error: Product Name cannot be empty.");
            return;
        }

        // 2. Validate Weight
        if (inventory.getWeight() <= 0) {
            System.out.println("Error: Weight must be greater than 0.");
            return;
        }

        if (inventoryIdSet.contains(inventory.getInventoryId())) {
            System.out.println("Error: Inventory ID " + inventory.getInventoryId() + " already exists.");
            return;
        }

        inventoryList.add(inventory);
        inventoryMap.put(inventory.getInventoryId(), inventory);
        inventoryIdSet.add(inventory.getInventoryId());

        System.out.println("Success: Item '" + inventory.getProductName() + "' added to Inventory.");
    }

    @Override
    public void updateInventory(Inventory inventory) {
        //Check if item exists in Map first
        Inventory existingItem = inventoryMap.get(inventory.getInventoryId());

        if (existingItem != null) {

            // 1. NESTED IF: High Value items
            if (inventory.getWeight() > 100) {
                System.out.println("Notice: Updating a heavy freight item.");
            }

            // 2. SWITCH STATEMENT: Supplier ID
            String supplier = inventory.getSupplierId();

            if (supplier != null) {
                switch (supplier) {
                    case "SUP-A":
                        System.out.println("Update Policy: Priority Supplier (SUP-A). Notify Manager.");
                        break;
                    case "SUP-B":
                        System.out.println("Update Policy: Standard Supplier (SUP-B).");
                        break;
                    case "SUP-C":
                        System.out.println("Update Policy: Local Supplier (SUP-C).");
                        break;
                    default:
                        System.out.println("Update Policy: Unknown Supplier - Check Contract.");
                }
            }

            // 3. Update the Map (fast lookup)
            inventoryMap.put(inventory.getInventoryId(), inventory);

            // 4. Update the List to keep data consistent with the Map
            for (int i = 0; i < inventoryList.size(); i++) {
                if (inventoryList.get(i).getInventoryId() == inventory.getInventoryId()) {
                    inventoryList.set(i, inventory); // Replaces the old object at index i
                    break; // Exit loop once found
                }
            }

            System.out.println("Inventory Item " + inventory.getInventoryId() + " Updated Successfully.");

        } else {
            System.out.println("Error: Cannot Update. Item ID " + inventory.getInventoryId() + " not found.");
        }
    }

    @Override
    public void deleteInventory(long inventoryId) {
        // We can check the Map or Set here; checking Map is standard for deletions
        if (inventoryMap.containsKey(inventoryId)) {

            inventoryMap.remove(inventoryId);
            inventoryIdSet.remove(inventoryId);

            // Remove from List using lambda
            inventoryList.removeIf(i -> i.getInventoryId() == inventoryId);

            System.out.println("Inventory item deleted.");
        } else {
            System.out.println("Error: Item ID " + inventoryId + " not found.");
        }
    }

    @Override
    public Inventory getInventory(long inventoryId) {
        return inventoryMap.get(inventoryId);
    }

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryList;
    }
}