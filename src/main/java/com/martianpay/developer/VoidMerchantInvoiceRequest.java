package com.martianpay.developer;

/**
 * Request to void a merchant invoice.
 */
public class VoidMerchantInvoiceRequest {
    /**
     * Unique identifier of the invoice to void.
     */
    private String invoiceId;

    public VoidMerchantInvoiceRequest() {
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
