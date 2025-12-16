package com.martianpay.developer;

/**
 * Request to download an invoice PDF from the customer's perspective.
 */
public class DownloadCustomerInvoicePDFRequest {
    /**
     * Invoice ID to download.
     */
    private String invoiceId;

    /**
     * Creates a new DownloadCustomerInvoicePDFRequest instance.
     */
    public DownloadCustomerInvoicePDFRequest() {
    }

    /**
     * Gets the unique identifier of the invoice to download.
     * @return The invoice ID
     */
    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * Sets the unique identifier of the invoice to download.
     * @param invoiceId The invoice ID
     */
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
