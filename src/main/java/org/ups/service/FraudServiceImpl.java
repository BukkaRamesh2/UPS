package org.ups.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ups.model.FraudDetection;
import org.ups.repository.FraudRepository;

@Service
public class FraudServiceImpl implements FraudService {

    @Autowired
    FraudRepository fraudRepository;

    List<FraudDetection> fraudList = new ArrayList<>();
    List<String> auditLog = new LinkedList<>();

    Set<String> locationSet = new HashSet<>();
    Set<String> orderedLocationSet = new LinkedHashSet<>();
    Set<String> sortedNames = new TreeSet<>();

    Map<Integer, FraudDetection> fraudMap = new HashMap<>();
    Map<Integer, FraudDetection> sortedMap = new TreeMap<>();
    Map<Integer, FraudDetection> orderedFraudMap = new LinkedHashMap<>();

    @Override
    public void addFraud(FraudDetection fraud) {
        System.out.println("--- ADD FRAUD ---");
        
        try {
            if (fraud.getCaseId() == null || fraud.getCaseId() <= 0) {
                fraud.setCaseId(fraudList.size() + 100); 
                System.out.println("Generated ID: " + fraud.getCaseId());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        fraudList.add(fraud);
        auditLog.add("Fraud Added: " + fraud.getUsername());
        
        if (fraud.getLocation() != null) {
            locationSet.add(fraud.getLocation());
            orderedLocationSet.add(fraud.getLocation());
        }
        if (fraud.getUsername() != null) {
            sortedNames.add(fraud.getUsername());
        }

        fraudMap.put(fraud.getCaseId(), fraud);
        sortedMap.put(fraud.getCaseId(), fraud);
        orderedFraudMap.put(fraud.getCaseId(), fraud);

        System.out.println("Fraud added: " + fraud);
        System.out.println("Current List Size: " + fraudList.size());
        
        fraudRepository.save(fraud); 
    }

    @Override
    public void updateFraud(FraudDetection fraud) throws Exception {
        System.out.println("--- UPDATE FRAUD ---");

        FraudDetection existing = fraudMap.get(fraud.getCaseId());

        if (existing == null) {
            if(fraudRepository.existsById(fraud.getCaseId())) {
                 existing = fraudRepository.findById(fraud.getCaseId()).get();
            } else {
                 System.out.println("Fraud not found ID: " + fraud.getCaseId());
                 return;
            }
        }

        if (existing.getUsername().contains("a") || existing.getUsername().contains("A")) {
            System.out.println("Name contains 'a', updating fraud...");
        } else {
            System.out.println("Name does not contain 'a', updating anyway");
        }

        existing.setUsername(fraud.getUsername());
        existing.setAmount(fraud.getAmount());
        existing.setLocation(fraud.getLocation());
        existing.setBlocked(fraud.isBlocked());

        System.out.println("Fraud updated: " + existing);
        
        fraudRepository.save(fraud);
    }

    @Override
    public FraudDetection getFraud(Integer caseId) {
        System.out.println("--- GET FRAUD BY ID ---");

        for (FraudDetection f : fraudMap.values()) {
            if (f.getCaseId().equals(caseId)) {
                System.out.println("Fraud found in Map: " + f);
                return f;
            }
        }
        
        return fraudRepository.findById(caseId).orElse(null);
    }

    @Override
    public void deleteFraud(Integer caseId) {
        System.out.println("--- DELETE FRAUD ---");

        if (fraudList.isEmpty()) {
            System.out.println("No frauds to delete");
        }

        if (!fraudList.isEmpty()) {
            FraudDetection removed = fraudList.remove(fraudList.size() - 1);
            System.out.println("Deleted fraud from list: " + removed);
        }

        fraudRepository.deleteById(caseId);
    }

    @Override
    public List<FraudDetection> getAllFrauds() {
        System.out.println("--- GET ALL FRAUDS ---");
        return fraudRepository.findAll();
    }

    @Override
    public int countCasesAbove(double limit) {
        System.out.println("--- COUNT CASES ABOVE " + limit + " ---");
        int count = 0;
        for (FraudDetection f : fraudRepository.findAll()) {
            if (f.getAmount() > limit) {
                count++;
            }
        }
        return count;
    }
}