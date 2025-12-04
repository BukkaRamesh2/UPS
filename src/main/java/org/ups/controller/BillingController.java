package org.ups.controller;

import org.ups.model.Billing;
import org.ups.service.BillingService;
import org.ups.service.BillingServiceImpl;

public class BillingController {

    public static void main(String[] args) {

        BillingService service = new BillingServiceImpl();

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

        service.addBill(b1);
        service.addBill(b2);
        service.addBill(b3);

        Billing updated = new Billing(
                102, 202, 302,
                "BILL-SAI-2-UPDATED",
                700.0, 70.0, 770.0,
                "CASH", "PAID",
                "2025-11-28", "2025-12-10"
        );
        service.updateBill(updated);

        Billing fromId = service.getBillById(101);
        if (fromId != null) {
            fromId.printBillSummary();
            System.out.println(fromId);   // uses Billing.toString()
        }

        Billing paidBill = service.getBillByStatus("PAID");
        if (paidBill != null) {
            paidBill.printBillSummary();
            System.out.println(paidBill); // uses Billing.toString()
        }

        service.deleteLastBill();

        service.getAllBills();
    }
}
