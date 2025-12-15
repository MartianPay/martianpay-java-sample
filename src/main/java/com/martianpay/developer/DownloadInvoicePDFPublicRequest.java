package com.martianpay.developer;

public class DownloadInvoicePDFPublicRequest {
    private String invoiceId;

    public DownloadInvoicePDFPublicRequest() {
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
