package org.ups.controller;

import java.util.Collections;
import java.util.List;

import org.ups.model.FraudDetection;
import org.ups.service.FraudService;
import org.ups.service.FraudServiceImpl;

public class FraudController {

    public static void main(String[] args) {

        FraudServiceImpl service = new FraudServiceImpl();

        FraudDetection a = new FraudDetection(null, "Shashank", 12000.0, "USA");
        FraudDetection b = new FraudDetection(null, "Alice", 500.0, "India");
        FraudDetection c = new FraudDetection(null, "Bob", 7000.0, "UK");

        service.save(a);
        service.save(b);
        service.save(c);

        List<FraudDetection> all = service.findAll();
        System.out.println("All Records:");
        for (FraudDetection f : all)
            System.out.println(f);

        Collections.sort(all);
        System.out.println("\nSorted by amount (descending):");
        for (FraudDetection f : all)
            System.out.println(f);

        int highCount = service.countCasesAbove(5000);
        System.out.println("\nCases above 5000: " + highCount);
    }
}
