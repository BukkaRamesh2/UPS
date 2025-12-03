package org.ups.model;

public class CustomerSupport {

    private int customerId;
    private String customerName;
    private String emailId;
    private long phoneNumber;
    private  int trackingId;
    private String deliveryDate;
    private boolean shippingStatus;


    public CustomerSupport(int customerId, String customerName, String emailId,
                           long phoneNumber, int trackingId, String deliveryDate,
                           boolean shippingStatus) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.trackingId = trackingId;
        this.deliveryDate = deliveryDate;
        this.shippingStatus = shippingStatus;
    }


    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmailId() {
        return emailId;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public int getTrackingId() {
        return trackingId;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public boolean getShippingStatus() {
        return shippingStatus;
    }

  

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setShippingStatus(boolean shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public void displayDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + customerName);
        System.out.println("Email: " + emailId);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Tracking ID: " + trackingId);
        System.out.println("Delivery Date: " + deliveryDate);
        System.out.println("Shipping Status: " + (shippingStatus ? "Delivered" : "In Transit"));
    }



    public static void main(String[] args) {

        CustomerSupport cs = new CustomerSupport(
                101, "Veronica", "veronica@gmail.com",
                9876543210L, 555123, "2025-11-30", false
        );

        cs.displayDetails();
    }
}
