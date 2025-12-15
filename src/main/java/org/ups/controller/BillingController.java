package org.ups.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ups.exception.BillingException;
import org.ups.model.Billing;
import org.ups.service.BillingService;

@RestController
@RequestMapping("/billing")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    // CREATE  - POST /billing
    @PostMapping
    public Billing createBill(@RequestBody Billing billing) throws BillingException {
        return billingService.createBill(billing);
    }

    // READ ALL - GET /billing
    @GetMapping
    public List<Billing> getAllBills() throws BillingException {
        return billingService.getAllBills();
    }

    // READ ONE - GET /billing/{id}
    @GetMapping("/{id}")
    public Billing getBillById(@PathVariable int id) throws BillingException {
        return billingService.getBillById(id);
    }

    // UPDATE - PUT /billing/{id}
    @PutMapping("/{id}")
    public Billing updateBill(@PathVariable int id,
                              @RequestBody Billing updated) throws BillingException {
        return billingService.updateBill(id, updated);
    }

    // DELETE - DELETE /billing/{id}
    @DeleteMapping("/{id}")
    public String deleteBill(@PathVariable int id) throws BillingException {
        billingService.deleteBill(id);
        return "Bill deleted with id: " + id;
    }
}
