package com.martianpay.developer;

public class DownloadCustomerInvoicePDFRequest {
    private String invoiceId;

    public DownloadCustomerInvoicePDFRequest() {
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
