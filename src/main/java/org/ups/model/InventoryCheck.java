package org.ups.model;

import java.sql.Timestamp;

// This is the PARENT class
public class InventoryCheck {

    // Common fields for everyone
    private Timestamp createdDate;
    private String createdBy;

    public InventoryCheck() {
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }

    // Getters and Setters
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}