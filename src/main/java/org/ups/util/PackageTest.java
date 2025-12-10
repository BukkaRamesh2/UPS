package org.ups.util;

import org.ups.model.Package;
import org.ups.service.PackageServiceImpl;
import org.ups.util.SenderComparator;

import java.util.Collections;
import java.util.List;

public class PackageTest {

    public static void main(String[] args) {

        PackageServiceImpl service = new PackageServiceImpl();

        Package p1 = new Package(1, "ORD001", 10.0, "10x10x10", "Dallas");
        Package p2 = new Package(2, "ORD002", 5.0, "12x8x6", "Houston");
        Package p3 = new Package(3, "ORD003", 8.0, "15x10x7", "Austin");


        service.addPackage(p1);
        service.addPackage(p2);
        service.addPackage(p3);

        // 1. LIST ALL
        System.out.println("All Packages:");
        service.getAllPackages().forEach(p -> System.out.println(p.getOrderId()));

        // 2. SORT BY WEIGHT (Comparable)
        System.out.println("\nSort by weight:");
      

        // 3. SORT BY SENDER NAME (Comparator)
        System.out.println("\nSort by sender:");
        List<Package> list = service.getAllPackages();
        Collections.sort(list, new SenderComparator());
        list.forEach(p -> System.out.println(p.getOrderId()));

        // 4. Custom Exception Test
        try {
            service.deletePackage("1000"); // doesn't exist
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
