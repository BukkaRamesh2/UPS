package org.ups.repository;

import java.util.ArrayList;
import java.util.List;
import org.ups.model.FraudDetection;

public class FraudRepositoryImpl implements FraudRepository {

    private final List<FraudDetection> store = new ArrayList<>();

    @Override
    public FraudDetection save(FraudDetection f) {
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getCaseId().equals(f.getCaseId())) {
                store.remove(i);
                break;
            }
        }
        store.add(f);
        return f;
    }

    @Override
    public List<FraudDetection> findAll() {
        return new ArrayList<>(store);
    }

    @Override
    public FraudDetection findByCaseId(Integer caseId) {
        for (FraudDetection f : store) {
            if (f.getCaseId().equals(caseId))
                return f;
        }
        return null;
    }
}
