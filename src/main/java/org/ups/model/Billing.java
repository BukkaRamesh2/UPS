package org.ups.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "billing")
public class Billing extends BillingInfo implements Comparable<Billing> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billingId;

    private int shippingId;
    private int userId;

    private String invoiceNumber;
    private String paymentMethod;
    private String billingStatus;
    private String createdDate;
    private String dueDate;

    private boolean status;

    public Billing() {
        System.out.println("Billing default constructor is called");
    }

    public Billing(int billingId, int shippingId, int userId,
                   String invoiceNumber,
                   double billingAmount, double taxAmount, double totalAmount,
                   String paymentMethod, String billingStatus,
                   String createdDate, String dueDate) {

        this.billingId = billingId;
        this.shippingId = shippingId;
        this.userId = userId;
        this.invoiceNumber = invoiceNumber;
        this.paymentMethod = paymentMethod;
        this.billingStatus = billingStatus;
        this.createdDate = createdDate;
        this.dueDate = dueDate;

        this.billingAmount = billingAmount;
        this.taxAmount = taxAmount;
        this.totalAmount = totalAmount;

        this.status = true;
        System.out.println("Billing parameterized constructor is called");
    }

    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public int getShippingId() {
        return shippingId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBillingStatus() {
        return billingStatus;
    }

    public void setBillingStatus(String billingStatus) {
        this.billingStatus = billingStatus;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void printBillSummary() {
        System.out.println("------------- BILL SUMMARY -------------");
        System.out.println("Billing ID   : " + billingId);
        System.out.println("Shipping ID  : " + shippingId);
        System.out.println("User ID      : " + userId);
        System.out.println("Invoice No   : " + invoiceNumber);
        System.out.println("Amount       : " + billingAmount);
        System.out.println("Tax          : " + taxAmount);
        System.out.println("Total        : " + totalAmount);
        System.out.println("Payment Mode : " + paymentMethod);
        System.out.println("Status       : " + billingStatus);
        System.out.println("Created Date : " + createdDate);
        System.out.println("Due Date     : " + dueDate);
        System.out.println("----------------------------------------");
    }

    @Override
    public int compareTo(Billing other) {
        return Integer.compare(this.billingId, other.billingId);
    }

    @Override
    public String toString() {
        return "Billing{" +
                "billingId=" + billingId +
                ", shippingId=" + shippingId +
                ", userId=" + userId +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", billingStatus='" + billingStatus + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", billingAmount=" + billingAmount +
                ", taxAmount=" + taxAmount +
                ", totalAmount=" + totalAmount +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Billing)) return false;
        Billing billing = (Billing) o;
        return billingId == billing.billingId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingId);
    }
}
