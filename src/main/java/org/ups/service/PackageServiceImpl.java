package org.ups.service;

import org.ups.exception.PackageNotFoundException;
import org.ups.model.Package;
import org.ups.repository.PackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageServiceImpl implements PackageService {

    private final PackageRepository packageRepository;

    public PackageServiceImpl(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    @Override
    public Package addPackage(Package pkg) {
        // decision making statement (validation)
        if (pkg.getTrackingId() == null || pkg.getTrackingId() <= 0) {
            throw new IllegalArgumentException("TrackingId must be > 0");
        }
        return packageRepository.save(pkg);
    }

    @Override
    public Package updatePackage(Long trackingId, Package pkg) {
        Package existing = packageRepository.findById(trackingId)
                .orElseThrow(() -> new PackageNotFoundException("Package not found with trackingId: " + trackingId));

        // update fields
        existing.setOrderId(pkg.getOrderId());
        existing.setWeight(pkg.getWeight());
        existing.setDimensions(pkg.getDimensions());
        existing.setLocation(pkg.getLocation());

        return packageRepository.save(existing);
    }

    @Override
    public void deletePackage(Long trackingId) {
        if (!packageRepository.existsById(trackingId)) {
            throw new PackageNotFoundException("Package not found with trackingId: " + trackingId);
        }
        packageRepository.deleteById(trackingId);
    }

    @Override
    public Package getPackage(Long trackingId) {
        return packageRepository.findById(trackingId)
                .orElseThrow(() -> new PackageNotFoundException("Package not found with trackingId: " + trackingId));
    }

    @Override
    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }
}
