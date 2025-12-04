package org.ups.service;

import org.ups.model.Package;
import java.util.List;

public interface PackageService {
    String addPackage(Package pkg);
    String updatePackage(Package pkg);
    String deletePackage(String trackingId);
    Package getPackage(String trackingId);
    List<Package> getAllPackages();
}
