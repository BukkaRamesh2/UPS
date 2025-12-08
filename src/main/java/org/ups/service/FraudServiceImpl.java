package org.ups.service;

import java.util.List;
import org.ups.model.FraudDetection;
import org.ups.repository.FraudRepository;
import org.ups.repository.FraudRepositoryImpl;

public class FraudServiceImpl implements FraudService {

    private final FraudRepository repo = new FraudRepositoryImpl();

    @Override
    public FraudDetection save(FraudDetection f) {
        if (f.getCaseId() == null) {
            f.setCaseId(repo.findAll().size() + 1); // generate simple ID
        }
        return repo.save(f);
    }

    @Override
    public List<FraudDetection> findAll() {
        return repo.findAll();
    }

    @Override
    public FraudDetection findByCaseId(Integer caseId) {
        return repo.findByCaseId(caseId);
    }
}
