package com.martianpay.developer;

public class GetCustomerInvoiceRequest {
    private String invoiceId;

    public GetCustomerInvoiceRequest() {
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
