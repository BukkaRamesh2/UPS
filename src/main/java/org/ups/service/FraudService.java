package org.ups.service;

import java.util.List;
import org.ups.model.FraudDetection;

public interface FraudService {
    FraudDetection save(FraudDetection f);

    List<FraudDetection> findAll();

    FraudDetection findByCaseId(Integer caseId);
}
