package org.ups.model;

public class FraudDetection {

    // variables
    private int caseId;
    private String username;
    private double amount;
    private String location;
    private boolean isBlocked;
    private String ipAddress;

    // Constructor 
    public FraudDetection(int caseId, String username, double amount, String location, boolean isBlocked, String ipAddress) {
        this.caseId = caseId;
        this.username = username;
        this.amount = amount;
        this.location = location;
        this.isBlocked = isBlocked;
        this.ipAddress = ipAddress;
    }

    // Method for report 
    public void printFraudReport() {
        System.out.println("----------------------------");
        System.out.println("FRAUD DETECTION REPORT");
        System.out.println("-----------------------------");
        System.out.println("Case ID       : " + caseId);
        System.out.println("User Name     : " + username);
        System.out.println("Amount        : " + amount);
        System.out.println("Location      : " + location);
        System.out.println("IP Address    : " + ipAddress);
        System.out.println("Blocked Status: " + isBlocked);
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        FraudDetection fraudObj = new FraudDetection(101, "Shashank_P", 4500.00, "India", true, "192.168.1.55");
        
        fraudObj.printFraudReport();
    }
}