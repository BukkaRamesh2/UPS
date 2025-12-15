package org.ups.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BillingInfo {

    protected double billingAmount;
    protected double taxAmount;
    protected double totalAmount;

    public BillingInfo() {
    }

    public BillingInfo(double billingAmount, double taxAmount, double totalAmount) {
        this.billingAmount = billingAmount;
        this.taxAmount = taxAmount;
        this.totalAmount = totalAmount;
    }

    public double getBillingAmount() {
        return billingAmount;
    }

    public void setBillingAmount(double billingAmount) {
        this.billingAmount = billingAmount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
