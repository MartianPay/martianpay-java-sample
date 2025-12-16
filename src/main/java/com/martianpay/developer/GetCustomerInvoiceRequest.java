package com.martianpay.developer;

/**
 * Request to retrieve invoice details from the customer's perspective.
 */
public class GetCustomerInvoiceRequest {
    /**
     * Invoice ID to retrieve.
     */
    private String invoiceId;

    /**
     * Creates a new GetCustomerInvoiceRequest instance.
     */
    public GetCustomerInvoiceRequest() {
    }

    /**
     * Gets the invoice ID to retrieve.
     * @return The invoice ID
     */
    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * Sets the invoice ID to retrieve.
     * @param invoiceId The invoice ID
     */
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
