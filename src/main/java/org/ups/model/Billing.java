package org.ups.model;

import java.util.Objects;

public class Billing extends BillingInfo {

    private int billingId;
    private int shippingId;
    private int userId;

    private String invoiceNumber;
    private String paymentMethod;
    private String billingStatus;
    private String createdDate;
    private String dueDate;

    private boolean status;

    public Billing() {
        System.out.println("Billing default constructor is called");
    }

    public Billing(int billingId, int shippingId, int userId,
                   String invoiceNumber,
                   double billingAmount, double taxAmount, double totalAmount,
                   String paymentMethod, String billingStatus,
                   String createdDate, String dueDate) {

        this.billingId = billingId;
        this.shippingId = shippingId;
        this.userId = userId;
        this.invoiceNumber = invoiceNumber;
        this.paymentMethod = paymentMethod;
        this.billingStatus = billingStatus;
        this.createdDate = createdDate;
        this.dueDate = dueDate;

        this.billingAmount = billingAmount;
        this.taxAmount = taxAmount;
        this.totalAmount = totalAmount;

        status = true;
        System.out.println("Billing parameterized constructor is called");
    }

    public int getBillingId() { return billingId; }
    public void setBillingId(int billingId) { this.billingId = billingId; }

    public int getShippingId() { return shippingId; }
    public void setShippingId(int shippingId) { this.shippingId = shippingId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getBillingStatus() { return billingStatus; }
    public void setBillingStatus(String billingStatus) { this.billingStatus = billingStatus; }

    public String getCreatedDate() { return createdDate; }
    public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }

    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    void testBilling() {
        billingAmount = 500.0;
        taxAmount = 50.0;
        totalAmount = 550.0;
        status = true;
    }
    
    

    @Override
	public String toString() {
		return "Billing [billingId=" + billingId + ", shippingId=" + shippingId + ", userId=" + userId
				+ ", invoiceNumber=" + invoiceNumber + ", paymentMethod=" + paymentMethod + ", billingStatus="
				+ billingStatus + ", createdDate=" + createdDate + ", dueDate=" + dueDate + ", status=" + status
				+ ", billingAmount=" + billingAmount + ", taxAmount=" + taxAmount + ", totalAmount=" + totalAmount
				+ "]";
	}
    
    

	@Override
	public int hashCode() {
		return Objects.hash(billingId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Billing other = (Billing) obj;
		return billingId == other.billingId;
	}

	public void printBillSummary() {
        System.out.println("------------- BILL SUMMARY -------------");
        System.out.println("Billing ID   : " + billingId);
        System.out.println("Shipping ID  : " + shippingId);
        System.out.println("User ID      : " + userId);
        System.out.println("Invoice No   : " + invoiceNumber);
        System.out.println("Amount       : " + billingAmount);
        System.out.println("Tax          : " + taxAmount);
        System.out.println("Total        : " + totalAmount);
        System.out.println("Payment Mode : " + paymentMethod);
        System.out.println("Status       : " + billingStatus);
        System.out.println("Created Date : " + createdDate);
        System.out.println("Due Date     : " + dueDate);
        System.out.println("----------------------------------------");
    }
}
