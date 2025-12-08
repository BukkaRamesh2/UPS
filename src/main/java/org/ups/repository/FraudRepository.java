package org.ups.repository;

import java.util.List;
import org.ups.model.FraudDetection;

public interface FraudRepository {
    FraudDetection save(FraudDetection f);

    List<FraudDetection> findAll();

    FraudDetection findByCaseId(Integer caseId); // returns null if not found
}
