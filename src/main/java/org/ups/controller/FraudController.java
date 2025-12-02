package org.ups.controller;

import org.ups.model.FraudDetection;

public class FraudController {

    public static void main(String[] args) {
        FraudDetection fraud = new FraudDetection(101, "Shashank_P", 5000.00, "New York", true, "192.168.1.1");

        fraud.printFraudReport();
    }
}