package org.ups.model;

public class Billing {

    private int billingId;
    private int shippingId;
    private int userId;

    private String invoiceNumber;

    private double billingAmount;
    private double taxAmount;
    private double totalAmount;

    private String paymentMethod;
    private String billingStatus;

    private String createdDate;
    private String dueDate;

    // default constructor
    public Billing() {
        System.out.println("Billing: default constructor");
    }

    // parameterized constructor
    public Billing(int billingId, int shippingId, int userId,
                   String invoiceNumber,
                   double billingAmount, double taxAmount, double totalAmount,
                   String paymentMethod, String billingStatus,
                   String createdDate, String dueDate) {

        this.billingId = billingId;
        this.shippingId = shippingId;
        this.userId = userId;
        this.invoiceNumber = invoiceNumber;
        this.billingAmount = billingAmount;
        this.taxAmount = taxAmount;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.billingStatus = billingStatus;
        this.createdDate = createdDate;
        this.dueDate = dueDate;

        System.out.println("Billing: parameterized constructor");
    }

    public static void main(String[] args) {

        // calls default constructor
        Billing b1 = new Billing();

        // calls parameterized constructor (you can change these values)
        Billing b2 = new Billing(
                101,    // billingId
                201,    // shippingId
                301,    // userId
                "BILL-1",
                500.0,  // billingAmount
                50.0,   // taxAmount
                550.0,  // totalAmount
                "CARD",
                "PENDING",
                "2025-11-27",
                "2025-12-05"
        );
    }
}
