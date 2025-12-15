package com.martianpay.developer;

public class SendMerchantInvoiceRequest {
    private String invoiceId;

    public SendMerchantInvoiceRequest() {
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
