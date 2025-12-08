package org.ups.controller;

import org.ups.model.Inventory;
import org.ups.service.InventoryService;
import org.ups.service.InventoryServiceImpl;

public class InventoryController {

    public static void main(String[] args) {
        // Create Service Instance
        InventoryService inventoryService = new InventoryServiceImpl();

        System.out.println("---- Starting UPS Inventory System (Collections Edition) ---");

        // 1. ADD VALID INVENTORY
        Inventory item1 = new Inventory(101, "SUP-A", "Dell Laptop", 2.5);
        item1.setQuantityOnHand(50);
        inventoryService.addInventory(item1);

        Inventory item2 = new Inventory(102, "SUP-B", "Office Chair", 15.0);
        inventoryService.addInventory(item2);

        // 2. ADD INVALID INVENTORY (Testing Validations)
        System.out.println("\n--- Testing Validations ---");
        Inventory item3 = new Inventory(103, "SUP-C", "Bad Item", -5.0); // Negative Weight
        inventoryService.addInventory(item3);

        Inventory item4 = new Inventory(101, "SUP-A", "Duplicate Laptop", 2.5); // Duplicate ID
        inventoryService.addInventory(item4);

        // 3. UPDATE INVENTORY (Testing Switch & If/Else Logic)
        System.out.println("\n--- Testing Update Logic ---");

        // Update item 101 (Supplier A - Should trigger Priority message)
        Inventory updateItem1 = new Inventory(101, "SUP-A", "Dell XPS Laptop", 2.5);
        inventoryService.updateInventory(updateItem1);

        // Update item 102 (Supplier B - Should trigger Standard message)
        Inventory updateItem2 = new Inventory(102, "SUP-B", "Ergonomic Chair", 15.0);
        inventoryService.updateInventory(updateItem2);

        // Update Non-Existent Item (Should trigger Error)
        Inventory fakeItem = new Inventory(999, "SUP-Z", "Ghost Item", 10.0);
        inventoryService.updateInventory(fakeItem);

        // 4. PRINT FINAL LIST
        System.out.println("\n--- Final Database Status ---");
        for(Inventory inv : inventoryService.getAllInventory()) {
            System.out.println("ID: " + inv.getInventoryId() + " | Name: " + inv.getProductName());
        }
    }
}