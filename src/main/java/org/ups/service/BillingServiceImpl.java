package org.ups.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.ups.exception.BillingException;
import org.ups.model.Billing;
import org.ups.repository.BillingRepository;

@Service
public class BillingServiceImpl implements BillingService {

    private final BillingRepository billingRepository;

    public BillingServiceImpl(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    @Override
    public Billing createBill(Billing billing) throws BillingException {
        if (billing == null) {
            throw new BillingException("Billing object is null");
        }
        return billingRepository.save(billing);
    }

    @Override
    public List<Billing> getAllBills() throws BillingException {
        List<Billing> list = billingRepository.findAll();
        if (list.isEmpty()) {
            throw new BillingException("No bills available");
        }
        return list;
    }

    @Override
    public Billing getBillById(int id) throws BillingException {
        return billingRepository.findById(id)
                .orElseThrow(() -> new BillingException("Bill with id " + id + " not found"));
    }

    @Override
    public Billing updateBill(int id, Billing updated) throws BillingException {
        Billing existing = getBillById(id);   // throws if not found
        updated.setBillingId(existing.getBillingId());
        return billingRepository.save(updated);
    }

    @Override
    public void deleteBill(int id) throws BillingException {
        Billing existing = getBillById(id);   // throws if not found
        billingRepository.delete(existing);
    }
}
