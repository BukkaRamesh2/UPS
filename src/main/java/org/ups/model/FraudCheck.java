package org.ups.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class FraudCheck {

    private String ipAddress;
    protected String riskLevel;

    public FraudCheck() {
    }

    public FraudCheck(String ipAddress, String riskLevel) {
        this.ipAddress = ipAddress;
        this.riskLevel = riskLevel;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    @Override
    public String toString() {
        return "FraudCheck[ip=" + ipAddress + ", risk=" + riskLevel + "]";
    }
}