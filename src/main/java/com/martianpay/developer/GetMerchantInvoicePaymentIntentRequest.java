package com.martianpay.developer;

public class GetMerchantInvoicePaymentIntentRequest {
    private String invoiceId;

    public GetMerchantInvoicePaymentIntentRequest() {
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
