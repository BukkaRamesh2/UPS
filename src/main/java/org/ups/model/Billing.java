package org.ups.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Billing extends BillingInfo {

	@Id
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

        status = true;
        System.out.println("Billing parameterized constructor is called");
    }

    void testBilling() {
        billingAmount = 500.0;
        taxAmount = 50.0;
        totalAmount = 550.0;
        status = true;
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
}
