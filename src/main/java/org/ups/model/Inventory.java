package org.ups.model;

import java.util.Date;
import java.sql.Timestamp;


public class Inventory {

    long inventoryId;
    String  supplierId;
    String productName;
    double Weight;
    Enum weightUnit;
    boolean isFragile;
    int quantityOnHand;
    Timestamp createdDate;
    Date expirationDate;


}
