package com.martianpay.developer;

public class DownloadMerchantInvoicePDFRequest {
    private String invoiceId;

    public DownloadMerchantInvoicePDFRequest() {
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
