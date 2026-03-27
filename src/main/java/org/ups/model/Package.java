package org.ups.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "packages")
public class Package {

    @Id
    @Column(name = "tracking_id")
    private Long trackingId;

    @Column(name = "order_id")
    private String orderId;

    private double weight;
    private String dimensions;
    private String location;

    // Default constructor (JPA needs it)
    public Package() {
        this.trackingId = 0L;
        this.orderId = "DEFAULT";
        this.weight = 0.0;
        this.dimensions = "DEFAULT";
        this.location = "DEFAULT";
    }

    // Parameterized constructor
    public Package(Long trackingId, String orderId, double weight, String dimensions, String location) {
        this.trackingId = trackingId;
        this.orderId = orderId;
        this.weight = weight;
        this.dimensions = dimensions;
        this.location = location;
    }

    // Getters & Setters
    public Long getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(Long trackingId) {
        this.trackingId = trackingId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Package{" +
                "trackingId=" + trackingId +
                ", orderId='" + orderId + '\'' +
                ", weight=" + weight +
                ", dimensions='" + dimensions + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
