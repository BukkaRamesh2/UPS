package org.ups.controller;

import org.ups.model.Inventory;
import org.ups.service.InventoryService;
import org.ups.service.InventoryServiceImpl;

public class InventoryController {

    public static void main(String[] args) {
        // Polymorphism: Interface reference holding Implementation object
        InventoryService inventoryService = new InventoryServiceImpl();

        System.out.println("---- Starting UPS Inventory System ---");

        // Add Valid Inventory
        Inventory item1 = new Inventory(101, "SUP-A", "Dell Laptop", 2.5);
        item1.setQuantityOnHand(50);
        item1.setCreatedBy("Admin");
        System.out.println(inventoryService.addInventory(item1));

        // Add Invalid Inventory (Negative Weight) - Validating Logic
        Inventory item2 = new Inventory(102, "SUP-B", "Heavy Machinery", -10.0);
        System.out.println(inventoryService.addInventory(item2));

        // Add Invalid Inventory (Duplicate ID) - Validating Logic
        Inventory item3 = new Inventory(101, "SUP-C", "Mouse", 0.5); // ID 101 exists
        System.out.println(inventoryService.addInventory(item3));

        // Print All
        System.out.println("\n--- Current Inventory List ---");
        for(Inventory inv : inventoryService.getAllInventory()) {
            System.out.println("ID: " + inv.getInventoryId() + " | Name: " + inv.getProductName() + " | Created: " + inv.getCreatedDate());
        }
    }
}