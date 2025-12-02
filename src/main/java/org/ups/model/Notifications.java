package org.ups.model;

public class Notifications {

	public String userId; //Visible from anywhere
	private String trackingNumber; //Visible only inside this class
	protected String message; //Visible within the package and subclasses
	boolean isRead;
	String driverId;
	String estimatedDeliveryDate;
	String currentStatus;
	String packageLocation;
	
// Default Constructor:
public Notifications() {
    this.isRead = false; // default value
	}
// Parameterized Constructor:
public Notifications(String userId, String trackingNumber, String message) {
    this(); // Calls default constructor
    this.userId = userId;
    this.trackingNumber = trackingNumber;
    this.message = message;
	}
//To Get private variable
public String getTrackingNumber() {
    return trackingNumber;
	}
// Main Method:
public static void main(String[] args) {

    // object with parameterized constructor
    Notifications notif = new Notifications(
            "USR-001",
            "TRK-12345",
            "Your package is out for delivery.");

 // default access variables
    notif.driverId = "DRV-111";
    notif.estimatedDeliveryDate = "2025-12-03";
    notif.currentStatus = "Out for Delivery";
    notif.packageLocation = "Birmingham, AL";
    notif.isRead = false;
    

 // Print
    System.out.println("UPS Notifications:");
    System.out.println("User ID: " + notif.userId);

    
    System.out.println("Tracking Number: " + notif.getTrackingNumber()); // get private variable
    System.out.println("Message: " + notif.message); // access protected variable
    System.out.println("Driver ID: " + notif.driverId);
    System.out.println("ETA: " + notif.estimatedDeliveryDate);
    System.out.println("Status: " + notif.currentStatus);
    System.out.println("Location: " + notif.packageLocation);
    System.out.println("Is Read: " + notif.isRead);
	}
}