package org.ups.service;

import java.util.List;

import org.ups.model.FraudDetection;

public interface FraudService {

    public void addFraud(FraudDetection fraud);

    public void updateFraud(FraudDetection fraud) throws Exception;

    public FraudDetection getFraud(Integer caseId);

    public void deleteFraud(Integer caseId);

    public List<FraudDetection> getAllFrauds();
    
    // Preserving your custom logic
    public int countCasesAbove(double threshold);
}