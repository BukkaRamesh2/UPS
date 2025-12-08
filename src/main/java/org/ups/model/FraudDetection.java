package org.ups.model;

public class FraudDetection implements Comparable<FraudDetection> {

    private Integer caseId;
    private String username;
    private double amount;
    private String location;
    public boolean isBlocked;
    int count;

    public FraudDetection() {
    }

    public FraudDetection(Integer caseId, String username, double amount, String location) {
        this.caseId = caseId;
        this.username = username;
        this.amount = amount;
        this.location = location;
        this.isBlocked = false;
        this.count = 1;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Very simple overloaded methods
    public boolean checkFraud() {
        return amount > 5000;
    }

    public boolean checkFraud(double threshold) {
        return amount > threshold;
    }

    // Comparable: sort by amount DESC
    @Override
    public int compareTo(FraudDetection other) {
        return Double.compare(other.amount, this.amount);
    }

    @Override
    public String toString() {
        return "[caseId=" + caseId + ", user=" + username + ", amount=" + amount + "]";
    }
}
