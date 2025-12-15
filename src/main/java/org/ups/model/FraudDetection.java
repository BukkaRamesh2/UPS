package org.ups.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FraudEntity(createdBy = "Shashank", purpose = "Check fraud cases")
public class FraudDetection implements Comparable<FraudDetection> {

    @Id
    private Integer caseId;
    
    private String username;

    @RiskField(level = "HIGH")
    private Double amount;

    @RiskField(level = "MEDIUM")
    private String location;

    public boolean isBlocked;
    
    int count;

    public FraudDetection(Integer caseId, String username, Double amount, String location) {
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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
        return "FraudDetection [caseId=" + caseId + ", username=" + username + ", amount=" + amount + ", location=" + location + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseId, username, amount, location);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        FraudDetection other = (FraudDetection) obj;
        return Objects.equals(caseId, other.caseId);
    }
}