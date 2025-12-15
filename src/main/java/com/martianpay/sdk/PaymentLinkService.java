package com.martianpay.sdk;

import com.martianpay.developer.PaymentLink;
import com.martianpay.developer.PaymentLinkCreateRequest;
import com.martianpay.developer.PaymentLinkListRequest;
import com.martianpay.developer.PaymentLinkListResponse;
import com.martianpay.developer.PaymentLinkUpdateRequest;

import java.io.IOException;

/**
 * PaymentLinkService provides methods for managing payment links
 */
public class PaymentLinkService extends MartianPayClient {

    public PaymentLinkService(String apiKey) {
        super(apiKey);
    }

    public PaymentLinkService(String apiKey, String baseUrl) {
        super(apiKey, baseUrl);
    }

    /**
     * Lists payment links with pagination
     *
     * @param params Payment link list request parameters
     * @return Payment link list response
     * @throws IOException if request fails
     */
    public PaymentLinkListResponse listPaymentLinks(PaymentLinkListRequest params) throws IOException {
        return sendRequestWithQuery("GET", "/v1/payment_links", params, PaymentLinkListResponse.class);
    }

    /**
     * Creates a payment link
     *
     * @param params Payment link creation parameters
     * @return Created payment link
     * @throws IOException if request fails
     */
    public PaymentLink createPaymentLink(PaymentLinkCreateRequest params) throws IOException {
        return sendRequest("POST", "/v1/payment_links", params, PaymentLink.class);
    }

    /**
     * Retrieves payment link details
     *
     * @param linkID Payment link ID
     * @return Payment link details
     * @throws IOException if request fails
     */
    public PaymentLink getPaymentLink(String linkID) throws IOException {
        String path = String.format("/v1/payment_links/%s", linkID);
        return sendRequest("GET", path, null, PaymentLink.class);
    }

    /**
     * Updates payment link active status
     *
     * @param linkID Payment link ID
     * @param params Update parameters
     * @return Updated payment link
     * @throws IOException if request fails
     */
    public PaymentLink updatePaymentLink(String linkID, PaymentLinkUpdateRequest params) throws IOException {
        String path = String.format("/v1/payment_links/%s", linkID);
        return sendRequest("POST", path, params, PaymentLink.class);
    }

    /**
     * Deletes inactive payment link
     *
     * @param linkID Payment link ID
     * @throws IOException if request fails
     */
    public void deletePaymentLink(String linkID) throws IOException {
        String path = String.format("/v1/payment_links/%s", linkID);
        sendRequest("DELETE", path, null, Void.class);
    }
}
