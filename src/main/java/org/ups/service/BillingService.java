package org.ups.service;

import java.util.List;
import org.ups.exception.BillingException;
import org.ups.model.Billing;

public interface BillingService {

    void addBill(Billing bill) throws BillingException;

    void updateBill(Billing bill) throws BillingException;

    Billing getBillById(int billingId) throws BillingException;

    Billing getBillByStatus(String status) throws BillingException;

    void deleteLastBill() throws BillingException;

    List<Billing> getAllBills();

    List<Billing> getAllBillsSortedById();      // Comparable

    List<Billing> getAllBillsSortedByAmount();  // Comparator
}
