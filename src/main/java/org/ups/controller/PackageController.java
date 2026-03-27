package org.ups.controller;

import org.ups.model.Package;
import org.ups.service.PackageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
public class PackageController {

    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    // TEST ENDPOINT (IMPORTANT)
    @GetMapping("/test")
    public String test() {
        return "Package Controller Working";
    }

    @PostMapping
    public Package addPackage(@RequestBody Package pkg) {
        return packageService.addPackage(pkg);
    }

    @GetMapping
    public List<Package> getAllPackages() {
        return packageService.getAllPackages();
    }

    @GetMapping("/{trackingId}")
    public Package getPackage(@PathVariable Long trackingId) {
        return packageService.getPackage(trackingId);
    }

    @PutMapping("/{trackingId}")
    public Package updatePackage(@PathVariable Long trackingId,
                                 @RequestBody Package pkg) {
        return packageService.updatePackage(trackingId, pkg);
    }

    @DeleteMapping("/{trackingId}")
    public String deletePackage(@PathVariable Long trackingId) {
        packageService.deletePackage(trackingId);
        return "Package deleted: " + trackingId;
        //assignment final verification
    }
}
