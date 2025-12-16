package com.martianpay.developer;

/**
 * Request to send a merchant invoice to a customer.
 */
public class SendMerchantInvoiceRequest {
    /**
     * Unique identifier of the invoice to be sent.
     */
    private String invoiceId;

    public SendMerchantInvoiceRequest() {
    }

    /**
     * Gets the invoice ID to be sent.
     * @return The invoice ID
     */
    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * Sets the invoice ID to be sent.
     * @param invoiceId The invoice ID
     */
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
