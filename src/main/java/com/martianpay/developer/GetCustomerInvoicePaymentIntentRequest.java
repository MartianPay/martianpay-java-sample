package com.martianpay.developer;

public class GetCustomerInvoicePaymentIntentRequest {
    private String invoiceId;

    public GetCustomerInvoicePaymentIntentRequest() {
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
