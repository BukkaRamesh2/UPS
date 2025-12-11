package org.ups.service;

import java.util.List;

import org.ups.exception.BillingException;
import org.ups.model.Billing;

public interface BillingService {

    Billing createBill(Billing billing) throws BillingException;

    List<Billing> getAllBills() throws BillingException;

    Billing getBillById(int id) throws BillingException;

    Billing updateBill(int id, Billing updated) throws BillingException;

    void deleteBill(int id) throws BillingException;
}
