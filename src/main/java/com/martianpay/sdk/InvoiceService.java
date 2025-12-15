package com.martianpay.sdk;

import com.martianpay.developer.InvoiceDetails;
import com.martianpay.developer.ListMerchantInvoicesRequest;
import com.martianpay.developer.ListInvoicesResponse;
import com.martianpay.developer.PaymentIntent;

import java.io.IOException;

/**
 * InvoiceService provides methods for managing invoices
 */
public class InvoiceService extends MartianPayClient {

    public InvoiceService(String apiKey) {
        super(apiKey);
    }

    public InvoiceService(String apiKey, String baseUrl) {
        super(apiKey, baseUrl);
    }

    /**
     * Lists merchant invoices
     *
     * @param params Invoice list request parameters
     * @return Invoice list response
     * @throws IOException if request fails
     */
    public ListInvoicesResponse listInvoices(ListMerchantInvoicesRequest params) throws IOException {
        return sendRequestWithQuery("GET", "/v1/invoices", params, ListInvoicesResponse.class);
    }

    /**
     * Gets merchant invoice
     *
     * @param invoiceID Invoice ID
     * @return Invoice details
     * @throws IOException if request fails
     */
    public InvoiceDetails getInvoice(String invoiceID) throws IOException {
        String path = String.format("/v1/invoices/%s", invoiceID);
        return sendRequest("GET", path, null, InvoiceDetails.class);
    }

    /**
     * Gets invoice payment intent
     *
     * @param invoiceID Invoice ID
     * @return Payment intent details
     * @throws IOException if request fails
     */
    public PaymentIntent getInvoicePaymentIntent(String invoiceID) throws IOException {
        String path = String.format("/v1/invoices/%s/payment_intent", invoiceID);
        return sendRequest("GET", path, null, PaymentIntent.class);
    }

    /**
     * Downloads invoice PDF
     *
     * @param invoiceID Invoice ID
     * @return PDF bytes
     * @throws IOException if request fails
     */
    public byte[] getInvoicePDF(String invoiceID) throws IOException {
        // TODO: implement PDF download
        throw new IOException("Not implemented");
    }

    /**
     * Sends invoice to customer
     *
     * @param invoiceID Invoice ID
     * @return Updated invoice details
     * @throws IOException if request fails
     */
    public InvoiceDetails sendInvoice(String invoiceID) throws IOException {
        String path = String.format("/v1/invoices/%s/send", invoiceID);
        return sendRequest("POST", path, null, InvoiceDetails.class);
    }

    /**
     * Voids invoice
     *
     * @param invoiceID Invoice ID
     * @return Updated invoice details
     * @throws IOException if request fails
     */
    public InvoiceDetails voidInvoice(String invoiceID) throws IOException {
        String path = String.format("/v1/invoices/%s/void", invoiceID);
        return sendRequest("POST", path, null, InvoiceDetails.class);
    }
}
