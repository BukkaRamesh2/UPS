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

public String getTrackingNumber() { //To access private variable
    return trackingNumber;
}
public String getMessage() { //To access protected variable
    return message;
}
//OOP concept: Abstraction: method hiding internal details of delivering a notification
public void notifyUser() {
	System.out.println("[Notification] Notifying user " + userId + ": " + message);
}
	
// Method Overloading - same method name, different parameter lists
// 1: send with just a message
public void sendNotification(String msg) {
	System.out.println("sendNotification(msg): " + msg);
}

// 2: send with message and SMS or Email)
public void sendNotification(String msg, String channel) {
    System.out.println("sendNotification(msg, channel): Sending via " + channel + " -> " + msg);
}

// if, else-if, else statements
public void checkNotification() {
// if:
	if (this.isRead) {
	    System.out.println("Notification is already read.");
	}
// if-else:
	if (this.driverId != null) {
	    System.out.println("Driver assigned: " + this.driverId);
	} else {
	    System.out.println("No driver assigned yet.");
	}
// if- else if - else
	if (this.currentStatus != null) {
		if (this.currentStatus.equals("Out for Delivery")) {
			System.out.println("Your package is on the way!");
		} else if (this.currentStatus.equals("Delivered")) {
			System.out.println("Your package has been delivered.");
		} else {
			System.out.println("Status: " + this.currentStatus);
		}
	} else {
		System.out.println("Status unavailable. Please check later.");
	}
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
    System.out.println("Message: " + notif.getMessage());
    System.out.println("Driver ID: " + notif.driverId);
    System.out.println("ETA: " + notif.estimatedDeliveryDate);
    System.out.println("Status: " + notif.currentStatus);
    System.out.println("Location: " + notif.packageLocation);
    System.out.println("Is Read: " + notif.isRead);
 // Method overloading: calling sendNotification(msg)  
    notif.sendNotification("Package arriving soon!");
 // Method overloading: calling sendNotification(msg, channel)
    notif.sendNotification("Package delay update", "Email");
 // Calling the method with if/else logic
    notif.checkNotification(); 
    UrgentNotification urgent = new UrgentNotification( //object creation
            "USR-001",
            "TRK-12345",
            "Your urgent package needs attention!"
    );
    

    urgent.notifyUser();  // Method overriding: calls overridden notifyUser() in UrgentNotification
    
}
}
//OOP concept: Inheritance - subclass inherits from Notifications and overrides
class UrgentNotification extends Notifications {
 public UrgentNotification(String userId, String trackingNumber, String message) {
     super(userId, trackingNumber, message);
 }

 @Override
 public void notifyUser() {
     System.out.println("[URGENT] Notify user " + userId + " IMMEDIATELY: " + message);
 }
} 