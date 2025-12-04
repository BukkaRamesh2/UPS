package org.ups.service;

import org.ups.model.Billing;
import java.util.List;

public interface BillingService {

    void addBill(Billing billing);

    void updateBill(Billing billing);

    Billing getBillById(int billingId);

    Billing getBillByStatus(String status);

    void deleteLastBill();

    List<Billing> getAllBills();
}
