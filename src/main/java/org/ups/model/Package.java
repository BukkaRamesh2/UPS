package org.ups.model;

public class Package {

    private long trackingId;
    private String orderId;
    private double weight;
    private String dimensions;
    private String location;

    // Default constructor
    public Package() {
        this.trackingId = 0;
        this.orderId = "Unknown";
        this.weight = 0.0;
        this.dimensions = "Unknown";
        this.location = "Unknown";
    }

    // Parameter constructor
    public Package(long trackingId, String orderId, double weight, String dimensions, String location) {
        this.trackingId = trackingId;
        this.orderId = orderId;
        this.weight = weight;
        this.dimensions = dimensions;
        this.location = location;
    }

    // Getters & Setters
    public long getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(long trackingId) {
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
}
