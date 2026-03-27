package org.ups.service;

import org.ups.model.Package;
import java.util.List;

public interface PackageService {
    Package addPackage(Package pkg);
    Package updatePackage(Long trackingId, Package pkg);
    void deletePackage(Long trackingId);
    Package getPackage(Long trackingId);
    List<Package> getAllPackages();
}
