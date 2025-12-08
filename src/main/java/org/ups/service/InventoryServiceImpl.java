package org.ups.service;

import org.ups.model.Inventory;
import java.util.*;

public class InventoryServiceImpl implements InventoryService {

    private List<Inventory> inventoryList = new ArrayList<>();
    private Set<Long> inventoryIdSet = new HashSet<>();
    private Map<Long, Inventory> inventoryMap = new HashMap<>();

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

        // 3. Check for Duplicates using Map
        if (inventoryMap.containsKey(inventory.getInventoryId())) {
            System.out.println("Error: Inventory ID " + inventory.getInventoryId() + " already exists.");
            return;
        }

        // --- ADD TO COLLECTIONS ---
        inventoryList.add(inventory);
        inventoryMap.put(inventory.getInventoryId(), inventory);
        inventoryIdSet.add(inventory.getInventoryId());

        System.out.println("Success: Item '" + inventory.getProductName() + "' added to Inventory.");
    }

    @Override
    public void updateInventory(Inventory inventory) {
        Inventory existingItem = inventoryMap.get(inventory.getInventoryId());

        if (existingItem != null) {

            // 1. NESTED IF: for High Value items
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
            inventoryMap.put(inventory.getInventoryId(), inventory);

            System.out.println("Inventory Item " + inventory.getInventoryId() + " Updated Successfully.");

        } else {
            // Else block for checking if item exists
            System.out.println("Error: Cannot Update. Item ID " + inventory.getInventoryId() + " not found.");
        }
    }

    @Override
    public void deleteInventory(long inventoryId) {
        if (inventoryMap.containsKey(inventoryId)) {
            // Remove from Map
            inventoryMap.remove(inventoryId);
            // Remove from Set
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