package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to create a payment intent from an existing invoice.
 */
public class PaymentIntentInvoiceCreateRequest {
    /**
     * Unique identifier of the invoice to create a payment intent for.
     */
    @SerializedName("invoice_id")
    private String invoiceId;

    public PaymentIntentInvoiceCreateRequest() {
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
