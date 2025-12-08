package org.ups.controller;

import org.ups.exception.BillingException;
import org.ups.model.Billing;
import org.ups.service.BillingService;
import org.ups.service.BillingServiceImpl;

public class BillingController {

    public static void main(String[] args) {

        BillingService service = new BillingServiceImpl();

        try {
            Billing b1 = new Billing(
                    101, 201, 301,
                    "BILL-SAI-1",
                    500.0, 50.0, 550.0,
                    "CARD", "PAID",
                    "2025-11-27", "2025-12-05"
            );

            Billing b2 = new Billing(
                    102, 202, 302,
                    "BILL-SAI-2",
                    700.0, 70.0, 770.0,
                    "CASH", "PENDING",
                    "2025-11-28", "2025-12-10"
            );

            Billing b3 = new Billing(
                    103, 203, 303,
                    "BILL-SAI-3",
                    900.0, 90.0, 990.0,
                    "UPI", "PAID",
                    "2025-11-29", "2025-12-15"
            );

            // ADD
            service.addBill(b1);
            service.addBill(b2);
            service.addBill(b3);

            // UPDATE
            Billing updated = new Billing(
                    102, 202, 302,
                    "BILL-SAI-2-UPDATED",
                    700.0, 70.0, 770.0,
                    "CASH", "PAID",
                    "2025-11-28", "2025-12-10"
            );
            service.updateBill(updated);

            // GET BY ID
            Billing fromId = service.getBillById(101);
            fromId.printBillSummary();

            // GET BY STATUS
            Billing paidBill = service.getBillByStatus("PAID");
            paidBill.printBillSummary();

            // DELETE LAST BILL
            service.deleteLastBill();

            // SORTED BY ID (Comparable)
            System.out.println("=== GET ALL BILLS (sorted by id, Comparable) ===");
            for (Billing b : service.getAllBillsSortedById()) {
                System.out.println(b);
            }

            // SORTED BY AMOUNT (Comparator)
            System.out.println("=== GET ALL BILLS (sorted by amount, Comparator) ===");
            for (Billing b : service.getAllBillsSortedByAmount()) {
                System.out.println(b);
            }

        } catch (BillingException e) {
            System.out.println("Billing error: " + e.getMessage());
        }
    }
}
