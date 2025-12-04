package org.ups.service;

import org.ups.model.Package;
import java.util.ArrayList;
import java.util.List;

public class PackageServiceImpl implements PackageService {

    private List<Package> packageList = new ArrayList<>();

    @Override
    public String addPackage(Package pkg) {
        packageList.add(pkg);
        return "Package Added Successfully!";
    }

    @Override
    public String updatePackage(Package pkg) {

        for (Package p : packageList) {
            if (String.valueOf(p.getTrackingId())
                    .equals(String.valueOf(pkg.getTrackingId()))) {

                p.setOrderId(pkg.getOrderId());
                p.setWeight(pkg.getWeight());
                p.setDimensions(pkg.getDimensions());
                p.setLocation(pkg.getLocation());

                return "Package Updated!";
            }
        }
        return "Package Not Found!";
    }

    @Override
    public String deletePackage(String trackingId) {

        boolean removed = packageList.removeIf(
            p -> String.valueOf(p.getTrackingId()).equals(trackingId)
        );

        return removed ? "Package Deleted!" : "Package Not Found!";
    }

    @Override
    public Package getPackage(String trackingId) {

        for (Package p : packageList) {
            if (String.valueOf(p.getTrackingId()).equals(trackingId)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Package> getAllPackages() {
        return packageList;
    }
}
