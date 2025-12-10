package org.ups.controller;

import org.ups.model.Inventory;
import org.ups.service.InventoryService;
import org.ups.service.InventoryServiceImpl;
import org.ups.exception.InvalidInventoryException;
import org.ups.exception.InventoryNotFoundException;
import org.ups.util.InventoryWeightComparator;

import java.util.Collections;
import java.util.List;

public class InventoryController {

    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryServiceImpl();
        System.out.println("---- UPS Inventory System (Exceptions & Sorting) ----");

        // --- 1. ADD INVENTORY (Throws InvalidInventoryException) ---
        try {
            // Valid Adds
            inventoryService.addInventory(new Inventory(102, "SUP-B", "Zebra Printer", 15.0));
            inventoryService.addInventory(new Inventory(101, "SUP-A", "Apple Macbook", 2.5));
            inventoryService.addInventory(new Inventory(103, "SUP-C", "Cardboard Box", 0.5));

            // Invalid Add (Negative Weight) - Uncomment to test
            // inventoryService.addInventory(new Inventory(104, "SUP-D", "Bad Item", -10.0));

        } catch (InvalidInventoryException e) {
            System.err.println("ADD ERROR: " + e.getMessage());
        }

        // --- 2. UPDATE/DELETE INVENTORY (Throws InventoryNotFoundException) ---
        try {
            // Invalid Update (Ghost Item) - Uncomment to test
            // inventoryService.updateInventory(new Inventory(999, "SUP-Z", "Ghost", 10.0));

            // Example of a valid update (will throw exception if ID 102 doesn't exist)
            // inventoryService.updateInventory(new Inventory(102, "SUP-B", "Zebra Printer Updated", 15.0));

        } catch (InventoryNotFoundException e) {
            System.err.println("UPDATE ERROR: " + e.getMessage());
        }

        // --- 3. SORTING DEMO ---
        List<Inventory> currentList = inventoryService.getAllInventory();

        System.out.println("\n--- Before Sorting ---");
        printList(currentList);

        // A. Natural Sorting (Comparable) - Sorts by Name
        Collections.sort(currentList);
        System.out.println("\n--- After Comparable Sort (By Name) ---");
        printList(currentList);

        // B. Custom Sorting (Comparator) - Sorts by Weight
        Collections.sort(currentList, new InventoryWeightComparator());
        System.out.println("\n--- After Comparator Sort (By Weight) ---");
        printList(currentList);
    }

    private static void printList(List<Inventory> list) {
        for (Inventory inv : list) {
            System.out.println(inv);
        }
    }
}