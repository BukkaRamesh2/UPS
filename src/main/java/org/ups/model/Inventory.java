package org.ups.model;

import java.util.Date;
import java.util.Objects;

public class Inventory extends InventoryCheck implements Comparable<Inventory> {

    private long inventoryId;
    private String supplierId;
    private String productName;
    private double weight;
    private boolean isFragile;
    private int quantityOnHand;
    private Date expirationDate;

    public enum WeightUnit {LBS, KG, OUNCES}
    private WeightUnit weightUnit;

    public Inventory() {
        super();
    }

    public Inventory(long inventoryId, String supplierId, String productName, double weight) {
        this();
        this.inventoryId = inventoryId;
        this.supplierId = supplierId;
        this.productName = productName;
        this.weight = weight;
    }

    // --- Getters and Setters ---
    public long getInventoryId() { return inventoryId; }
    public void setInventoryId(long inventoryId) { this.inventoryId = inventoryId; }

    public String getSupplierId() { return supplierId; }
    public void setSupplierId(String supplierId) { this.supplierId = supplierId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public boolean isFragile() { return isFragile; }
    public void setFragile(boolean isFragile) { this.isFragile = isFragile; }

    public int getQuantityOnHand() { return quantityOnHand; }
    public void setQuantityOnHand(int quantityOnHand) { this.quantityOnHand = quantityOnHand; }

    public Date getExpirationDate() { return expirationDate; }
    public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }

    public WeightUnit getWeightUnit() { return weightUnit; }
    public void setWeightUnit(WeightUnit weightUnit) { this.weightUnit = weightUnit; }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Inventory other = (Inventory) obj;
        return inventoryId == other.inventoryId;
    }

    @Override
    public String toString() {
        return "ID: " + inventoryId + " | Name: " + productName + " | Weight: " + weight;
    }

    // --- SORTING LOGIC ---
    @Override
    public int compareTo(Inventory other) {
        if (this.productName == null || other.productName == null) {
            return 0;
        }
        return this.productName.compareTo(other.productName);
    }
}