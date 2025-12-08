package org.ups.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ups.exception.BillingException;
import org.ups.exception.InvalidBillingAmountException;
import org.ups.model.Billing;
import org.ups.util.BillingAmountComparator;

public class BillingServiceImpl implements BillingService {

    String storeName = "UPS Billing Store";
    String zipCode = "78261";

    // Collections
    List<Billing> billList = new ArrayList<>();
    List<String> logHistory = new ArrayList<>();
    Set<String> statusSet = new HashSet<>();
    Map<Integer, Billing> billMap = new HashMap<>();
    Map<Integer, Billing> orderedBillMap = new LinkedHashMap<>();

    @Override
    public void addBill(Billing bill) throws BillingException {
        System.out.println("=== ADD BILL ===");

        if (bill == null) {
            throw new BillingException("Bill cannot be null");
        }
        if (bill.getBillingId() <= 0) {
            throw new BillingException("Invalid billing id: " + bill.getBillingId());
        }
        if (bill.getBillingAmount() <= 0) {
            throw new InvalidBillingAmountException(
                    "Amount must be positive for bill " + bill.getBillingId());
        }

        System.out.println("Valid billing id: " + bill.getBillingId());

        // add to collections
        billList.add(bill);
        logHistory.add("Bill added: " + bill.getInvoiceNumber());
        statusSet.add(bill.getBillingStatus());
        billMap.put(bill.getBillingId(), bill);
        orderedBillMap.put(bill.getBillingId(), bill);

        System.out.println("Current bills (ArrayList): " + billList);
        System.out.println("Current statuses (HashSet): " + statusSet);
    }

    @Override
    public void updateBill(Billing bill) throws BillingException {
        System.out.println("=== UPDATE BILL ===");

        if (bill == null) {
            throw new BillingException("Bill cannot be null");
        }

        Billing existing = billMap.get(bill.getBillingId());
        if (existing == null) {
            throw new BillingException("Bill not found for id: " + bill.getBillingId());
        }

        existing.setInvoiceNumber(bill.getInvoiceNumber());
        existing.setPaymentMethod(bill.getPaymentMethod());
        existing.setBillingStatus(bill.getBillingStatus());
        existing.setBillingAmount(bill.getBillingAmount());
        existing.setTaxAmount(bill.getTaxAmount());
        existing.setTotalAmount(bill.getTotalAmount());

        System.out.println("Bill updated: " + existing);
    }

    @Override
    public Billing getBillById(int billingId) throws BillingException {
        System.out.println("=== GET BILL BY ID ===");

        Billing bill = billMap.get(billingId);
        if (bill == null) {
            throw new BillingException("No bill found for id: " + billingId);
        }
        return bill;
    }

    @Override
    public Billing getBillByStatus(String status) throws BillingException {
        System.out.println("=== GET BILL BY STATUS ===");

        for (Billing b : billList) {
            if (b.getBillingStatus().equalsIgnoreCase(status)) {
                return b;
            }
        }
        throw new BillingException("No bill with status: " + status);
    }

    @Override
    public void deleteLastBill() throws BillingException {
        System.out.println("=== DELETE LAST BILL ===");

        if (billList.isEmpty()) {
            throw new BillingException("No bills to delete");
        }

        Billing removed = billList.remove(billList.size() - 1);
        billMap.remove(removed.getBillingId());
        orderedBillMap.remove(removed.getBillingId());

        System.out.println("Deleted bill: " + removed);
    }

    @Override
    public List<Billing> getAllBills() {
        System.out.println("=== GET ALL BILLS ===");
        for (Billing b : billList) {
            System.out.println("Bill: " + b);
        }
        return billList;
    }

    @Override
    public List<Billing> getAllBillsSortedById() {
        List<Billing> copy = new ArrayList<>(billList);
        Collections.sort(copy);               // uses Comparable (Billing.compareTo)
        return copy;
    }

    @Override
    public List<Billing> getAllBillsSortedByAmount() {
        List<Billing> copy = new ArrayList<>(billList);
        copy.sort(new BillingAmountComparator()); // uses Comparator
        return copy;
    }
}
