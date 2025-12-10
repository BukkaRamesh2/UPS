package org.ups.service;

import org.ups.model.Inventory;
import org.ups.exception.InvalidInventoryException;
import org.ups.exception.InventoryNotFoundException;
import java.util.*;

public class InventoryServiceImpl implements InventoryService {

    private final List<Inventory> inventoryList = new ArrayList<>();
    private final Set<Long> inventoryIdSet = new HashSet<>();
    private final Map<Long, Inventory> inventoryMap = new HashMap<>();

    @Override
    public void addInventory(Inventory inventory) throws InvalidInventoryException {

        if (inventory.getProductName() == null || inventory.getProductName().isEmpty()) {
            throw new InvalidInventoryException("Product Name cannot be empty.");
        }

        if (inventory.getWeight() <= 0) {
            throw new InvalidInventoryException("Weight must be greater than 0. Provided: " + inventory.getWeight());
        }

        if (inventoryIdSet.contains(inventory.getInventoryId())) {
            throw new InvalidInventoryException("Inventory ID " + inventory.getInventoryId() + " already exists.");
        }

        inventoryList.add(inventory);
        inventoryMap.put(inventory.getInventoryId(), inventory);
        inventoryIdSet.add(inventory.getInventoryId());

        System.out.println("Success: Item '" + inventory.getProductName() + "' added.");
    }

    @Override
    public void updateInventory(Inventory inventory) throws InventoryNotFoundException {

        if (!inventoryMap.containsKey(inventory.getInventoryId())) {
            throw new InventoryNotFoundException("Cannot update. Inventory ID " + inventory.getInventoryId() + " not found.");
        }

        Inventory existingItem = inventoryMap.get(inventory.getInventoryId());

        if (inventory.getWeight() > 100) {
            System.out.println("Notice: Updating a heavy freight item.");
        }

        String supplier = inventory.getSupplierId();
        if (supplier != null) {
            switch (supplier) {
                case "SUP-A": System.out.println("Priority Update."); break;
                case "SUP-B": System.out.println("Standard Update."); break;
                default: System.out.println("General Update.");
            }
        }

        inventoryMap.put(inventory.getInventoryId(), inventory);

        for (int i = 0; i < inventoryList.size(); i++) {
            if (inventoryList.get(i).getInventoryId() == inventory.getInventoryId()) {
                inventoryList.set(i, inventory);
                break;
            }
        }
        System.out.println("Inventory Item " + inventory.getInventoryId() + " Updated.");
    }

    @Override
    public void deleteInventory(long inventoryId) throws InventoryNotFoundException {
        if (!inventoryMap.containsKey(inventoryId)) {
            throw new InventoryNotFoundException("Cannot delete. ID " + inventoryId + " does not exist.");
        }

        inventoryMap.remove(inventoryId);
        inventoryIdSet.remove(inventoryId);
        inventoryList.removeIf(i -> i.getInventoryId() == inventoryId);

        System.out.println("Inventory item " + inventoryId + " deleted.");
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