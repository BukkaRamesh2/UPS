package org.ups.controller;

import org.ups.model.Billing;

public class BillingController {

    public static void main(String[] args) {

        Billing billing = new Billing(
                101,
                201,
                301,
                "BILL-SAI-VENKAT",
                500.0,
                50.0,
                550.0,
                "CARD",
                "PAID",
                "2025-11-27",
                "2025-12-05"
        );

        billing.printBillSummary();
    }
}
