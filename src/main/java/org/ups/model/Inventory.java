package org.ups.model;

import java.util.Date;
import java.sql.Timestamp;


public class Inventory extends InventoryCheck {

    private long inventoryId;
    private String supplierId;
    private String productName;
    private double weight;
    private boolean isFragile;
    private int quantityOnHand;
    private Date expirationDate;

    public enum WeightUnit{LBS, KG, OUNCES}
    private WeightUnit weightUnit;

    //Constructor : Default
    public Inventory() {
        super();
    }
    // Constructor B : Parameterized
    public Inventory(long inventoryId, String supplierId, String productName, double weight) {
        this(); // Calls Constructor A to set the date
        this.inventoryId = inventoryId;
        this.productName = productName;
        this.weight = weight;
    }

    public long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean isFragile) {
        this.isFragile = isFragile;
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }

    // added hashcodes

    @Override
    public int hashCode() {
        // Generates a unique hash based on ID
        return java.util.Objects.hash(inventoryId);
    }

    @Override
    public boolean equals(Object obj) {
        // Checks if two objects are legally "equal"
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Inventory other = (Inventory) obj;
        return inventoryId == other.inventoryId;
    }
}


