package org.ups.model;

public class FraudDetection extends FraudCheck {
    private Integer caseId;       
    private String username;
    private double amount;
    private String location;
    public boolean isBlocked;     
    
    // Default constructor
    public FraudDetection() {
        super();
        this.caseId = null;
        this.username = "unknown";
        this.amount = 0.0;
        this.location = "none";
        this.isBlocked = false;
        //this.count = 0;
    }

    // Parameterized constructor
    public FraudDetection(Integer caseId, String username, double amount, String location,
                          boolean isBlocked, String ipAddress, String riskLevel) {
        super(ipAddress, riskLevel); // initialize parent fields
        this.caseId = caseId;
        this.username = username;
        this.amount = amount;
        this.location = location;
        this.isBlocked = isBlocked;
        //this.count = 0;
    }

    // Overloaded constructor 
    public FraudDetection(Integer caseId, String username) {
        this(caseId, username, 0.0, "none", false, null, null);
    }

    // getters / setters 
    public Integer getCaseId() { return caseId; }
    public void setCaseId(Integer caseId) { this.caseId = caseId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    // Method overloading: two versions of check()
    public boolean checkFraud() {
        // simple rule
        return this.amount > 5000.0;
    }

    public boolean checkFraud(double threshold) {
        return this.amount > threshold;
    }
    @Override
    public String toString() {
        return "FraudDetection{caseId=" + caseId + ", username=" + username + ", amount=" + amount + ", location=" + location + ", blocked=" + isBlocked + "}";
    }
}
