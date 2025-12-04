package org.ups.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ups.model.Billing;

public class BillingServiceImpl implements BillingService {

    String storeName = "UPS Billing Store";
    String zipCode = "78261";

    // Collections
    List<Billing> billList = new ArrayList<>();                 // ArrayList
    List<String> logHistory = new ArrayList<>();                // log messages
    Set<String> statusSet = new HashSet<>();                    // HashSet
    Map<Integer, Billing> billMap = new HashMap<>();            // HashMap
    Map<Integer, Billing> orderedBillMap = new LinkedHashMap<>(); // LinkedHashMap

    @Override
    public void addBill(Billing bill) {
        System.out.println("=== ADD BILL ===");

        if (bill.getBillingId() <= 0) {
            System.out.println("Invalid billing id");
            return;
        }

        System.out.println("Valid billingId: " + bill.getBillingId());

        // add to collections
        billList.add(bill);
        logHistory.add("Bill added: " + bill.getInvoiceNumber());
        statusSet.add(bill.getBillingStatus());
        billMap.put(bill.getBillingId(), bill);
        orderedBillMap.put(bill.getBillingId(), bill);

        System.out.println("Bill added: " + bill);
        System.out.println("Current bills (ArrayList): " + billList);
        System.out.println("Current statuses (HashSet): " + statusSet);
    }

    @Override
    public void updateBill(Billing bill) {
        System.out.println("=== UPDATE BILL ===");

        Billing existing = billMap.get(bill.getBillingId());
        if (existing == null) {
            System.out.println("Bill not found by id");
            return;
        }

        existing.setInvoiceNumber(bill.getInvoiceNumber());
        existing.setPaymentMethod(bill.getPaymentMethod());
        existing.setBillingStatus(bill.getBillingStatus());
        existing.setCreatedDate(bill.getCreatedDate());
        existing.setDueDate(bill.getDueDate());

        System.out.println("Bill updated: " + existing);
    }

    @Override
    public Billing getBillById(int billingId) {
        System.out.println("=== GET BILL BY ID === " + billingId);
        Billing b = billMap.get(billingId);
        if (b == null) {
            System.out.println("No bill found with id " + billingId);
        }
        return b;
    }

    @Override
    public Billing getBillByStatus(String status) {
        System.out.println("=== GET BILL BY STATUS === " + status);

        for (Billing b : billList) {
            if (b.getBillingStatus() != null &&
                b.getBillingStatus().equalsIgnoreCase(status)) {
                System.out.println("Found bill: " + b);
                return b;
            }
        }

        System.out.println("No bill found with status " + status);
        return null;
    }

    @Override
    public void deleteLastBill() {
        System.out.println("=== DELETE LAST BILL ===");

        if (billList.isEmpty()) {
            System.out.println("No bills to delete");
            return;
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
}
