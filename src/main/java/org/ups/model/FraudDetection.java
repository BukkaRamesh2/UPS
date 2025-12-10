package org.ups.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface FraudEntity {
    String createdBy() default "Shashank";

    String purpose() default "Fraud System";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface RiskField {
    String level() default "HIGH";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface FraudCheckMethod {
    String description() default "Check fraud";
}

@FraudEntity(createdBy = "Shashank", purpose = "Check fraud cases")
public class FraudDetection implements Comparable<FraudDetection> {

    private Integer caseId;
    private String username;

    @RiskField(level = "HIGH")
    private double amount;

    @RiskField(level = "MEDIUM")
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

    @FraudCheckMethod(description = "Check with fixed limit")
    public boolean checkFraud() {
        return amount > 5000;
    }

    @FraudCheckMethod(description = "Check with custom limit")
    public boolean checkFraud(double threshold) {
        return amount > threshold;
    }

    @Override
    public int compareTo(FraudDetection other) {
        return Double.compare(other.amount, this.amount);
    }

    @Override
    public String toString() {
        return "[caseId=" + caseId + ", user=" + username + ", amount=" + amount + "]";
    }
}
