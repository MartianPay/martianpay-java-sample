package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PaymentIntentInvoiceCreateRequest {
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
