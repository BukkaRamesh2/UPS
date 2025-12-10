package org.ups.model;

import java.sql.Timestamp;

public class InventoryCheck {

    private Timestamp createdDate;
    private String createdBy;

    public InventoryCheck() {
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }

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