package org.ups.model;

import java.util.Date;
import java.sql.Timestamp;


public class Inventory {

    public long inventoryId;  // Public: Accessible anywhere
    private String  supplierId;  // Private: Only accessible inside this class
    protected String productName;  // Protected: Accessible in package + subclasses

    // Default access (no keyword): Accessible only in package
    double weight;
    boolean isFragile;
    int quantityOnHand;
    Timestamp createdDate;
    Date expirationDate;

    enum WeightUnit{LBS, KG, OUNCES}
    WeightUnit weightUnit;

//Constructors

//Constructor A : Default
public Inventory() {
    this.createdDate = new Timestamp(System.currentTimeMillis());
}
// Constructor B : Parameterized
public Inventory(long inventoryId, String supplierId, String productName, double weight) {
    this(); // Calls Constructor A
    this.inventoryId = inventoryId;
    this.supplierId = supplierId;
    this.productName = productName;
    this.weight = weight;
}

// Adding The Main Method:
public static void main(String[] args) {
    // Creating object using Parameterized Constructor
    Inventory upsItem = new Inventory(101, "SUP-001", "Macbook Pro", 3.5);

    //Setting Other Variables
    upsItem.weightUnit = WeightUnit.LBS;
    upsItem.isFragile = true;
    upsItem.quantityOnHand = 20;

    // Printing to console
    System.out.println("--- UPS Inventory System ---");
    System.out.println("ID: " + upsItem.inventoryId);
    System.out.println("Product: " + upsItem.productName);

    // We can access 'supplierId' here because main is INSIDE the Inventory class
    System.out.println("Supplier: " + upsItem.supplierId);

    System.out.println("Weight: " + upsItem.weight + " " + upsItem.weightUnit);
    }
}
