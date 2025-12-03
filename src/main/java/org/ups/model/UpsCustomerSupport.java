package org.ups.model;

public class UpsCustomerSupport {

    private int customerId;
    private String customerName;
    private String emailId;
    private long phoneNumber;     
    private int trackingId;
    private String deliveryDate;   
    private boolean shippingStatus;

    // Default constructor
    public UpsCustomerSupport() {
        System.out.println("Default constructor called");
    }

    // Constructor with customerName
    public UpsCustomerSupport(String customerName) {
        this.customerName = customerName;
        System.out.println("CustomerName constructor called");
    }

    // Constructor with all fields
    public UpsCustomerSupport(int customerId, String customerName, String emailId,
                              long phoneNumber, int trackingId, String deliveryDate, boolean shippingStatus) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.trackingId = trackingId;
        this.deliveryDate = deliveryDate;
        this.shippingStatus = shippingStatus;
        System.out.println("All-args constructor called");
    }

    // Getters and Setters
    public int getCustomerId() {
    	return customerId; 
    	}
    public void setCustomerId(int customerId) { 
    	this.customerId = customerId;
    	}

    public String getCustomerName() { 
    	return customerName; 
    	}
    public void setCustomerName(String customerName) { 
    	this.customerName = customerName; 
    	}

    public String getEmailId() {
    	return emailId;
    	}
    public void setEmailId(String emailId) { 
    	this.emailId = emailId; 
    	}

    public long getPhoneNumber() { 
    	return phoneNumber; 
    	}
    public void setPhoneNumber(long phoneNumber) { 
    	this.phoneNumber = phoneNumber;
    	}

    public int getTrackingId() {
    	return trackingId; 
    	}
    public void setTrackingId(int trackingId) {
    	this.trackingId = trackingId; 
    	}

    public String getDeliveryDate() { 
    	return deliveryDate; 
    	}
    public void setDeliveryDate(String deliveryDate) {
    	this.deliveryDate = deliveryDate;
    	}

    public boolean isShippingStatus() {
    	return shippingStatus;
    	}
    public void setShippingStatus(boolean shippingStatus) { 
    	this.shippingStatus = shippingStatus;
    	}

    // Main method to test the class
    public static void main(String[] args) {
        // Using default constructor
        UpsCustomerSupport customer1 = new UpsCustomerSupport();
        customer1.setCustomerName("Alana");
        customer1.setCustomerId(1071);
        customer1.setEmailId("alana@ups.com");
        customer1.setPhoneNumber(1234567890L);
        customer1.setTrackingId(5801);
        customer1.setDeliveryDate("2025-12-05");
        customer1.setShippingStatus(true);

        System.out.println("Customer 1 Name: " + customer1.getCustomerName());
        System.out.println("Shipping Status: " + customer1.isShippingStatus());

        // Using constructor with customerName
        UpsCustomerSupport customer2 = new UpsCustomerSupport("Raj");
        System.out.println("Customer 2 Name: " + customer2.getCustomerName());

        // Using all-args constructor
        UpsCustomerSupport customer3 = new UpsCustomerSupport(
            102, "Charan", "charan@ups.com", 9876543210L, 5002, "2025-12-10", false);
        System.out.println("Customer 3 Name: " + customer3.getCustomerName());
        System.out.println("Shipping Status: " + customer3.isShippingStatus());
    }
}
