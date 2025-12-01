package org.ups.model;

// 1. ADD "extends FraudCheck" HERE
public class FraudDetection extends FraudCheck {

    private int caseId;
    private String username;
    private double amount;
    private String location;
    private boolean isBlocked;

    public FraudDetection(int caseId, String username, double amount, String location, boolean isBlocked, String ipAddress) {
        this.caseId = caseId;
        this.username = username;
        this.amount = amount;
        this.location = location;
        this.isBlocked = isBlocked;
        
        // 2. Initialize Parent Variable
        this.ipAddress = ipAddress; 
    }

    public void printFraudReport() {
        System.out.println("User: " + username);
        System.out.println("IP (From Parent): " + ipAddress);
    }
}