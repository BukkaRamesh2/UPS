package org.ups.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ups.model.FraudDetection;
import org.ups.service.FraudServiceImpl;

@RestController
@RequestMapping("Fraud")
public class FraudController extends FraudDetection {

    @Autowired
    FraudServiceImpl fraudServiceImpl;

    @PostMapping("/createFraud")
    public void addFraud(@RequestBody FraudDetection fraud) {
        fraudServiceImpl.addFraud(fraud);
    }

    @PutMapping("/updateFraud")
    public void updateFraud(@RequestBody FraudDetection fraud) {
        try {
            fraudServiceImpl.updateFraud(fraud);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/getFraud/{caseId}")
    public FraudDetection getFraud(@PathVariable Integer caseId) {
        return fraudServiceImpl.getFraud(caseId);
    }

    @GetMapping("/getAllFrauds")
    public List<FraudDetection> getAllFrauds() {
        return fraudServiceImpl.getAllFrauds();
    }

    @DeleteMapping("/deleteFraud/{caseId}")
    public void deleteFraud(@PathVariable Integer caseId) {
        fraudServiceImpl.deleteFraud(caseId);
    }
}