package org.ups.controller;

import java.util.List;
import org.ups.model.FraudDetection;
import org.ups.service.FraudService;
import org.ups.service.FraudServiceImpl;

public class FraudController {

    private final FraudService fraudService;

    public FraudController() {
        this.fraudService = new FraudServiceImpl();
    }

    public FraudDetection create(FraudDetection f) {
        return fraudService.save(f);
    }

    public List<FraudDetection> list() {
        return fraudService.findAll();
    }
    public static void main(String[] args) {
        FraudController ctrl = new FraudController();

        FraudDetection a = new FraudDetection(101, "shashank", 12000.0, "USA", false, "127.0.0.1", "HIGH");
        FraudDetection b = new FraudDetection(102, "Rama", 50.0, "India", false, "10.0.0.2", "LOW");

        ctrl.create(a);
        ctrl.create(b);

        System.out.println("All frauds:");
        for (FraudDetection f : ctrl.list()) {
            System.out.println(f);
        }
        System.out.println("Check a simple rule: a.checkFraud() -> " + a.checkFraud());
        System.out.println("Using threshold: b.checkFraud(100.0) -> " + b.checkFraud(100.0));

        System.out.println("Polymorphism example:");
        // base type reference to child object
        org.ups.model.FraudCheck baseRef = new FraudDetection(201, "poly", 1.0, "X", false, "1.2.3.4", "MED");
        System.out.println(baseRef.toString()); // overridden toString will run
    }
}
